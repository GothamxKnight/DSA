class Solution {
    public int[] maxDepthAfterSplit(String s) {
        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();
        int p1=0,p2=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                if(p1<p2){
                    s1.push(i);
                    p1++;
                }else{
                    s2.push(i);
                    p2++;
                }
            }else{
                if(p1>p2){
                    s1.push(i);
                    p1--;
                }else{
                    s2.push(i);
                    p2--;
                }
            }
        }
        int res[]=new int[s.length()];
        while(!s1.isEmpty()){
            res[s1.pop()]=1;
        }
        while(!s2.isEmpty()){
            res[s2.pop()]=0;
        }
        return res;
    }
}