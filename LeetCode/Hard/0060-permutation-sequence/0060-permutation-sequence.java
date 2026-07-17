class Solution {
    List<Integer> nums=new ArrayList<>();
    StringBuilder sb=new StringBuilder();

    public String getPermutation(int n, int k) {
        for(int i=1;i<=n;i++) nums.add(i);
        int total=fact(n);
        recGetPermutation(n,k,total/n);
        return sb.toString();
    }

    public void recGetPermutation(int n, int k,int groupSize ){
        int groupNo=(int)Math.ceil((float)k/groupSize)-1;  //0 indexed
        sb.append(nums.get(groupNo));
        nums.remove(groupNo);
        if(n==1) return;
        recGetPermutation(n-1,k-groupNo*groupSize,groupSize/(n-1));
    }
    public int fact(int x){
        if(x<=1) return 1;
        return x*fact(x-1);
    }
}