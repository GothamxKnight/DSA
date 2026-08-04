class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min=nums[0],max=nums[0];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int a:nums){
            max=Math.max(a,max);
            min=Math.min(a,min);
            map.put(a,1);
        }
        List<Integer>list=new ArrayList<>();
        for(int i=min;i<=max;i++){
            if(!map.containsKey(i)){
                list.add(i);
            }
        }
        return list;
    }
}