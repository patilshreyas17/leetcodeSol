class Solution
{
public:
    double mincostToHireWorkers(vector<int> &quality, vector<int> &wage, int k)
    {

        vector<pair<double, int>> workers(quality.size());
        for (int i = 0; i < quality.size(); i++)
        {
            workers[i] = {(double)wage[i] / quality[i], quality[i]};
        }
        sort(workers.begin(), workers.end());

        double minC = numeric_limits<double>::max();
        priority_queue<int> mh;
        int total = 0;
        for (const auto &[x, q] : workers)
        {

            mh.push(q);
            total += q;

            if (mh.size() == k)
            {
                minC = min(x * total, minC);
                total -= mh.top();
                mh.pop();
            }
        }
        return minC;
    }
};