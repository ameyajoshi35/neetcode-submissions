class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {


        TreeMap<Integer,Integer> map = new TreeMap();
        Arrays.sort(hand);

        for(int num: hand) {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        int i = hand[0];
        int cnt = 0;
        List<Integer> l = new ArrayList();
        while(map.size()!=0) {
            if(map.get(i)!=null && map.get(i) > 0) {
                map.put(i, map.get(i)-1);
                if(map.get(i) == 0) {
                    map.remove(i);
                }
                l.add(i);
                cnt++;
            } else {
                return false;
            }
            
            i++;
            if(cnt == groupSize && map.size() > 0) {
                cnt=0;
                i = map.firstKey();
                l = new ArrayList();
            }
        }

        return l.size() == groupSize;


        
    }
}
