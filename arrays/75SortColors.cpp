class Solution
{
public:
    int maxSubarraySumCircular(vector<int> &nums)
    {
        int cMax = nums[0], cMin = nums[0];
        int gMax = nums[0], gMin = nums[0];
        int total = nums[0];

        for (int i = 1; i < nums.size(); i++)
        {
            int n = nums[i];

            cMax = max(cMax + n, n);
            gMax = max(gMax, cMax);

            cMin = min(cMin + n, n);
            gMin = min(gMin, cMin);

            total += n;
        }

        return (gMax < 0) ? gMax : max(total - gMin, gMax);
    }
};
