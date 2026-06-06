
class Pair{

    int city;
    int price;

    public Pair(int c, int p) {
        this.city = c;
        this.price = p;
    }
}

class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

         List<List<Pair>> graph = new ArrayList();

         for(int i=0;i<n;i++) {
            graph.add(new ArrayList());
         }

         for(int[] edge : flights) {

            graph.get(edge[0]).add(new Pair(edge[1],edge[2]));

         }
         
        
        Queue<int[]> q = new PriorityQueue<>((a,b)-> a[0]-b[0]);

        q.add(new int[]{0,src,0});

        int[][] priceStop = new int[n][k+2];
        for(int[] pst: priceStop) {
            Arrays.fill(pst, Integer.MAX_VALUE);
        }
        priceStop[src][0] = 0;

        while(!q.isEmpty()) {



            int[] node = q.poll();

            int price = node[0];
            int nod = node[1];
            int stop = node[2];

            for(Pair adjNode: graph.get(nod)) {

                if(stop<k+1 && price + adjNode.price < priceStop[adjNode.city][stop+1]) {
                    priceStop[adjNode.city][stop+1] = price + adjNode.price;
                    q.add(new int[]{price + adjNode.price, adjNode.city,stop+1});
                }
                    

                
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= k + 1; i++)
            ans = Math.min(ans, priceStop[dst][i]);
        return ans == Integer.MAX_VALUE ? -1 : ans;
        

    }
}
