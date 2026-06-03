class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> shal=new HashSet<>();
        Arrays.sort(candidates);
        combination(candidates,0,target,new ArrayList<>(),shal,0);
        return new ArrayList<>(shal);
    }
    static void combination(int[]arr,int index,int target,List<Integer> curr ,Set<List<Integer>> shal,int sum){
        if(sum>target)return ;
        if(sum==target){
            shal.add(new ArrayList<>(curr));
        }
        for(int i=index;i<arr.length;i++){
            if(i>index && arr[i]==arr[i-1])continue;
            curr.add(arr[i]);
            combination(arr,i+1,target,curr,shal,sum+arr[i]);
            curr.remove(curr.size()-1);
        }
    }
}