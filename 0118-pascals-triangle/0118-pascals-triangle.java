class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lst=new ArrayList<>();

        for(int i=0;i<numRows;i++){
            List<Integer> row=new ArrayList<>();

            //1.첫번째는 항상 1
            row.add(1);

            //2.중간값 : 윗 행의 두 값의 합
            for(int j=1;j<i;j++){
                int val=lst.get(i-1).get(j-1)+lst.get(i-1).get(j);
                row.add(val);
            }

            //3.마지막도 항상 1(행이 1이상일 때)
            if(i>0) row.add(1);

            lst.add(row);
        }
        return lst;
    }        
}


/*
정수삼각형,DP유형

numsRows만큼 반복하기 <-List의 길이
1.첫번째 인덱스 : 1
2. 마지막 인덱스 : 1 (배열인덱스의 인덱스로 구분)
3. 나머지것들은 dp규칙써서, 점화식써서 해결하기
dp[i]=dp[i-1][]

{[0,0]}
{[1,0],[1,1]}
{[2,0],[2,1],[2,2]}
{[3,0],[3,1],[3,2],[3,3]}

dp[i]=dp[i-1,j-1]+dp[i-1,j];
*/