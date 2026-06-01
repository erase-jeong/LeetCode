class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer=new ArrayList<>();

        //각 strs를 알파벳별로 정렬한다.
        String[] sorted=new String[strs.length];
        System.out.println("sorted : "+sorted);
        System.out.println("sorted : "+Arrays.toString(sorted));

        //char[] arr=s.toCharArray();

        //set을 만든다
        Set<String> set=new HashSet<>();

        for(int i=0;i<strs.length;i++){
            String s=strs[i];
            char[] arr=s.toCharArray();
            Arrays.sort(arr);
            s=new String(arr);
            sorted[i]=s;
            set.add(s);
        }
        System.out.println("strs : "+Arrays.toString(strs));
        System.out.println("sorted3 : "+Arrays.toString(sorted));
        System.out.println("set : "+set);
        

        //정답크기
        //int ans_size=set.size();
        System.out.println("set출력");
        for(String x: set){
            System.out.println(x);
            List<String> tmp=new ArrayList<>();
            for(int i=0;i<strs.length;i++){
                if(x.equals(sorted[i])){
                    tmp.add(strs[i]);
                }
            }
            System.out.println("x : "+x+", tmp : "+tmp);

            answer.add(tmp);

        }

        return answer;
        
    }
}
/*
각 단어별로 HashMap으로 분류를 한다.
같은 애들끼리 equals로 비교해서 한다. 그게 아니면 안되는거다. 그래서 이렇게 비교하는 로직으로 한다.

10^8 개의 hashMap을 만든다.
10^8개를 비교한다? 이게 가능한가??? 
정렬을 해야한다. 그럼 정렬을 어떻게 할 것인가? 정렬을 how? 의 문제


1. 모든 String을 알파벳순으로 정렬한다.
2. 그러면 같은게 보인다.? -> set으로 넣어서?? -> 근데 지금 이게 원본꺼니깐, 결국 
원래꺼, 바뀐거 이렇게 hashmap으로 넣어야 할듯
key는 원래꺼로. value는 정렬한걸로
그러면 정렬한걸 기준으로 하기
1st.hashMap을 이용해서 정렬한 걸 value에 넣기
(eat,aet), 
(tea,aet),
(tan,ant),
(ate,aet),
(nat,ant),
(bat,abt)

2nd. 키를 순회하면서? 넣기??

(aet,eat)
)
*/