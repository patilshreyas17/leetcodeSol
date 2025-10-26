class Solution
{
public:
    int maxProfit(vector<int> &prices)
    {
        int hold1 = INT_MIN, sold1 = 0;
        int hold2 = INT_MIN, sold2 = 0;
        for (int i : prices)
        {
            hold1 = max(hold1, -i);
            sold1 = max(sold1, hold1 + i);
            hold2 = max(hold2, sold1 - i);
            sold2 = max(sold2, hold2 + i);
        }
        return sold2;
    }
};