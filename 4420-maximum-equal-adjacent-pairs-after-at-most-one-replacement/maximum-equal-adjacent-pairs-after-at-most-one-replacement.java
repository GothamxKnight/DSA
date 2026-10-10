class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {
        int basepairs=0;
        int max_cnt=0;
        Map<List<Integer>,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                basepairs++;
            }else{
                List<Integer> list=new ArrayList<>();
                list.add(Math.min(nums[i],nums[i+1]));
                list.add(Math.max(nums[i],nums[i+1]));
                int new_cnt=map.getOrDefault(list,0)+1;
                map.put(list,new_cnt);
                max_cnt=Math.max(max_cnt,new_cnt);
            }
        }
        return basepairs+max_cnt;
    }
}