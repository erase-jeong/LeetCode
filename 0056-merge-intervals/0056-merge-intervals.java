class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(o1,o2)->{
            if(o1[0]==o2[0]) return o1[1]-o2[1];
            return o1[0]-o2[0];
        });

        int start=intervals[0][0];
        int end=intervals[0][1];

        List<int[]> lst=new ArrayList<>();

        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=end){
                end=Math.max(end,intervals[i][1]);
            }else{
                //구간 추가하기
                lst.add(new int[]{start, end});
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }
        lst.add(new int[]{start,end});

        //리스트 -> 정수배열 변환
        int n=lst.size();
        int[][] answer=new int[n][2];
        for(int i=0;i<n;i++){
            answer[i]=lst.get(i);
        }

        return answer;
        
    }
}

/*
제일 큰 값을 찾는다
거기까지 배열을마=

1~3
현재구간 , 다음구간 겹치는지 비교한다.
겹치면 하나로 합친다.
겹치지 않으면 앞에껄 갱신하고, 그 다음구간으로 지정해서 계산하는 로직
*/