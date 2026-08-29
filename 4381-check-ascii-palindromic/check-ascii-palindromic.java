class Solution {
    public boolean isPalindromic(String s) {

        StringBuilder str=new StringBuilder();
        for(char ch:s.toCharArray()){

            int digit=(int)(ch);

            String temp=Integer.toBinaryString(digit);
            int k=8-temp.length();
            while(k-->0){
                str.append('0');
            }
            str.append(temp);
        }
        return ispalin(str.toString());
    }
    static boolean ispalin(String s){

        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
}