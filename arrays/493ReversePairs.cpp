
class Solution
{
public:
    int reversePairs(vector<int> &nums)
    {
        return mergeSort(nums, 0, nums.size() - 1);
    }

private:
    int mergeSort(vector<int> &nums, int start, int end)
    {
        if (start >= end)
            return 0; // base case

        int mid = start + (end - start) / 2;
        int count = 0;

        // Count reverse pairs in left and right halves
        count += mergeSort(nums, start, mid);
        count += mergeSort(nums, mid + 1, end);

        // Count cross pairs
        int j = mid + 1;
        for (int i = start; i <= mid; i++)
        {
            while (j <= end && nums[i] > 2LL * nums[j])
                j++;
            count += (j - (mid + 1));
        }

        // Merge the two sorted halves
        vector<int> temp;
        int left = start, right = mid + 1;
        while (left <= mid && right <= end)
        {
            if (nums[left] <= nums[right])
            {
                temp.push_back(nums[left++]);
            }
            else
            {
                temp.push_back(nums[right++]);
            }
        }
        while (left <= mid)
            temp.push_back(nums[left++]);
        while (right <= end)
            temp.push_back(nums[right++]);

        // Copy back to original array
        for (int k = 0; k < temp.size(); k++)
        {
            nums[start + k] = temp[k];
        }

        return count;
    }
};
