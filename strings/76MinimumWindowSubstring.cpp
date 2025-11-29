class Solution {
public:
    string minWindow(string s, string t) {
     unordered_map<char,int>tmap;
     for(char c : t) tmap[c]++;

     int left =0;
     int start = 0;
     int len=INT_MAX;
     int have =0, need = tmap.size();
     unordered_map<char,int>cmap;
     for(int right =0;right<s.size(); right++){
        char c = s[right];
        cmap[c]++;
        if(tmap.count(c) && cmap[c]==tmap[c]) have++;

        while(have==need){
            if(right-left+1<len){
                len = right-left+1;
                start = left;
            }
            cmap[s[left]]--;
            if(tmap.count(s[left])&& cmap[s[left]]<tmap[s[left]]) have--;
            left++;
        }
     }
    return (len==INT_MAX)? "":s.substr(start,len);
    }
};
