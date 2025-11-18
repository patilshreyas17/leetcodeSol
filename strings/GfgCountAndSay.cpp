class Solution {class Solution {
public:
    string countAndSay(int n) {
        if(n==1) return "1";
        string prev = countAndSay(n-1);
        int count =1;
        string res="";
        for(int i=0;i<prev.length();i++){
            if(i+1 < prev.length()&& prev[i]==prev[i+1]) count++;
            else{
public:
  
  string proc(string &s){
      int count =1;
      char c = s[0];
      
      string res;
      for(int i=1;i<s.length();i++){
          if(c==s[i]) count++;
          else{
              res+=to_string(count)+c;
              c= s[i];
              count =1;
              
          }
        
      }
      res+= to_string(count)+c;
      return res;
  }
    string countAndSay(int n) {
        if(n==1) return "1";
        string res ="1";
        for(int i =1; i<n;i++){
            res = proc(res);
        }
        return res;
        
    }
};

