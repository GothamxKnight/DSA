class Solution {
    public int maximumWidth(int[] planks) {
        HashMap<Integer,Integer> freq=new HashMap<>();
        HashMap<Integer,Integer> target=new HashMap<>();
        for(int a:planks){
            freq.put(a,freq.getOrDefault(a,0)+1);
            target.put(a,target.getOrDefault(a,0)+1);
        }
        for(int a:freq.keySet()){
            for(int b:freq.keySet()){
                if(a<b){
                    target.put(a+b,target.getOrDefault(a+b,0)+Math.min(freq.get(a),freq.get(b)));
                }
                if(a==b){
                    target.put(a+b,target.getOrDefault(a+b,0)+freq.get(a)/2);
                }
            }
        }
        int max=0;
        for(int a:target.values()){
            max=Math.max(max,a);
        }
        return max;
    }
}