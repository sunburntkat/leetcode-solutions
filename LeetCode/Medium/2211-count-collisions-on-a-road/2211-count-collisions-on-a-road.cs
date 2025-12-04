public class Solution {
    public int CountCollisions(string directions) {
        int collisions=0;
        char[] directionsArray=directions.ToCharArray();
        int FirstR=0;
        for(int i=1;i<directions.Length;i++){
            if(directionsArray[i]=='L'){
                if(directionsArray[i-1]=='R')
                {
                    collisions+=i-FirstR+1;
                    directionsArray[i]='S';
                }
                else if(directionsArray[i-1]=='S'){
                    collisions++;
                    directionsArray[i]='S';
                }
            }
            else if(directionsArray[i]=='S'){
                if(directionsArray[i-1]=='R'){
                    collisions+=i-FirstR;
                }
            }
            else{              
                //directions[i]=='R
                if(directionsArray[i-1]!='R'){
                    FirstR=i;
                }
            }
        }
        return collisions;
    }
}