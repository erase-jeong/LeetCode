import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen=new HashSet<>();
        for(int n : nums){
            if(!seen.add(n)) return true; //add가 false면 이미 있던 값 = 중복
        }
        return false;
    }
}

