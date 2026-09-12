class Solution {
    public static class interval{
        int st,end,idx,w;
        interval(int start,int end,int weight,int index){
            st=start;
            this.end=end;
            idx=index;
            w=weight;
        }
    }
    public static class State{
        long sum;
        List<Integer> index;
        State(long sum){
            this.sum=sum;
            index=new ArrayList<>();
        }
        State(State prev,int newidx,int weight){
            this.sum=prev.sum+weight;
            this.index=new ArrayList<>(prev.index);
            this.index.add(newidx);
            Collections.sort(this.index);
        }
    }
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n=intervals.size();
        interval []arr=new interval[n];
        for(int i=0;i<n;i++){
            int st=intervals.get(i).get(0);
            int end=intervals.get(i).get(1);
            int w=intervals.get(i).get(2);
            arr[i]=new interval(st,end,w,i);
        }
        Arrays.sort(arr,(a,b)->{
            if(a.end==b.end)return a.st-b.st;
            return a.end-b.end;
        });
        State[][]dp=new State[5][n+1];
        for(int i=0;i<5;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=new State(0);
            }
        }

        for(int m=1;m<5;m++){
            for(int i=1;i<=n;i++){
                State best=dp[m][i-1];
                long max=best.sum;
                int index=binarysearch(arr,arr[i-1].st,i-2);
                
                long curr=arr[i-1].w+dp[m-1][index].sum;

                if(curr>max){
                    best=new State(dp[m-1][index],arr[i-1].idx,arr[i-1].w);
                }else if (curr==max && curr>0){
                    State candidate=new State(dp[m-1][index],arr[i-1].idx,arr[i-1].w);
                    if(issmaller(candidate,best)){
                        best=candidate;
                    }
                }
                dp[m][i]=best;
            }
        }
        List<Integer> idx=dp[4][n].index;
        int []res=new int[idx.size()];
        for(int i=0;i<idx.size();i++){
            res[i]=idx.get(i);
        }
        return res;
    }
    static boolean issmaller(State candidate,State best){
        List<Integer> cand=candidate.index;
        List<Integer> bst=best.index;
        for(int i=0;i<Math.min(cand.size(),bst.size());i++){
            if(cand.get(i)<bst.get(i))return true;
            if(cand.get(i)>bst.get(i))return false;
        }
        return cand.size()<bst.size();
    }
    static int binarysearch(interval[]arr,int target,int end){
        int i=0;
        int ans=0;
        while(i<=end){
            int mid=(i+end)/2;
            if(arr[mid].end<target){
                ans=mid+1;
                i=mid+1;
            }else{
                end=mid-1;
            }
        }
        return ans;
    }
}