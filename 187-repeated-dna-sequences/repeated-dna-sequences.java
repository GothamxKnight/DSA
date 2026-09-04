class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String,Integer> map=new HashMap<>();
        int n=s.length();
        for(int i=0;i<n-9;i++){
            String dna=s.substring(i,i+10);
            map.put(dna,map.getOrDefault(dna,0)+1);
        }
        List<String> res=new ArrayList<>();
        for(Map.Entry<String,Integer> temp:map.entrySet()){
            if(temp.getValue()>1){
                res.add(temp.getKey());
            }
        }
        return res;
    }
}