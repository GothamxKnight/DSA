class Solution {
    public int countBinarySubstrings(String s) {
        List<Integer> list=new ArrayList<>();
        int i=0,n=s.length();
        while(i<n){
            char ch=s.charAt(i);
            i++;
            int cnt=1;
            while(i<n && ch==s.charAt(i)){
                i++;
                cnt++;
            }
            list.add(cnt);
        }
        i=1;
        int total=0;
        for(;i<list.size();i++){
            total+=Math.min(list.get(i),list.get(i-1));
        }
        return total;

    }
}