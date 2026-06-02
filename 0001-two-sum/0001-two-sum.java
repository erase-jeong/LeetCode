class Solution {
    public int[] twoSum(int[] nums, int target) {
        //해쉬 방법
        HashMap<Integer,Integer> map=new HashMap<>();
        //key : 숫자값, value : 인덱스
        for(int i=0;i<nums.length;i++){
            //현재 숫자(nums[i])와 짝이 되어야 할 수 계산
            int need=target-nums[i]; 
            
            if(map.containsKey(need)){
                return new int[]{map.get(need),i};
            }
            map.put(nums[i],i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
/*
"지금 내가 필요한 값이 이전에 지나온 숫자 중에 있는가?"
를 매 스탭마다 O(1)로 확인하기 => 전체 시간복잡도 : O(n)
*/



/*
nums를 정렬한다.
투포인터로 접근한다.
2+15
if(nums[left]+nums[right]==target){
    return new int[]{left,right};
}else if(nums[left]+nums[right]>target){
    right--;
}else if(nums[left]+nums[right]<target){
    left++;
}
*/