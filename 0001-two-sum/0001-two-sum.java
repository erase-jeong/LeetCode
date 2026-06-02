class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        while(left<right){ //등호유무는 어떻게 하지? //같은거 중복해서 안쓴다고함. 그러므로, left랑 right가 같은 경우는 절대 정답이 될 수 없음
            if(nums[left]+nums[right]==target){
                return new int[]{left, right};
            }else if(nums[left]+nums[right]>target){
                right--;
            }else if(nums[left]+nums[right]<target){
                left++;
            }
        }

        return new int[]{0};
    }
}
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