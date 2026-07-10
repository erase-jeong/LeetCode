class Solution {
    public long maxStrength(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        boolean flag=false;

        //원소가 1개뿐인 특수 케이스
        if(n==1) return nums[0];

        long answer=1;
        List<Integer> ans=new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int idx=n-1;
        while(idx>=0){
            if(nums[idx]>0) {answer*=nums[idx]; flag=true;}
            else if(nums[idx]<0) pq.add(Math.abs(nums[idx]));
            idx--;
        }
        
        int qSize=pq.size(); 
        int num=qSize;
        if(qSize%2==1) num=qSize-1;
        
        while(num>0){
            answer*=pq.poll();
            num--;
            flag=true;
        }

        if(!flag){
            //0이 있으면 0이 답
            for(int num2:nums){
                if(num2==0){
                    return 0L;
                }
            }
            //0없으면 음수중에 절댓값 제일 큰거
            return pq.poll();
        }

        return answer;

    }
}
//0이면 제외

/*
3 * (-5) * 2 * 5 * (-9) = 1350
음수는 할꺼면 짝수개가 있어야 한다.
=>짝수개.

어떻게 고를까?
3, -1 -5 22 5 9
어차피 순서는 중요하지 않으므로 정렬하기
  -9, -5, -1, 2, 3, 9(6개)
 => 양수는 무조건 넣기, 음수는 최대 짝수개를 넣기 (절댓값 큰걸로, 음수는 절댓값 큰게 작은값)

 -5, -4, -4
 => 음수니깐 절댓값 큰거 2개 곱하기

 3개  


 1. 일단 정렬한다.
 2. 0을 기준으로 음수애들이랑 양수애들을 나눈다
 3. 양수는 무조건 곱하고 음수는 짝수개만
*/