class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] p = new int[nums.length];
        int[] s = new int[nums.length];
        p[0] = nums[0];
        s[nums.length-1] = nums[nums.length-1];

        for(int i=1;i<nums.length;i++) {
            p[i] = p[i-1]*nums[i];
            s[nums.length-1-i] = s[nums.length - i] * nums[nums.length-1-i];

        }

        Arrays.stream(p).forEach(System.out::print);
        System.out.println();
        Arrays.stream(s).forEach(System.out::print);

        int[] ans = new int[nums.length];

        for(int j=0;j<nums.length;j++) {

           if(j==0) {
            ans[j] = s[j+1];
            continue;
           }
           if(j==nums.length-1){
             ans[j] = p[nums.length-2];
             continue;
           }

           ans[j] = p[j-1]* s[j+1];
        }

        return ans;
        
    }
}  
