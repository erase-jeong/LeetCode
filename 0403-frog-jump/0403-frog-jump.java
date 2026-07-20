class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer,Set<Integer>> map=new HashMap<>();
        for(int stone:stones){
            map.put(stone,new HashSet<>());
        }
        map.get(0).add(0);
        
        for(int stone : stones){
            for(int k:map.get(stone)){
                for(int step=k-1;step<=k+1;step++){
                    if(step<=0) continue;
                    int next=stone+step;
                    if(map.containsKey(next)){
                        map.get(next).add(step);
                    }
                }
            }
        }

        int last=stones[stones.length-1];
        return !map.get(last).isEmpty();
    }
}

/*
상태의 변화
어떻게 개구리의 상태가 변하는가
단순히 증가한다고 증가하는 
*/