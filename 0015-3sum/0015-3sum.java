class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            //중복 건너뛰기
            if(i>0 && nums[i]==nums[i-1]) continue;

            int l=i+1;
            int r=nums.length-1;

            while(l<r){
                int threeSum=nums[i]+nums[l]+nums[r];

                if(threeSum>0){
                    r--;
                }else if(threeSum<0){
                    l++;
                }else{
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;
                    while(nums[l]==nums[l-1]&& l<r) l++;
                }
            }
        }
        return res;

    }
}
/*

*/