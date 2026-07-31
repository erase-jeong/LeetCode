class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] answer=new int[n];

        //1단계 : 왼쪽 누적곱(i왼쪽 원소들의 곱)
        answer[0]=1;
        for(int i=1;i<n;i++){
            answer[i]=answer[i-1]*nums[i-1];
        }

        //2단계 : 오른쪽 누적곱을 변수 하나로 흘려보내며 곱하기
        int right=1;
        for(int i=n-1;i>=0;i--){
            answer[i]*=right; //왼쪽 곱 * 오른쪽 곱
            right*=nums[i];
        }
        return answer;
    }
}