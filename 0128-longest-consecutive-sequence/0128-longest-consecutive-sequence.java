class Solution {
    public int longestConsecutive(int[] nums) {
        //Set<Integer> s=new TreeSet<>();
        Set<Integer> set=new HashSet<>();
        List<Integer> lst=new ArrayList<>();

        for(int num:nums){
            set.add(num);
        }

        int[] arr=new int[set.size()];
        int i=0;
        for(int x:set){
            arr[i]=x;
            i++;
        }

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
        int v=1;
        for(int j=1;j<arr.length;j++){
            if(arr[j-1]==arr[j]-1) v++;
            else{
                lst.add(v);
                v=1;
            } 
        }
        lst.add(v);

        lst.sort(Collections.reverseOrder());

        if(nums.length==0) return 0;
        else return lst.get(0);
    }
}
/*
TreeSet으로도 가능한지 풀어보기
*/