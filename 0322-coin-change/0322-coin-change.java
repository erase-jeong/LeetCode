class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        //dp[i]=Math.min(dp[i-1]+1, dp[i-5]+1, dp[i-10]+1);

        for(int i=1;i<=amount;i++){
            int min=Integer.MAX_VALUE;
            for(int coin:coins){
                if(i-coin>=0 && dp[i-coin]!=Integer.MAX_VALUE){ //음수 방지
                    min=Math.min(min,dp[i-coin]+1);
                }
            }
            dp[i]=min;
        }

        //return dp[amount];
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
}