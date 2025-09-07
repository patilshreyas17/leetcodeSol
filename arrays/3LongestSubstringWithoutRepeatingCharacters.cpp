class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> lastSeen;  // stores last index of each char
        int left = 0, ans = 0;

        for (int right = 0; right < s.size(); right++) {
            char c = s[right];

            // If character seen before, move left pointer
            if (lastSeen.count(c) && lastSeen[c] >= left) {
                left = lastSeen[c] + 1;  // jump left just past the duplicate
            }

            lastSeen[c] = right;  // update last seen index
            ans = max(ans, right - left + 1);
        }

        return ans;
    }
};
