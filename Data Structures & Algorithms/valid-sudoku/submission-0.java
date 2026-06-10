class Solution {
    public boolean isValidSudoku(char[][] board) {

        int[][] range = new int[][]{{0,0,2,2},{0,3,2,5},{0,6,2,8},
        {3,0,5,2},{3,3,5,5},{3,6,5,8},
        {6,0,8,2},{6,3,8,5},{6,6,8,8}};

        Map<Integer, Set<Character>> rowM = new HashMap();
        Map<Integer, Set<Character>> colM = new HashMap();

        for(int i=0;i<=9;i++) rowM.put(i,new HashSet());
        for(int i=0;i<=9;i++) colM.put(i,new HashSet());

        for(int[] sub: range) {
            int r1 = sub[0];
            int c1 = sub[1];
            int r2 = sub[2];
            int c2 = sub[3];

            Set<Character> subBox = new HashSet();
            for(int i=r1;i<=r2;i++) {
                for(int j=c1;j<=c2;j++) {
                    System.out.println(i+"********--"+rowM.get(i).size());
                    if(board[i][j] == '.') {
                        
                        //System.out.println(i+"--"+j);
                        continue;
                    }
                    
                    if(!rowM.get(i).add(board[i][j])){
                        
                        
                        System.out.println(i+"********--"+rowM.get(i).size());
                        return false;

                    } 
                    if(!colM.get(j).add(board[i][j])) return false;

                    if(!subBox.add(board[i][j])) {
                        System.out.println("hmm");
                    
                        return false;
                    }
                }
                
            }
        }

        return true;
        
    }
}
