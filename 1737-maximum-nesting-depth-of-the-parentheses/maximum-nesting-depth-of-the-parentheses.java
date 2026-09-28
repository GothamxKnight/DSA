class Solution {
    public int maxDepth(String s) {
        int max=0;
        int cnt=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')cnt++;
            if(s.charAt(i)==')')cnt--;
            max=Math.max(cnt,max);
        }
        return max;
    }
}