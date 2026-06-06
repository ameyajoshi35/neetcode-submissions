class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if(nums.length==1) return List.of(nums[0]);
        int first = 0;
        int second = 0;
        int vote1 = 0;
        int vote2 = 0;

        for(int i=0;i<nums.length;i++) {
          
                
                if(nums[i] == first) {
                    vote1++;
                } else if(nums[i] == second) {
                    vote2++;
                } else if(vote1 ==0){
                    vote1=1;
                    first = nums[i];
                } else if(vote2==0){
                    second = nums[i];
                    vote2 = 1;
                } else {
                    vote1--;
                    vote2--;
                }
            

                
             

        }

        int countFirst = 0;
        int countSecond = 0;

        for(int i=0;i<nums.length;i++) {

            if(nums[i] == first) {
                countFirst++;
            }
            if(nums[i] == second) {
                countSecond++;
            }

        }
        int n = nums.length;
        List<Integer> result = new ArrayList();
        System.out.println(first + "=="+ second);
        if(countFirst > n/3) result.add(first);
        if(countSecond > n/3 && second != first) result.add(second);


        return result;



        
    }
}