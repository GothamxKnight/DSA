class Solution {
    public int[] shortestToChar(String s, char c) {
        List<Integer> index=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==c){
                index.add(i);
            }
        }
        int res[]=new int[s.length()];
        for(int i=0;i<s.length();i++){
            int min=Integer.MAX_VALUE;
            for(Integer a:index){
                min=Math.min(min,Math.abs(i-a));
            }
            res[i]=min;
        }
        return res;
    }
}