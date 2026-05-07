class Solution {
    static List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result=new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }

    public void backtrack(int[] nums, int start, List<Integer> current){
        result.add(new ArrayList<>(current)); //현재 상태에 결과를 추가

        for(int i=start; i<nums.length;i++){
            current.add(nums[i]); //선택
            backtrack(nums, i+1, current); //다음 원소로
            current.remove(current.size()-1); //선택 취소
        }
    }

    
}

/*
자기자신을 순회하면서 어떻게 되는지 확인하기
있고 없고 전부 다 하네?
일단 돌면서 각 원소가 있고없고를 다 해.
이게 진정한 백트레킹이야
*/