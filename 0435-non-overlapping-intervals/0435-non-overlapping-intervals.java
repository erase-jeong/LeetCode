import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        //정렬하기 -> 끝나는거 기준으로
        Arrays.sort(intervals,(a,b)->{
            if(a[1]==b[1]) return b[0]-a[0];
            return a[1]-b[1];
        });
        
        int answer=0;
        int lastStart=-50001;
        int lastEnd=-500001;

        for(int[] interval : intervals){
            int start=interval[0];
            int end=interval[1];

            if(lastEnd>start){
                answer++;
            }else{
                lastStart=start;
                lastEnd=end;
            }
        }
        return answer;
    }
}