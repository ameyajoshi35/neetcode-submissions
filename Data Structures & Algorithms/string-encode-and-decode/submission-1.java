class Solution {

    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder("");
        for(String s: strs) {
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }
        String s1 = sb.toString();

        return s1;

    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int slash = str.indexOf("#", i);
            int size = Integer.valueOf(str.substring(i, slash));
            res.add(str.substring(slash + 1, slash + 1 + size));
            i = slash + 1 + size;
        }
        return res;

    }
}

