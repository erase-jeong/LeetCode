class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] answer=new int[2];

        /*
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]+nums[j]==target){
                    answer[0]=i;
                    answer[1]=j;
                }
            }
        }
        */

        /*
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    answer[0]=i;
                    answer[1]=j;
                }
            }
        }
        */
        
        //return answer;


        HashMap<Integer, Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++) map.put(nums[i],i);
   
        for(int i=0;i<nums.length;i++){
            int need=target-nums[i];
            if(map.containsKey(need) && map.get(need)!=i){
                return new int[]{i,map.get(need)};
            }
        }

        return new int[]{0,0};
    }
}

/*
*정렬을 하면 순서가 바뀌므로 정렬을 하면 안됨 => 이분탐색 못씀
*/