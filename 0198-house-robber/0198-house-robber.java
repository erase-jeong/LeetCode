import java.util.*;

class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        System.out.println(Arrays.toString(dp));
        dp[0]=nums[0];
        if(n>1) dp[1]=Math.max(nums[0],nums[1]);

        if(n>2){
            for(int i=2;i<n;i++){
                dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
            }
        }

        return dp[n-1];
    }
}
/*
집+그 다음 집
인접한 두 집을 털지는 못한다.
=>현재집+2개앞에집 vs 바로 앞에집 => 둘 중에 max를 뽑아내기
를 하는 것이 정답이다. 

어떻게 할 것인가?

일단 DP를 만드록 어떻게 만들것인가?
1,2, 3,1 
=> 1,2,3,1
일단 하나씩 뽀개면서 하는게 좋을꺼같다. 
*/