class Solution {
    public int[] productExceptSelf(int[] nums) {
        int mul=1;
        for(int num : nums){
            mul*=num;
        }

        int[] answer=new int[nums.length];
        List<Integer> lst=new ArrayList<>();

        for(int i=0;i<answer.length;i++){
            if(nums[i]==0){
                //answer[i]=mul;
                //answer[i]=mul
                //예외적으로 따로 처리를 해야한다. 어떻게?
                //인덱스만 따로 모아두고, 나중에 예외처리를 진행한다.
                int mul2=1;
                for(int j=0;j<answer.length;j++){
                    if(j==i) continue;
                    else mul2*=nums[j];
                }
                System.out.println("i : "+i);
                System.out.println(mul2);
                answer[i]=mul2;
                //lst.add(i);

            }else{
                answer[i]=mul/nums[i];
            }

        }
        return answer;
    }
}


/*
전체 파악
자신 제외하고 곱하기
전체곱을 미리 구해두고, 자기자신으로 나누기
그럼for() 2번
*/