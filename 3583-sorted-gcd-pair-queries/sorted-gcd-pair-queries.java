class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int n=nums.length;
        int max=0;
        for(int a:nums)max=Math.max(max,a);
        int freq[]=new int[max+1];
        for(int a:nums)freq[a]++;
        long pair_count[]=new long[max+1];
        for(int i=max;i>0;i--){
            long cnt=0;
            for(int j=i;j<=max;j+=i){
                cnt+=freq[j];
            }
            long total_pairs=(cnt*(cnt-1))/2;
            for(int j=2*i;j<=max;j+=i){
                total_pairs-=pair_count[j];
            }
            pair_count[i]=total_pairs;
        }
        long prefix[]=new long[max+1];
        prefix[1]=pair_count[1];
        for(int i=2;i<max+1;i++){
            prefix[i]=prefix[i-1]+pair_count[i];
        }
        int m=queries.length;
        int res[]=new int[m];
        for(int i=0;i<m;i++){
            res[i]=binarysearch(prefix,queries[i]+1);
        }
        return res;
    }
    static int binarysearch(long []arr,long target){
        int i=0,j=arr.length-1;
        while(i<j){
            int mid=(i+j)/2;
            if(arr[mid]>target){
                j=mid;
            }else if(arr[mid]<target){
                i=mid+1;
            }else{
                while(mid>=0 && arr[mid]==target){
                    mid--;
                }
                return mid+1;
            }
        }
        return i;
    }
}