class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize!=0) return false;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<hand.length;i++){
            pq.add(hand[i]);
        }
        Queue<Integer> q=new LinkedList<>();
        while(!pq.isEmpty()){
            int i=0;
            int num=pq.peek()-1;
            while(!pq.isEmpty() && i<groupSize){
                int next=pq.poll();
                if(next>num+1){
                    return false;
                }
                if(next==num){
                    q.offer(next);
                }
                else{
                    num=next;
                    i++;
                }
            }
            if(!q.isEmpty() && pq.isEmpty()) return false;
            while(!q.isEmpty()){
                pq.add(q.poll());
            }
        }
        return true;
    }
}