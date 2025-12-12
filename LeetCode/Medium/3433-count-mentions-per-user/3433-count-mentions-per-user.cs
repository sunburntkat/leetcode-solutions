public class Solution {
    public int[] CountMentions(int numberOfUsers, IList<IList<string>> events) {
        int[] status=new int[numberOfUsers];
        int[] mentions=new int[numberOfUsers];
        Array.Fill(status,-60);
        var eventsList = events
                .Select(e => e.ToList())
                .ToList();
        eventsList.Sort((a,b)=>{
            int cmp=(Convert.ToInt32(a[1])).CompareTo(Convert.ToInt32(b[1]));
            if(cmp==0){
                return b[0].CompareTo(a[0]);  //"OFFLINE">"MESSAGE", we swapped the parameters around (b.compareTo(a))
            }
            return cmp;
        });

        int lastModifiedTime=0;
        for(int i=0;i<eventsList.Count;i++){
            var curEvent=eventsList[i];
            if(curEvent[0]=="OFFLINE"){
                int currentTime=Convert.ToInt32(curEvent[1]);
                status[Convert.ToInt32(curEvent[2])]=currentTime;
            }
            else{
                if(curEvent[2]=="ALL"){
                    for(int j=0;j<mentions.Length;j++){
                        mentions[j]++;
                    }
                }
                else if(curEvent[2]=="HERE"){
                    int currentTime=Convert.ToInt32(curEvent[1]);
                    for(int j=0;j<status.Length;j++){
                        int id=Convert.ToInt32(j);
                        if(currentTime-status[id]>=60){
                            mentions[id]++;
                        }
                    }
                }
                else{
                    var ids=curEvent[2].Split(' ');
                    for(int j=0;j<ids.Length;j++){
                        int id=Convert.ToInt32((ids[j].Substring(2,ids[j].Length-2)));
                        mentions[id]++;
                    }
                }
            }
        }
        return mentions;
    }
}