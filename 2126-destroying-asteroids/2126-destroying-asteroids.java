import java.util.*; 

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {

        PriorityQueue<Integer> q=new PriorityQueue<>();
        for(int i=0;i<asteroids.length;i++){
            q.add(asteroids[i]);
        }

        long m=mass; //long으로 변경

        while(!q.isEmpty()){
            if(m>=q.peek()){
                m+=q.poll();
            }
            else{
                return false;
            } 
        }
        return true;       
    }
}