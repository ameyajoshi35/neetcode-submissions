class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {


        List<List<String>> ans = new ArrayList();
        Map<String,List<String>> map = new HashMap();

        for(String s: strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);

            List<String> ang = map.getOrDefault(sorted, new ArrayList());
            ang.add(s);

            map.put(sorted, ang);

        }


        return new ArrayList(map.values());
        
    }
}
