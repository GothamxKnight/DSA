class Solution {
    public String reverseWords(String s) {
        String arr[]=s.split(" ");
        StringBuilder res=new StringBuilder();
        for(String str:arr){
            res.append(reverse(str));
            res.append(" ");
        }
        return res.toString().trim();
    }
    static String reverse(String s){
        StringBuilder res=new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            res.append(s.charAt(i));
        }
        return res.toString();
    }
}