class Solution {
    public int maxChunksToSorted(int[] arr) {
        int nums[]=arr.clone();
        Arrays.sort(nums);
        int cnt=0;
        int n=arr.length;
        int i=0;
        Map<Integer,Integer>map1=new HashMap<>();
        Map<Integer,Integer>map2=new HashMap<>();
        while(i<n){
            map1.put(nums[i],map1.getOrDefault(nums[i],0)+1);
            map2.put(arr[i],map2.getOrDefault(arr[i],0)+1);
            if(map1.equals(map2)){
                cnt++;
                map1.clear();
                map2.clear();
            }
            i++;
        }
        return cnt;
    }
}