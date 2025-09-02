#include <vector>
using namespace std;

class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int candidate = 0;
        int count = 0;
        for (int currnum : nums) {
            if (count == 0) candidate = currnum;
            count += (currnum == candidate) ? 1 : -1;
        }
        return candidate;
    }
};
