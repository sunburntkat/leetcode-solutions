public class Solution {
    public int[] MaxSlidingWindow(int[] nums, int k) {
        if(k==1) return nums;
        MonotonicQueue monotonicQueue=new MonotonicQueue(nums);
        monotonicQueue.Enqueue(0);
        int[] result=new int[nums.Length-k+1];
        for(int r=1;r<k-1;r++){
            monotonicQueue.Enqueue(r);
        }
        for(int r=k-1;r<nums.Length;r++){
            monotonicQueue.Enqueue(r);
            result[r-k+1]=nums[monotonicQueue.getMax()];
            if(monotonicQueue.getMax()<=r-k+1){
                monotonicQueue.Dequeue();
            }
        }
        return result;
    }
}
class MonotonicQueue{
    private LinkedList<int> _list=new();
    private int[] _nums;
    public MonotonicQueue(int[] nums){
        _nums=nums;
    }
    public void Enqueue(int x){
        while(_list.Count>0 && _nums[_list.Last.Value]<_nums[x]){
            _list.RemoveLast();
        }
        _list.AddLast(x);
    }
    public void Dequeue(){
        if(_list.Count>0){
            _list.RemoveFirst();
        }
    }
    public int getMax(){
        if(_list.Count>0){
            return _list.First.Value;
        }
        return -1;
    }

}