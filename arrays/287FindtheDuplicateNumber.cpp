class Solution
{
public:
    int findDuplicate(vector<int> &nums)
    {
        vector<bool> seen(nums.size(), false);
        for (int i = 0; i < nums.size(); i++)
        {
            int x = nums[i];
            if (seen[x])
            {
                return x;
            }
            seen[x] = true;
        }
        return -1;
    }
};