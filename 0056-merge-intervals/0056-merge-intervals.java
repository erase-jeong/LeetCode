import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        //배열 정렬
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);

        List<int[]> lst=new ArrayList<>();
        lst.add(intervals[0]); //첫 블록 놓기
        //System.out.println("lst : "+lst);
        //System.out.println("lst : " + Arrays.deepToString(lst.toArray()));
        //System.out.println();

        for(int i=1;i<intervals.length;i++){
            ///System.out.println(Arrays.toString(intervals[i]));
            int[] last=lst.get(lst.size()-1); //맨 마지막에 놓은 블록
            if(intervals[i][0]<=last[1]){
                last[1]=Math.max(last[1],intervals[i][1]);
            }else{
                lst.add(intervals[i]);
            }
        }

        int n=lst.size();
        int[][] answer=new int[n][2];
        for(int i=0;i<n;i++){
            answer[i]=lst.get(i);
        }

        return answer;
    }
}

/*
주어진 구간 배열에서 겹치는 구간들을 모두 병합하고, 입력 구간의 모든 구간을 포함하는 겹치지 않는 구간들의 배열을 반환한다.

그러면 이걸 어떻게 할 것인가?
전체 부분을 쭉 해서 할껀데....
1, 2, 3, 4, 5, 6ㅣ, 

제일 작은 값이랑 제일 큰 값을 뽑기
그 다음에 배열로 만들어서 하지말고, 최솟값이랑 최댓값을 갱신하면서 하기

최소, 최대, 최소, 최대값만 기억하고 있다가 갱ㅇ신는 로직

4 -- 7
시작하는건 이전 끝값이랑 비교한다.

1. 첫번째 배열의 값 기준으로 정렬한다
2. 리스트에 추가
배열 순회 (N번)
    -> 뒤에 시작값을 앞에 끝값들이랑 비교 => 합칠 수 있는지 확인하기 (N번)
=>O(N^2)
3. 리스트를 배열로 변환

*/