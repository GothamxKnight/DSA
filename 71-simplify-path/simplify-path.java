class Solution {
    public String simplifyPath(String path) {
        String simplifyPath[]=path.split("/+");
        Deque<String> dq=new ArrayDeque<>();
        for(String directory:simplifyPath){
            if(directory.equals("..")){
                if(!dq.isEmpty()){
                    dq.pollLast();
                }
            }else if(!directory.equals(".") && !directory.isEmpty()){
                dq.addLast(directory);
            }
        }
        StringBuilder res=new StringBuilder();
        res.append("/");
        while(!dq.isEmpty()){
            res.append(dq.pollFirst());
            if(!dq.isEmpty())res.append("/");
        }
        return res.toString();
    }
}