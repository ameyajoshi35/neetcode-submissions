class Solution {
    public boolean isValid(String s) {

        if(s.length()%2 == 1) return false;
        int oCount =0; int cCount = 0;

        Stack<Character> st1 = new Stack();

        for(int i=0;i<s.length();i++) {
            
            if(s.charAt(i)=='[' || s.charAt(i)=='(' || s.charAt(i)=='{') {
               st1.push(s.charAt(i));
               oCount++;
            } else {
               cCount++;
               
               if(!st1.isEmpty()) {
                char c1 = st1.pop();
                if(c1 == '(' && s.charAt(i) == ')') {
                    oCount--;
                    cCount--;
                }
                if(c1 == '{' && s.charAt(i) == '}') {
                     oCount--;
                     cCount--;
                }
                if(c1 == '[' && s.charAt(i) == ']') {
                     oCount--;
                     cCount--;
                }
                
              }
             
              
              


            }
        }
        
        return oCount == 0 && cCount == oCount;
        
    }
}
