class Solution {
    public String countAndSay(int n) {
        String s="1";
        for(int i=0;i<n-1;i++){
            System.out.println(i);
            StringBuilder sb=new StringBuilder();
            char number=s.charAt(0);
            int count=1;
            for(int j=1;j<s.length();j++){
                if(s.charAt(j)==number){
                    count++;
                }
                else{
                    sb.append(count);
                    sb.append(number);
                    count=1;
                    number=s.charAt(j);
                }
            }
            sb.append(count);
            sb.append(number);
            s=sb.toString();
        }
    return s;
    }
}