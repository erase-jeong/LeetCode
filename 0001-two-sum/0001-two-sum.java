class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] answer=new int[2];

        /*
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]+nums[j]==target){
                    answer[0]=i;
                    answer[1]=j;
                }
            }
        }
        */

        
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    answer[0]=i;
                    answer[1]=j;
                }
            }
        }
        

        return answer;
    }
}

/*
*정렬을 하면 순서가 바뀌므로 정렬을 하면 안됨 => 이분탐색 못씀
*/