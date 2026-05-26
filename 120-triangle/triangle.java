class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==1){
            return triangle.get(0).get(0);
        }
        if(triangle.size()==2){
            return Math.min(triangle.get(1).get(0)+triangle.get(0).get(0),triangle.get(1).get(1)+triangle.get(0).get(0));
        }
        List<int[]> dp=new ArrayList<>();
        dp.add(new int[]{triangle.get(0).get(0)});
        dp.add(new int[]{triangle.get(1).get(0)+dp.get(0)[0],triangle.get(1).get(1)+dp.get(0)[0]});
        for(int i=2;i<triangle.size();i++){
            int []temp=dp.get(i-1);
            int res[]=new int[i+1];
            Arrays.fill(res,Integer.MAX_VALUE);
            for(int j=0;j<temp.length;j++){
                res[j]=Math.min(triangle.get(i).get(j)+temp[j],res[j]);
                res[j+1]=Math.min(triangle.get(i).get(j+1)+temp[j],res[j+1]);
            }
            dp.add(res);
        }
        int res=Integer.MAX_VALUE;
        int temp[]=dp.get(dp.size()-1);
        for(int a:temp){
            res=Math.min(res,a);
        }
        return res;
    }
}