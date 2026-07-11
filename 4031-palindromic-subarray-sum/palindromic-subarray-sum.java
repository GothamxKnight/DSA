class Solution {
    public long getSum(int[] nums) {
        return manacherAlgo(nums);
    }
    static long manacherAlgo(int []nums){
        int n=nums.length;
        int []temp=new int[2*n+1];
        for(int i=0;i<2*n+1;i++){
            if(i%2==0)temp[i]=0;
            else temp[i]=nums[(i-1)/2];
        }
        int []p=new int[2*n+1];
        int l=0,r=0;
        p[0]=1;
        for(int i=1;i<2*n+1;i++){
            if(i<r){
                p[i]=Math.min(r-i,p[l+r-i]);
            }else{
                p[i]=0;
            }
            while(i-p[i]>=0 && i+p[i]<2*n+1 && temp[i-p[i]]==temp[i+p[i]]){
                p[i]++;
            }
            if(i+p[i]>r){
                l=i-p[i]+1;
                r=i+p[i]-1;
            }
        }
        long []prefix=new long[2*n+2];
        for(int i=1;i<2*n+2;i++){
            prefix[i]=prefix[i-1]+temp[i-1];
        }
        long max=0;
        for(int i=0;i<2*n+1;i++){
            int radi=p[i]-1;
            long sum=prefix[i+radi+1]-prefix[i-radi];
            max=Math.max(sum,max);
        }
        return max;
    }
}