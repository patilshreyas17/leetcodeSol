class Solution {
public:
    int compress(vector<char>& chars) {
        int n = chars.size();
        int w =0;
        for(int i = 0; i<n;i++){
            char curr = chars[i];
            int count =0;
            while(i<n && curr == chars[i]){
                count++;
                i++;
            }
            i--;

            chars[w]= curr;
            w++;
            if(count>1){
                string str = to_string(count);
                for(char c: str){
                    chars[w++]=c;
                    
                }
            }
        }
        return w;
    }
};
