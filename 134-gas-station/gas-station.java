class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int total=0;
        for (int i=0;i<n;i++){
            total+=gas[i]-cost[i];
        }
        if(total<0)return -1;
        
        int i=0;
        while(i<2*n){
            if(gas[i%n]>=cost[i%n]){
                total=0;
                int st=i;
                while(i<2*n){
                    total+=gas[i%n]-cost[i%n];
                    if(total<0)break;
                    if(st==i%n && i!=st)return st;
                    i++;
                }
            }
            i++;
        }
        return -1;
    }
}