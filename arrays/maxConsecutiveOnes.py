class Solution(object):
    def findMaxConsecutiveOnes(self, nums):
        m = 0
        c = 0
        for i in nums:
            if i == 1:
                c += 1
            else:
                m = max(m, c)
                c = 0
        return max(c, m)
        