class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Character>st1=new Stack<>();
        Stack<Integer>st2=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='('){
                st1.push('(');
                st2.push(0);
            }else{
                st1.pop();
                int total=0;
                while(!st2.isEmpty() && st2.peek()!=0){
                    total+=st2.pop();
                }
                st2.pop();
                if(total==0){
                    st2.push(1);
                }else{
                    st2.push(2*total);
                }
            }
        }
        int total=0;
        while(!st2.isEmpty()){
            total+=st2.pop();
        }
        return total;
    }
}