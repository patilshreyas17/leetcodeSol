class Solution
{
public:
    int maxChunksToSorted(vector<int> &arr)
    {
        stack<int> s;
        for (int n : arr)
        {
            if (s.empty() || n >= s.top())
            {
                s.push(n);
            }
            else
            {
                int mx = s.top();
                s.pop();
                while (!s.empty() && n < s.top())
                {
                    s.pop();
                }
                s.push(mx);
            }
        }
        return s.size();
    }
};