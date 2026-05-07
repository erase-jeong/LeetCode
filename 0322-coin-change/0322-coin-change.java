class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0; //어차피 디폴트

        for(int coin : coins){
            for(int cur=coin;cur<=amount;cur++){
                if(dp[cur-coin]!=Integer.MAX_VALUE){
                    dp[cur]=Math.min(dp[cur],dp[cur-coin]+1);
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
}