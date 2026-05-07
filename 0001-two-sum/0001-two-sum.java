class Solution {
    public int[] twoSum(int[] nums, int target) {
        //해쉬 방법
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++) map.put(nums[i],i);

        for(int i=0;i<nums.length;i++){

            int need=target-nums[i];
            if(map.containsKey(need) && map.get(need)!=i){
                return new int[]{i,map.get(need)};
            }
        }
        return new int[]{0,0};
        //throw new IllegalArgumentException("No two sum solution");

        
    }
}


        //브루투포스트
        /*
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i!=j && nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
        */

