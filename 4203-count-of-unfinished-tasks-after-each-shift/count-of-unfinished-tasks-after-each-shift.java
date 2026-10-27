class Solution {
    public int[] countTasks(int[] tasks, int[] shifts) {
        int n=tasks.length;
        int m=shifts.length;
        long prefix[]=new long[n+1];
        long total=0;
        for(int i=1;i<=n;i++){
            prefix[i]=prefix[i-1]+tasks[i-1];
            total+=tasks[i-1];
        }
        int res[]=new int[m];
        long avl_time=0;
        for(int i=0;i<m;i++){
            avl_time+=shifts[i];
            if(avl_time>=total){
                res[i]=0;
                avl_time=0;
            }else{
                int index=binarySearch(prefix,avl_time)-1;
                res[i]=n-index;
            }
        }
        return res;
    }
    static int binarySearch(long num[],long target){
        int i=0,j=num.length;
        while(i<j){
            int mid=i+(j-i)/2;
            if(num[mid]>target){
                j=mid;
            }else{
                i=mid+1;
            }
        }
        return i;
    }
}