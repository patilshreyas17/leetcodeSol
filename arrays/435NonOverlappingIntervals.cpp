class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        if (intervals.empty()) return 0;

        // Sort intervals by their end time
        sort(intervals.begin(), intervals.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[1] < b[1];
        });

        int end = INT_MIN; // End of last added interval
        int removeCount = 0;

        for (auto &interval : intervals) {
            if (interval[0] >= end) {
                // No overlap, keep this interval
                end = interval[1];
            } else {
                // Overlap, must remove one
                removeCount++;
            }
        }

        return removeCount;
    }
    
};