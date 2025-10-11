class Solution
{
public:
    int findNumbers(vector<int> &nums)
    {
        int count = 0;
        for (int num : nums)
        {
            if (num > 0)
            { // avoid log10(0)
                int digits = (int)log10(num) + 1;
                if (digits % 2 == 0)
                    count++;
            }
        }
        return count;
    }
};