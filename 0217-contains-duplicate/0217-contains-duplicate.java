import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        System.out.println(map);

        boolean answer=false;

        for(int key : map.keySet()){
            System.out.println(key+" : "+map.get(key));
            if(map.get(key)>1) return true;
        }

        return false;
    }
}

/*
set을 이용해서 현재 몇개의 원소들이 있는지 파악하기
여기에 맞게 

아니다. hashmap을 만들어서 key-value 만들기
그 다음에 어떻게든 하기


*/
