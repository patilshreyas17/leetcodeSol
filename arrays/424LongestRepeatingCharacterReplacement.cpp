class Solution {
public:
    int characterReplacement(string s, int k) {
        vector<int> freq(26, 0); // frequency of characters in window
        int left = 0, maxCount = 0, result = 0;

        for (int right = 0; right < s.size(); right++) {
            // Expand window: include s[right]
            freq[s[right] - 'A']++;
            maxCount = max(maxCount, freq[s[right] - 'A']); // update max char freq in window

            // Check condition: replacements needed = window size - maxCount
            while ((right - left + 1) - maxCount > k) {
                // Shrink from left until condition valid
                freq[s[left] - 'A']--;
                left++;
            }

            // Update result with current valid window length
            result = max(result, right - left + 1);
        }

        return result;
    }
};
