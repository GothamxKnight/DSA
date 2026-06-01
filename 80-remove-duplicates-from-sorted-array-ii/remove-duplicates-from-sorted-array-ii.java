class Solution {
    public int removeDuplicates(int[] nums) {
        Map<Integer,Integer>map=new HashMap<>();
        List<Integer> list=new ArrayList<>();
        for(int data:nums){
            if(!map.containsKey(data)){
                list.add(data);
            }
            map.put(data,map.getOrDefault(data,0)+1);
        }
        int j=0;
        for(int i=0;i<list.size();i++){
            int key=list.get(i);
            if(map.get(key)<2){
                nums[j++]=key;
            }else{
                nums[j++]=key;
                nums[j++]=key;
            }
        }
        return j;
    }
}