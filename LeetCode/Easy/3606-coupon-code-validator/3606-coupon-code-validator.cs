public class Solution {
    public IList<string> ValidateCoupons(string[] code, string[] businessLine, bool[] isActive) {
        Dictionary<string,List<string>> dict=new();

        string[] businessLineCategories=new string[]{"electronics", "grocery", "pharmacy", "restaurant"};
        for(int i=0;i<businessLineCategories.Length;i++){
            dict[businessLineCategories[i]]=new List<string>();
        }
        for(int i=0;i<code.Length;i++){
            if(isAlphaNumeric(code[i]) && dict.ContainsKey(businessLine[i]) && isActive[i]){
                dict[businessLine[i]].Add(code[i]);
            }
        }
        List<string> result=new();
        for(int i=0;i<businessLineCategories.Length;i++){
            dict[businessLineCategories[i]].Sort((a,b)=>b.CompareTo(a));
            result.AddRange(dict[businessLineCategories[i]]);
        }
        return result;
        

        bool isAlphaNumeric(string s){
            if(s.Length==0){
                return false;
            }
            for(int i=0;i<s.Length;i++){
                if(! (s[i]>='a' && s[i]<='z' ||
                    s[i]>='A' && s[i]<='Z' ||
                    s[i]>='0' && s[i]<='9' ||
                    s[i]=='_'))
                {
                    return false;
                }
            }
            return true;
        }
    }
}