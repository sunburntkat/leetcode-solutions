public class Solution {
    public int LadderLength(string beginWord, string endWord, IList<string> wordList) {
        Dictionary<string,List<string>> patterns=new();
        Dictionary<string,List<string>> matches=new();
        for(int i=0;i<wordList.Count;i++){
            char[] word=wordList[i].ToCharArray();
            patterns[wordList[i]]=new List<string>();
            for(int j=0;j<word.Length;j++){
                char temp=word[j];
                word[j]='*';
                string pattern=new string(word);
                patterns[wordList[i]].Add(pattern);
                if(matches.ContainsKey(pattern)){
                    matches[pattern].Add(wordList[i]);
                }
                else{
                    matches[pattern]=new List<string>(){wordList[i]};
                }
                word[j]=temp;

                
            }
            
        }
        patterns[beginWord]=new List<string>();
        for(int i=0;i<beginWord.Length;i++){
            char[] firstWord=beginWord.ToCharArray();
            char t=firstWord[i];
            firstWord[i]='*';
            string pattern=new string(firstWord);
            patterns[beginWord].Add(pattern);
            firstWord[i]=t;
        }
        Queue<string> queue=new();

        queue.Enqueue(beginWord);
        int iter=1;
        while(queue.Count>0){
            int n=queue.Count;
            for(int i=0;i<n;i++){
                var word=queue.Dequeue();
                if(word==endWord) return iter;
                for(int j=0;j<patterns[word].Count;j++){
                    var pattern=patterns[word][j];
                    if(!matches.ContainsKey(pattern)) continue;
                    for(int k=0;k<matches[pattern].Count;k++){
                        if(matches[pattern][k]==word) continue;
                        queue.Enqueue(matches[pattern][k]);
                    }
                    matches[pattern].Clear();
                }    
                
            }
            iter++;
        }
        return 0;
    }
}