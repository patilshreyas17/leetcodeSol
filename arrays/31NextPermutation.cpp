class Solution
{
public:
    void nextPermutation(vector<int> &nums)
    {
        int n = nums.size();
        if (n <= 1)
            return;

        // 1) find pivot i: first index from right where nums[i] < nums[i+1]
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1])
            --i;

        // 2) if pivot found, find rightmost j > i with nums[j] > nums[i] and swap
        if (i >= 0)
        {
            int j = n - 1;
            while (nums[j] <= nums[i])
                --j;
            swap(nums[i], nums[j]);
        }

        // 3) reverse the suffix starting at i+1
        reverse(nums.begin() + i + 1, nums.end());
    }
};