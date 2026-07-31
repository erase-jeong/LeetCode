class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //각 값을 정렬하기
        String[] sorted=new String[strs.length];
        
        for(int i=0;i<strs.length;i++){
            String s=strs[i];
            char[] chars = s.toCharArray();
            Arrays.sort(chars);              // 오름차순 정렬
            String result = new String(chars);   // "abcd"
            sorted[i]=result;
        }

        Set<String> set=new HashSet<>();
        for(int i=0;i<sorted.length;i++){
            set.add(sorted[i]);
        }
        //System.out.println("str : "+Arrays.toString(strs));
        //System.out.println("sorted : "+Arrays.toString(sorted));
        //System.out.println("set : "+set);


        List<List<String>> answer=new ArrayList<>();


        for(String s : set){
            List<String> lst=new ArrayList<>();

            //System.out.println("s : "+s);
            for(int i=0;i<sorted.length;i++){
                if(s.equals(sorted[i])) lst.add(strs[i]);
            }
            //System.out.println("lst : "+lst);
            answer.add(lst);
            //System.out.println("answer : "+answer);
        }

        return answer;
    }
}
/**
구성요소 파악하기
hashmap이용하기
아니다. 각각 정렬해서 정렬한 값도 가지고 있기
착은거
정렬한것도 가지고있기
정렬한 걸 이용해서 비교하기
그리고 set해서 모든 종류를 없애기

=> 어떻게 
*/

/*
O(N^2)으로 순회하기


*/