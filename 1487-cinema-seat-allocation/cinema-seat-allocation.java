class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int arr[]:reservedSeats){
            map.putIfAbsent(arr[0],new ArrayList<>());
            map.get(arr[0]).add(arr[1]);
        }
        int total=2*(n-map.size());
        for(Map.Entry<Integer,List<Integer>> temp:map.entrySet()){
            Set<Integer> set=new HashSet<>(temp.getValue());
            boolean f=true,s=true,t=true;
            int cnt=3;
            if(set.contains(2)||set.contains(3)||set.contains(4)||set.contains(5)){
                f=false;
                cnt--;
            }
            if(set.contains(6)||set.contains(7)||set.contains(4)||set.contains(5)){
                s=false;
                cnt--;
            }
            if(set.contains(6)||set.contains(7)||set.contains(8)||set.contains(9)){
                t=false;
                cnt--;
            }
            if(cnt==1 || cnt==2){
                total+=1;
            }else if(cnt==3){
                total+=2;
            }
        }
        return total;
    }
}