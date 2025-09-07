class NumArray {
private:
    vector<int> prefix; // prefix[i] = sum of nums[0...i-1]
    
public:
    NumArray(vector<int>& nums) {
        int n = nums.size();
        prefix.resize(n + 1, 0);
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
    }
    
    int sumRange(int left, int right) {
        return prefix[right + 1] - prefix[left];
    }
};

//325
// class Solution {
// public:
//     int maxSubArrayLen(vector<int>& nums, int k) {
//         unordered_map<int, int> mp; // prefixSum -> earliest index
//         int sum = 0, maxLen = 0;
        
//         for (int i = 0; i < nums.size(); i++) {
//             sum += nums[i];
            
//             if (sum == k) {
//                 maxLen = max(maxLen, i + 1);
//             }
            
//             if (mp.find(sum - k) != mp.end()) {
//                 maxLen = max(maxLen, i - mp[sum - k]);
//             }
            
//             // store only first occurrence
//             if (mp.find(sum) == mp.end()) {
//                 mp[sum] = i;
//             }
//         }
//         return maxLen;
//     }
// };
