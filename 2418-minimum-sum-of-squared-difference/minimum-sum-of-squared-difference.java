class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int diff_arr[] = new int[n];
        long sum = 0l;
        int max=0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            diff_arr[i] = diff;
            sum += (long) diff;
            max=Math.max(max,diff);
        }
        long k=(long)(k1+k2);
        Arrays.sort(diff_arr);
        if(sum<=k)return 0l;
        int[] bucket = new int[max + 1];
        for (int d : diff_arr) {
            bucket[d]++;
        }
        for(int d=max ;d>0 && k>0;d--){
            if(bucket[d]==0)continue;
            long take = Math.min((long) bucket[d], k);
            
            bucket[d] -= take;
            bucket[d - 1] += take;
            k -= take;
        }
        long res=0l;
        for(int d=1;d<=max;d++){
            if(bucket[d]>0){
                res+=(long)bucket[d]*(long)d*d;
            }
        }
        return res;
    }

}