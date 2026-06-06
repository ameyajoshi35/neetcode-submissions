class Solution {

    int cnt = 0;
    public List<List<String>> solveNQueens(int n) {

        

        List<List<String>> ans = new ArrayList();
        if(n==1) {
            ans.add(List.of("Q"));
            return ans;
        }
        

        char[][] arr = new char[n][n];
        for(int i=0;i<arr.length;i++){
                    
            for(int j=0;j<arr.length;j++) {
                arr[i][j] = '.';
            }
        }

    

        solve(arr,0,0,ans);
        

        return ans;
        
    }

    public void solve(char [][] arr, int row, int col,List<List<String>> ans) {
        
        if(row == arr.length) {
            // calculate ans
            System.out.println("Hmmm"+ row+"=="+col);
            List<String> l = new ArrayList();
            //if(cnt >= arr.length) {
                for(int i=0;i<arr.length;i++){
                    
                    StringBuilder sb = new StringBuilder();
                    for(int j=0;j<arr.length;j++) {
                        System.out.print(arr[i][j]+" ");
                        sb.append(arr[i][j]);
                    }
                    l.add(sb.toString());

                    
                    System.out.println();
                }
                ans.add(l);
            //}
            return;
        }

        for(int i=0;i<arr.length;i++){
            if(isValid(arr, row,i)){
            
                    arr[row][i] = 'Q';
                    solve(arr, row+1, 0, ans);
                    arr[row][i] = '.';
 

            }
        }
        

        

        //System.out.println("Hmmm"+ row+"=="+col);

        
        


    }

    public boolean isValid(char[][] arr, int row, int col) {

        // if(row>=arr.length || col >= arr.length) return false;

          for(int i=0;i<arr.length;i++) {
               if(arr[row][i]=='Q'){
                  System.out.println("FoundQ"+ row+"=="+i);
                  return false;
               }
          }

          for(int i=0;i<arr.length;i++) {
               if(arr[i][col]=='Q')
                  return false;
          }

          int r = row-1, c = col-1;
          while(r>=0 && c>=0) {
              if(arr[r][c]=='Q')
                 return false;
              r--;
              c--;
          }
          r = row+1; c = col+1;
          while(r<arr.length && c<arr.length) {
              
              if(arr[r][c]=='Q')
                 return false;
              r++;
              c++;
          }

          r = row-1; c = col+1;
          while(r>=0 && r<arr.length && c<arr.length) {
              if(arr[r][c]=='Q')
                 return false;
              r--;
              c++;
          }

          r = row+1; c = col-1;
          while(r>=0 && r<arr.length && c>=0) {
              if(arr[r][c]=='Q')
                 return false;
              r++;
              c--;
          }

          return true;
    }

    // public void markDots(char[][] arr, int row, int col) {
          
    //       for(int i=0;i<arr[0].length;i++) {
    //            if(arr[row][i]=='\u0000')
    //               arr[row][i] = '.';
    //       }

    //       for(int i=0;i<arr.length;i++) {
    //            if(arr[i][col]=='\u0000')
    //               arr[i][col] = '.';
    //       }

    //       int r = row-1, c = col-1;
    //       while(r>=0 && c>=0) {
    //           if(arr[r][c]=='\u0000')
    //              arr[r][c] = '.';
    //           r--;
    //           c--;
    //       }
    //       r = row+1; c = col+1;
    //       while(r<arr.length && c<arr.length) {
              
    //           if(arr[r][c]=='\u0000')
    //              arr[r][c] = '.';
    //           r++;
    //           c++;
    //       }

    // }
}
