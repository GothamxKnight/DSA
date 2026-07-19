class Solution {
    public String smallestSubsequence(String s) {
        HashMap<Character,Integer> shal=new HashMap<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            shal.put(s.charAt(i),shal.getOrDefault(s.charAt(i),0)+1);
        } 
        boolean []visited=new boolean[26];
        Arrays.fill(visited,false);
        Stack<Character> st=new Stack<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            while(!st.isEmpty() && st.peek()-'a'>=ch-'a' && shal.get(st.peek())>0 && !visited[ch-'a']){
                visited[st.pop()-'a']=false;
            }
            if(!visited[ch-'a']){
                st.push(ch);
                visited[ch-'a']=true;
            }
            shal.put(ch,shal.get(ch)-1);
        }
        StringBuilder str=new StringBuilder();
        Stack<Character> stk=new Stack<>();
        while(!st.isEmpty()){
            stk.push(st.pop());
        }
        while(!stk.isEmpty()){
            str.append(stk.pop());
        }
        return str.toString();
    }
}