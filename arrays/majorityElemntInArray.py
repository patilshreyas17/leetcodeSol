class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        candidate = None
        count = 0
        for x in nums:
            if count == 0:
                candidate = x
            count += (1 if x == candidate else -1)
        return candidate
