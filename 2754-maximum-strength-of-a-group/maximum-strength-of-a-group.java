class Solution {
    public long maxStrength(int[] nums) {
        long res=0;
        List<Integer> negNum=new ArrayList<>();
        int cnt=0;
        for(int a:nums){
            if(a==0)cnt++;
            if(a>0){
                if(res==0)res=1;
                res*=a;
            }
            if(a<0){
                negNum.add(a);
            }
        }
        long temp=1;
        long max=Long.MIN_VALUE;
        Collections.sort(negNum);
        for(int a:negNum){
            temp*=a;
            max=Math.max(max,temp);
        }
        if(res==0){
            if(cnt>0 && max<0)return 0;
            return max;
        }
        return res*Math.max(max,1);
    }
}