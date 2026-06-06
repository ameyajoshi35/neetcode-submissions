class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> st = new Stack();
        int maxArea = 0;

        for(int i=0;i<heights.length;i++) {

            while(!st.isEmpty() && heights[i] < heights[st.peek()]) {
                int index = st.pop();
                int nse = i;
                int pse = st.isEmpty()? -1 : st.peek();

                int area = heights[index] * (nse - pse -1);
                maxArea = Math.max(maxArea, area);

            }
            st.push(i);
        }

        while(!st.isEmpty()) {
            int top = st.pop();
            int width = st.isEmpty() ? heights.length : heights.length - st.peek() - 1;
            int area = heights[top] * width;
            maxArea = Math.max(maxArea, area);

        }

        return maxArea;
        
    }
}
