import java.util.*;

class Solution {
    public List<String> braceExpansionII(String expression) {
        Stack<Set<String>> valst = new Stack<>();
        Stack<String> opst = new Stack<>();
        List<String> s = helper(expression);
        int n = s.size();
        
        for (int i = 0; i < n; i++) {
            String str = s.get(i);

            if (str.equals("+") || str.equals("*") || str.equals("{")) {
                opst.push(str);
            } else if (str.equals("}")) {
                // Evaluate all '+' operations inside this brace level
                while (!opst.isEmpty() && !opst.peek().equals("{")) {
                    if (opst.pop().equals("+")) {
                        Set<String> right = valst.pop();
                        Set<String> left = valst.pop();
                        left.addAll(right);
                        valst.push(left);
                    }
                }
                opst.pop(); // Pop '{'
                
                // Chain any pending multiplications after brace resolution
                while (!opst.isEmpty() && opst.peek().equals("*")) {
                    opst.pop();
                    Set<String> right = valst.pop();
                    Set<String> left = valst.pop();
                    valst.push(multiply(left, right));
                }
            } else {
                Set<String> temp = new HashSet<>();
                temp.add(str);
                valst.add(temp);

                // Chain any pending multiplications immediately after a word
                while (!opst.isEmpty() && opst.peek().equals("*")) {
                    opst.pop();
                    Set<String> right = valst.pop();
                    Set<String> left = valst.pop();
                    valst.push(multiply(left, right));
                }
            }
        }

        // Final cleanup of remaining operators at root level
        while (!opst.isEmpty()) {
            if (opst.pop().equals("+")) {
                Set<String> right = valst.pop();
                Set<String> left = valst.pop();
                left.addAll(right);
                valst.push(left);
            }
        }

        List<String> res = new ArrayList<>(valst.pop());
        Collections.sort(res);
        return res;
    }

    private static Set<String> multiply(Set<String> s1, Set<String> s2) {
        Set<String> result = new HashSet<>();
        for (String str1 : s1) {
            for (String str2 : s2) {
                result.add(str1 + str2);
            }
        }
        return result;
    }

    static List<String> helper(String s) {
        int n = s.length();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == ',') {
                list.add("+");
                continue;
            } else if (!Character.isLetter(ch)) {
                list.add(String.valueOf(ch));
            } else if (Character.isLetter(ch)) {
                StringBuilder temp = new StringBuilder();
                while (i < n && Character.isLetter(s.charAt(i))) {
                    temp.append(s.charAt(i));
                    i++;
                }
                list.add(temp.toString());
                i--;
            }
            if (i + 1 < n) {
                char next = s.charAt(i + 1);
                String currentToken = list.get(list.size() - 1);

                boolean currIsChunk = !currentToken.equals("+") && !currentToken.equals("{");
                boolean nextIsChunk = Character.isLetter(next) || next == '{';

                if (currIsChunk && nextIsChunk) {
                    list.add("*");
                }
            }
        }
        return list;
    }
}
