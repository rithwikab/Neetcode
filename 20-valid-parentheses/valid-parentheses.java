class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> m = new HashMap<>();
        m.put(']','[');
        m.put('}','{');
        m.put(')','(') ;
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(m.containsValue(c)){
                stack.push(c);
            }
            else{
                if(stack.isEmpty())return false;
                if(stack.peek() != m.get(c))return false;
                stack.pop();
                
            }
        } 
        if(stack.isEmpty())return true;
        return false;
    }
}