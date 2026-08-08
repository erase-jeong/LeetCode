import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //배열 돌면서 hashMap에 값 넣어주기
        //key값 돌면서 value가 k보다 크거나 같으면 => 리스트에 넣어두기
        //리스트를 배열로 변환

        Map<Integer, Integer> map=new HashMap<>();
        for(int num : nums){
            //map.put(num, map.getOrDefault(num,num+1));
            if(!map.containsKey(num)){ //map에 값이 없으면 새로 넣기
                map.put(num,1);
            }
            else{  //map에 값이 있으면 value 꺼내와서 1 더하기
                map.put(num,map.get(num)+1);
            }
        }

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(b[1],a[1]));

        for(int key : map.keySet()){
            pq.add(new int[]{key, map.get(key)});
        }

        /*
        System.out.println("pq : "+pq);
        for(int[] arr : pq){
            System.out.println(Arrays.toString(arr));
        }
        */

        List<Integer> lst=new ArrayList<>();
        for(int i=0;i<k;i++){
            int[] p=pq.poll();
            lst.add(p[0]);
        }

        //System.out.println("lst : "+pq);

        int[] answer=new int[lst.size()];
        for(int i=0;i<answer.length;i++){
            answer[i]=lst.get(i);
        }
        
        return answer;
    }
}
