class Solution {
    public int maxProfit(int[] prices) {
        int minPrice=prices[0];  //지금까지 본 가격 중 최솟값
        int maxProfit=Integer.MIN_VALUE; //지금까지 구한 이윤 중 최댓값

        for(int i=0;i<prices.length;i++){
            int curPrice=prices[i]; //현재 가격
            if(curPrice<minPrice){
                minPrice=prices[i];
            }
            if(curPrice-minPrice>maxProfit) maxProfit=curPrice-minPrice;
        }

        System.out.println(maxProfit);
        return maxProfit;
        
    }
}

/*
언제 사서 언제 파는게 제일 좋을까?
그리디. 
오늘샀을 때, 내일 파는거 다음에 파는 
*/
