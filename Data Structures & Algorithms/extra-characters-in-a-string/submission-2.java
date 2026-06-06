class Solution {
    public int minExtraChar(String s, String[] dictionary) {

        Set<String> set = new HashSet(Arrays.asList(dictionary));


        int[] dp = new int[s.length()+1];

        dp[0] = 0; // not needed

        for(int i=1;i<=s.length();i++) {

            dp[i] = dp[i-1]+1; // setting default as extra character
            //Now check if substring is found at char ending at i.

            for(int j=0;j<i;j++) {
                if(set.contains(s.substring(j,i))) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }

        return dp[s.length()];
        
    }
     
    public int findWordEndingAt(String s, int index, Set<String> set) {
        int max = 0;
        for(int i=0;i<=index;i++) {
            String substr =  s.substring(i,index);
            if(set.contains(substr)) {
                max = Math.max(max,substr.length());
            }
        }

        return max;
    }

}