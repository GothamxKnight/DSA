class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list=new ArrayList<>();
        if(n==1){
            list.add(0);
            list.add(1);
            return list;
        }
        list=grayCode(n-1);
        List<Integer> temp=reverse(list);
        for(int i=0;i<temp.size();i++){
            int val=(int)Math.pow(2,n-1);
            list.add(temp.get(i)+val);
        }
        return list;
    }
    static List<Integer> reverse(List<Integer> list){
        List<Integer> res=new ArrayList<>();
        for(int i=list.size()-1;i>=0;i--){
            res.add(list.get(i));
        }
        return res;
    }
}