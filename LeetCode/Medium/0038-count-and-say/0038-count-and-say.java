class Solution {
    public String countAndSay(int n) {
        String s="1";
        for(int i=0;i<n-1;i++){
            StringBuilder sb=new StringBuilder();
            char[] charArray=s.toCharArray();
            char number=charArray[0];
            int count=1;
            for(int j=1;j<charArray.length;j++){
                if(charArray[j]==number){
                    count++;
                }
                else{
                    sb.append(count);
                    sb.append(number);
                    count=1;
                    number=charArray[j];
                }
            }
            sb.append(count);
            sb.append(number);
            s=sb.toString();
        }
    return s;
    }
}