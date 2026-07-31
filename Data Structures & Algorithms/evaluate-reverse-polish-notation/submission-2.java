class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> s = new Stack<>();
        for (int i=0; i<tokens.length; i++) {
            if ("+-*/".contains(tokens[i]) && !s.isEmpty()) {
                int a=Integer.parseInt(s.pop());
                int b=Integer.parseInt(s.pop());
                int result=0;
                    if (tokens[i].equals("+")) {
                        result = a + b;
                    } else if (tokens[i].equals("-")) {
                        result = b - a;
                    } else if (tokens[i].equals("*")) {
                        result = a * b;
                    } else if (tokens[i].equals("/")) {
                        result = b / a;
                    }
                s.push(String.valueOf(result));                
            } else{
                s.push(tokens[i]);
            }
        }
        return Integer.parseInt(s.peek());
    }
}
