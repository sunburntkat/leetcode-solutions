class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] list=new StringBuilder[numRows];
        for(int i=0;i<numRows;i++){
            list[i]=new StringBuilder();
        }
        int i=0;
        while(i<s.length()){
            for(int row=0;i<s.length() && row<numRows;row++){
                list[row].append(s.charAt(i));
                i++;
            }
            for(int row=numRows-2;i<s.length() && row>0;row--){
                list[row].append(s.charAt(i));
                i++;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int j=0;j<numRows;j++){
            sb.append(list[j].toString());
        }
        return sb.toString();
    }
}