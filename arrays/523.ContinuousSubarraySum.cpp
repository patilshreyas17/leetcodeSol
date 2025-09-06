class Solution {
public:
    bool checkSubarraySum(vector<int>& nums, int k) {
        unordered_map<int, int> remainderIndex;
        remainderIndex[0] = -1; // base case
        int prefixSum = 0;
        
        for (int i = 0; i < nums.size(); i++) {
            prefixSum += nums[i];
            
            int remainder = prefixSum % k;
           // if (remainder < 0) remainder += k; // handle negative numbers
            
            if (remainderIndex.find(remainder) != remainderIndex.end()) {
                // check if subarray length >= 2
                if (i - remainderIndex[remainder] > 1) {
                    return true;
                }
            } else {
                // store the first index where this remainder occurs
                remainderIndex[remainder] = i;
            }
        }
        return false;
        
    }
};