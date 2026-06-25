class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, List<String>> patterns=new HashMap<>();
        HashMap<String, List<String>> matches=new HashMap<>();
        wordList.add(beginWord);
        for(int i=0;i<wordList.size();i++){
            String word=wordList.get(i);
            char[] wordArray=word.toCharArray();
            patterns.put(word,new ArrayList<>());
            for(int j=0;j<wordArray.length;j++){
                char letter=wordArray[j];
                wordArray[j]='*';
                String pattern=new String(wordArray);
                patterns.get(word).add(pattern);
                if(!matches.containsKey(pattern)){
                    matches.put(pattern, new ArrayList<>());

                }
                matches.get(pattern).add(word);
                wordArray[j]=letter;
            }
        }
        Queue<String> q=new LinkedList<>();
        q.offer(beginWord);
        int dist=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String word=q.poll();
                if(word.equals(endWord)) return dist;
                for(int j=0;j<patterns.get(word).size();j++){
                    String pattern=patterns.get(word).get(j);
                    for(int k=0;k<matches.get(pattern).size();k++){
                        q.offer(matches.get(pattern).get(k));
                    }
                    matches.get(pattern).clear();
                }
            }
            dist++;
        }
        return 0;
    }
}