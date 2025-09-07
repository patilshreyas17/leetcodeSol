class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int n = nums.size();
        int left = 0, sum = 0;
        int ans = INT_MAX;

        for (int right = 0; right < n; right++) {
            sum += nums[right];   // expand window

            while (sum >= target) {   // valid window
                ans = min(ans, right - left + 1);
                sum -= nums[left];    // shrink from left
                left++;
            }
        }

        return (ans == INT_MAX ? 0 : ans);
    }
};
