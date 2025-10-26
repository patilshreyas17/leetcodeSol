class Solution
{
public:
    vector<int> maxSumOfThreeSubarrays(const vector<int> &nums, int k)
    {
        const int n = nums.size();
        const int wSize = n - k + 1;
        vector<int> windowSums(wSize);

        // Step 1: sliding window sum
        int sum = 0;
        for (int i = 0; i < k; ++i)
            sum += nums[i];
        windowSums[0] = sum;
        for (int i = k; i < n; ++i)
        {
            sum += nums[i] - nums[i - k];
            windowSums[i - k + 1] = sum;
        }

        // Step 2: precompute max suffix for right subarray
        vector<int> right(wSize);
        int bestRight = wSize - 1;
        for (int i = wSize - 1; i >= 0; --i)
        {
            if (windowSums[i] >= windowSums[bestRight])
                bestRight = i;
            right[i] = bestRight;
        }

        // Step 3: single scan for middle, track best left dynamically
        vector<int> result(3);
        int maxTotal = 0;
        int bestLeft = 0;

        for (int mid = k; mid <= wSize - k - 1; ++mid)
        {
            // Update best left subarray ending before middle
            if (windowSums[mid - k] > windowSums[bestLeft])
                bestLeft = mid - k;

            int l = bestLeft;
            int r = right[mid + k];
            int total = windowSums[l] + windowSums[mid] + windowSums[r];

            if (total > maxTotal)
            {
                maxTotal = total;
                result[0] = l;
                result[1] = mid;
                result[2] = r;
            }
        }

        return result;
    }
};