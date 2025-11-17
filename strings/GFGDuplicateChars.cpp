// C++ Code to print duplicate characters 
// and their counts using Hashing
#include <bits/stdc++.h>
using namespace std;

// Function to print duplicate characters with their count
void printDuplicates(string s) {
unordered_map<char, int>freq;
for(char c : s){
    freq[c]++;
}
for(auto it: freq){
    if(it.second>1){
        cout<<it.first;
    }
}
}

int main() {

    string s = "geeksforgeeks";

    printDuplicates(s);

    return 0;
}
