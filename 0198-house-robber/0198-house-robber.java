class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];

        dp[0]=nums[0];

        if(nums.length==1){
            return dp[0];

        }else if(nums.length==2){
            dp[1]=Math.max(nums[0],nums[1]);
            return dp[1];

        }else{
            dp[1]=Math.max(nums[0],nums[1]);
            for(int i=2;i<nums.length;i++){  //점화식
                dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
            }
            return dp[nums.length-1];

        }
       
    }
}
/*
고려사항 : 최소 길이 1
dp점화식 만들기 

예외케이스 : 1일때랑 그거보다 클때만 나누기

*/