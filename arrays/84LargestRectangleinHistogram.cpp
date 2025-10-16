class Solution
{
public:
    int largestRectangleArea(vector<int> &heights)
    {
        int n = heights.size();
        vector<int> leftSmaller(n);
        vector<int> rightSmaller(n);
        stack<int> st;

        // Step 1: Compute leftSmaller
        for (int i = 0; i < n; i++)
        {
            while (!st.empty() && heights[st.top()] >= heights[i])
            {
                st.pop();
            }
            leftSmaller[i] = st.empty() ? -1 : st.top();
            st.push(i);
        }
        st = stack<int>();
        // Step 2: Compute rightSmaller
        for (int i = n - 1; i >= 0; i--)
        {
            while (!st.empty() && heights[st.top()] >= heights[i])
            {
                st.pop();
            }
            rightSmaller[i] = st.empty() ? n : st.top();
            st.push(i);
        }

        // Step 3: Compute max area
        int maxArea = 0;
        for (int i = 0; i < n; i++)
        {
            int width = rightSmaller[i] - leftSmaller[i] - 1;
            int area = width * heights[i];
            maxArea = max(maxArea, area);
        }

        return maxArea;
    }
};
