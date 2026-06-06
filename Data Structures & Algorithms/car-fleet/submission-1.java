class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        Map<Integer,Integer> map = new HashMap();

        for(int j=0;j<position.length;j++) {
            map.put(position[j], speed[j]);
        }
        position = Arrays.stream(position)
                   .boxed()
                   .sorted(Collections.reverseOrder())
                   .mapToInt(Integer::intValue)
                   .toArray();

        Stack<Double> st = new Stack();
        double time = (target - position[0])/(double)map.get(position[0]);
        st.push(time);
        System.out.println(time);
        
        
        for(int i=1;i<position.length;i++) {
            System.out.println(position[i]);
            time = (target - position[i])/(double)map.get(position[i]);
            System.out.println(time);
            if(time > st.peek()) {
                st.push(time);
            }

        }


        return st.size();
        
    }
}
