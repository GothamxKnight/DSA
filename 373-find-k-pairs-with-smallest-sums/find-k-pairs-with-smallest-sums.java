class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            return a[2]-b[2];
        });
        int n=nums1.length;
        for(int i=0;i<n;i++){
            int []arr={i,0,nums1[i]+nums2[0]};
            pq.add(arr);
        }
        List<List<Integer>> res=new ArrayList<>();
        while(k-->0){
            int temp[]=pq.poll();
            if(temp[1]<nums2.length-1){
                int new_arr[]={temp[0],temp[1]+1,nums1[temp[0]]+nums2[temp[1]+1]};
                pq.add(new_arr);
            }
            List<Integer> list=new ArrayList<>(Arrays.asList(nums1[temp[0]],nums2[temp[1]]));
            res.add(new ArrayList<>(list));
        }
        return res;
    }
}