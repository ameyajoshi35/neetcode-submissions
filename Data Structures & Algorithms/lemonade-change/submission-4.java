class Solution {
    public boolean lemonadeChange(int[] bills) {

        int count5 = 0;
        int count10 = 0;
        int count20 = 0;
        int ret = 0;

        for(int bill: bills) {
            if(bill == 5) count5++;
            if(bill == 10) {
                count5--; count10++;
            }
            if(bill == 20) {
                
                if(count10 <=0 ||count5>3){
                    count5 = count5-3;
                } else {
                    count10--;
                    count5--;
                }              
            }
            if(count5 < 0) return false;
            
        }

        //if(balance == 0) return false;

        return true;
        
    }
}