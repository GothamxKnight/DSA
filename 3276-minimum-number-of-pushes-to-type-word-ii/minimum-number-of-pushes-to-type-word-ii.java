class Solution {
    public int minimumPushes(String word) {
        TreeMap<Character,Integer> map=new TreeMap<>();
        int n=word.length();
        for(int i=0;i<n;i++){
            char ch=word.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int i=0;
        int res=0;
        List<Integer> list=new ArrayList<>(map.values());
        Collections.sort(list,Collections.reverseOrder());
        for(int a:list){
            if(i<8){
                res+=a;
            }else if(i<16){
                res+=(a*2);
            }else if(i<24){
                res+=(a*3);
            }else{
                res+=(a*4);
            }
            i++;
        }
        return res;
    }
}