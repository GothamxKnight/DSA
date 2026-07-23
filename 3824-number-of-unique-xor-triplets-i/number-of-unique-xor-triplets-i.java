class Solution {
    public int uniqueXorTriplets(int[] nums) {
        if(nums.length<=2)return nums.length;
        return 2*Integer.highestOneBit(nums.length);
    }
}