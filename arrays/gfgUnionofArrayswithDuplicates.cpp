class Solution
{
public:
    vector<int> findUnion(vector<int> &a, vector<int> &b)
    {
        // code here
        std::unordered_set<int> res;
        for (int x : a)
        {
            res.insert(x);
        }
        for (int x : b)
        {
            res.insert(x);
        }
        return vector<int>(res.begin(), res.end());
    }
};