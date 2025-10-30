public class Solution {
    public int MinNumberOperations(int[] target) {
        var stack=new Stack<int>();
        stack.Push(0);
        int peak=target[0];
        int result=0;
        bool isPeak=true;
        for(int i=1;i<target.Length;i++){
            if(target[i]>target[i-1]){
                peak=target[i];
                isPeak=true;
            }
            else{
                if(isPeak){
                    result+=peak-stack.Peek();
                    isPeak=false;
                }
                while(stack.Count>0 && target[i]<stack.Peek()){
                    stack.Pop();
                }
                stack.Push(target[i]);
            }
        }
        if(isPeak){
            result+=peak-stack.Peek();
        }
        return result;
    }
}