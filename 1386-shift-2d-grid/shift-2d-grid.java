class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        int flatlist[]=new int[n*m];
        for(int i=0;i<n*m;i++){
            flatlist[i]=grid[i/m][i%m];
        }
        List<List<Integer>> res=new ArrayList<>();
        k=k%(n*m);
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n*m;i++){
            int idx=(i-k+n*m)%(n*m);
            list.add(flatlist[idx]);
            if(list.size()==m){
                res.add(new ArrayList<>(list));
                list=new ArrayList<>();
            }
        }
        return res;
    }
}