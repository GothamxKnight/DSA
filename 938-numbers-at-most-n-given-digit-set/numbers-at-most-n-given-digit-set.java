class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int total=0;
        int curr_len=1;
        while(curr_len<len(n)){
            total+=Math.pow(digits.length,curr_len);
            curr_len++;
        }
        int size=len(n);
        Set<Integer> set=new HashSet<>();
        for(String s:digits){
            set.add(Integer.parseInt(s));
        }
        boolean flag=true;

        while(flag && size>0){
            int curr = n / (int) (Math.pow(10, size - 1));
            size--;
            n %= (int) Math.pow(10, size);
            total+=(smaller(curr,digits)*Math.pow(digits.length,size));
            if(size==0 && set.contains(curr)){
                total+=1;
            }
            if(!set.contains(curr))flag=false;
        }
        return total;
    }
    static int smaller(int curr,String digits[]){
        int cnt=0;
        for(String s:digits){
            int val=Integer.parseInt(s);
            if(val<curr)cnt++;
        }
        return cnt;
    }
    static int len(int n){
        int cnt=0;
        while(n>0){
            n/=10;
            cnt++;
        }
        return cnt;
    }
}