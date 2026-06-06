class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        //applepenapple
        //FFFFTFFTFFFFT

        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        Map<String,Integer> map = new HashMap();

        for(String word: wordDict) {
            map.put(word,map.getOrDefault(word,0)+1);
        }

        int start = 0; 
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) { 

               
                if(dp[j] && map.containsKey(s.substring(j,i))) {
                     System.out.println(s.substring(j,i));
                    //System.out.println(i);
                    dp[i] = true;
                    break;
                    
                }
            }
        }


        return dp[s.length()];
        
    }
}
