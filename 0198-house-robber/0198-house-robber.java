import java.util.*; 

class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0], nums[1]);
        
        int[] dp=new int[nums.length];
        //Arrays.fill(nums,1);

        //System.out.println(Arrays.toString(nums));
        dp[0]=nums[0];
        dp[1]=nums[1];
        //dp[2]=nums[2]+Math.max(dp[0],dp[1]);
        dp[2]=nums[2]+dp[0];

        for(int i=3;i<nums.length;i++){
            //System.out.println("");
            dp[i]=nums[i]+Math.max(dp[i-2],dp[i-3]);
        }
        //System.out.println(Arrays.toString(dp));
        Arrays.sort(dp);

        return dp[nums.length-1];
    }
}


/*
[1, 2, 3, 1]
[1, 2, 4, 3]
dp[0]=nums[0];
dp[1]=nums[1];

dp[2]=nums[2]+dp[0];

*/