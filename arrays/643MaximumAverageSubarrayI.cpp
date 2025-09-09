class Solution {
public:
    double findMaxAverage(vector<int>& nums, int k) {
        if(nums.empty()) return 0.0;

        int tempS = 0;
        int maxs = INT_MIN;

        for (int i = 0; i < nums.size(); i++) {
            tempS += nums[i];  // add current element

            // Once we've added k elements, start sliding
            if (i >= k - 1) {
                maxs = max(maxs, tempS);
                tempS -= nums[i - k + 1];  // remove element going out of window
            }
        }

        return (double)maxs / k;
    }
};
