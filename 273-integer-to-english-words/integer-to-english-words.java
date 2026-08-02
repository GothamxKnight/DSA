class Solution {
    public String numberToWords(int num) {
        if(num==0)return "Zero";
        int []chunks=new int[4];
        chunkgenerator(chunks,num);
        StringBuilder res=new StringBuilder();
        for(int i=0;i<4;i++){
            if(chunks[i]!=0){
                String n=Convertor(chunks[i],i);
                res.append(n);
            }
        }
        String ans[]=res.toString().split("\\s+");
        res=new StringBuilder();
        for(String s:ans){
            res.append(s.trim()).append(" ");
        }
        return res.toString().trim();
    }
    static void chunkgenerator(int []chunks,int num){
        int i=3;
        while(num>0){
            int n=num%1000;
            num/=1000;
            chunks[i--]=n;
        }
    }
    static String Convertor(int n,int j){
        StringBuilder res=new StringBuilder();
        String[] words = {"zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        HashMap<Integer,String> map=new HashMap<>();
        for(int i=1;i<=19;i++){
            map.put(i,words[i]);
        }
        String words2[]={"none","none","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        HashMap<Integer,String> map2=new HashMap<>();
        for(int i=2;i<=9;i++){
            map2.put(i,words2[i]);
        }
        if(n/100!=0){
            res.append(map.get(n/100)).append(" ").append("Hundred").append(" ");
        }
        n%=100;
        if(n/10!=0){
            if(n/10==1){
                res.append(map.get(n));
                if(j==0)res.append(" ").append("Billion").append(" ");
                if(j==1)res.append(" ").append("Million").append(" ");
                if(j==2)res.append(" ").append("Thousand").append(" ");
                return res.toString();
            }else{
                res.append(map2.get(n/10));
            }
        }
        n%=10;
        if(n!=0){
            res.append(" ").append(map.get(n));
        }
        if(j==0)res.append(" ").append("Billion").append(" ");
        if(j==1)res.append(" ").append("Million").append(" ");
        if(j==2)res.append(" ").append("Thousand").append(" ");
        return res.toString();
    }
}