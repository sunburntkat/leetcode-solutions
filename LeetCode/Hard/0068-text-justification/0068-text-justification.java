class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int l = 0;
        int lineSize = words[0].length();
        int wordsSize = lineSize;
        StringBuilder sb = new StringBuilder();
        for (int r = 1; r < words.length; r++) {
            if (lineSize + words[r].length() + 1 > maxWidth) {
                result.add(centerJustify(l, r,maxWidth, wordsSize,words));
                l = r;
                wordsSize = words[r].length();
                lineSize = wordsSize;
            } else {
                lineSize += words[r].length() + 1;
                wordsSize += words[r].length();
            }

        }
        result.add(leftJustify(l, maxWidth,wordsSize,words));
        return result;

    }

    public String centerJustify(int l, int r,int maxWidth, int wordsSize,String[] words) {
        int wordCount = r - l;
        int spaceCount = maxWidth - wordsSize;
        StringBuilder sb = new StringBuilder();
        sb.append(words[l]);
        if (wordCount > 1) {
            int extraSpaceCount = spaceCount % (wordCount - 1);
            int normalSpaceCount = spaceCount - extraSpaceCount;
            int spaceLength = (spaceCount / (wordCount - 1));
            for (int i = l + 1; i < l + 1 + extraSpaceCount; i++) {
                sb.append(" ".repeat(spaceLength + 1));
                sb.append(words[i]);
            }
            for (int i = l + 1 + extraSpaceCount; i < r; i++) {
                sb.append(" ".repeat(spaceLength));
                sb.append(words[i]);
            }
        }
        else{
            sb.append(" ".repeat(spaceCount));
        }
        
        return sb.toString();
    }
    public String leftJustify(int l,int maxWidth, int wordsSize, String[] words){
        int wordCount =words.length - l;
        int spaceCount = maxWidth - wordsSize;
        StringBuilder sb=new StringBuilder();
        sb.append(words[l]);
        for(int i=l+1;i<words.length;i++){
            sb.append(" ");
            sb.append(words[i]);
        }
        if(spaceCount>=wordCount){
            sb.append(" ".repeat(spaceCount-wordCount+1));
        }
        return sb.toString();
    }
}