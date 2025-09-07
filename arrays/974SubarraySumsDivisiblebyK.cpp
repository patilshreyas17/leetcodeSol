class Solution {
public:
    int subarraysDivByK(vector<int>& nums, int k) {
        unordered_map<int,int> remainderCount;
        remainderCount[0] = 1; // similar to 560: handles subarrays starting at index 0
        
        int prefixSum = 0;
        int result = 0;
        
        for (int i = 0; i < nums.size(); i++) {
            prefixSum += nums[i];
            
            // compute remainder, normalize negative numbers
            int rem = ((prefixSum % k) + k) % k;
            
            // ✅ This is very similar to 560: check if we have seen this remainder before
            if (remainderCount.count(rem)) {
                // instead of returning true in 560, we add the count of previous occurrences
                result += remainderCount[rem];
            }
            
            // store/update remainder count
            remainderCount[rem]++;
        }
        
        return result;
    }
};
