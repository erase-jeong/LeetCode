class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];

        int prev2=nums[0];
        int prev1=Math.max(nums[0],nums[1]);

        for(int i=2;i<n;i++){
            int curr=Math.max(prev1, prev2+nums[i]);
            prev2=prev1;
            prev1=curr;
        }

        return prev1;
    }
}
/*
고려사항 : 최소 길이 1
dp점화식 만들기 

예외케이스 : 1일때랑 그거보다 클때만 나누기

*/