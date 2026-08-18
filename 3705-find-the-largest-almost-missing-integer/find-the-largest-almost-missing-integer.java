class Solution {
    public int largestInteger(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<=n-k;i++){
            HashMap<Integer,Integer> temp=new HashMap<>();
            for(int j=i;j<i+k;j++){
                if(!temp.containsKey(nums[j])){
                    temp.put(nums[j],1);
                    map.put(nums[j],map.getOrDefault(nums[j],0)+1);
                }
            }
        }
        int max=-1;
        for(Map.Entry<Integer,Integer> temp:map.entrySet()){
            if(temp.getValue()==1){
                max=Math.max(max,temp.getKey());
            }
        }
        return max;
    }
}