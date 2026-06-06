class Solution {
    public int[] plusOne(int[] digits) {
        
        Stack<Integer> ans = new Stack();
        int carry = 1;
        int num = 0;
        for(int i=digits.length-1;i>=0;i--) {
            
         

            num = digits[i]+carry;
            carry = num/10;
            num = num>9? num%10: num;
            System.out.println(digits[i]+"-"+carry+"-"+"hmm="+num);            
            ans.push(num);

        }
        if(carry == 1) ans.push(1);
        
        int[] answer = new int[ans.size()];
        int i = 0;
        while(!ans.isEmpty()){
            answer[i++] = ans.pop();
        }


        return answer;
        
    }
}
