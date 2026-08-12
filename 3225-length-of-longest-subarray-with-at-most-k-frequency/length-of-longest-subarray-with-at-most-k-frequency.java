class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int s=0,e=0;
        int max_len=0;
        int n=nums.length;
        while(e<n){
            int digit=nums[e];
            if(map.containsKey(digit)){
                if(map.get(digit)==k){
                    max_len=Math.max(max_len,e-s);
                    while(s<e && nums[s]!=digit){
                        map.put(nums[s],map.get(nums[s])-1);
                        s++;
                    }
                    if(s<e){
                        map.put(nums[s],map.get(nums[s])-1);
                        s++;
                    }
                    map.put(digit,map.get(digit)+1);
                }else{
                    map.put(digit,map.get(digit)+1);
                }
            }else{
                map.put(digit,1);
            }
            e++;
        }
        max_len=Math.max(max_len,e-s);
        return max_len;
    }
}