class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> res=new HashSet<>();
        Arrays.sort(nums);
        permutation(nums,0,new ArrayList<>(),res);
        List<List<Integer>>result= new ArrayList<>(res);
        return result;
    }
    static void permutation(int []nums,int index,List<Integer> curr,Set<List<Integer>> result){
        result.add(new ArrayList<>(curr));
        for(int i=index;i<nums.length;i++){
            curr.add(nums[i]);
            permutation(nums,i+1,curr,result);
            curr.remove(curr.size()-1);
        }
    }
}