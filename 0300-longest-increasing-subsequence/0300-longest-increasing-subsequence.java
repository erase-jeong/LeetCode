class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];

        //디폴트로 1로 선언
        for(int i=0;i<n;i++){
            dp[i]=1;
        }

        System.out.println(Arrays.toString(dp));

        for(int i=1;i<n;i++){
            int value=nums[i];
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }

        Arrays.sort(dp);

        return dp[n-1];
    }
}

