class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        def climb(n, dp=None):
            if dp is None:
                dp = {}

            if n == 1:
                return 1
            if n == 2:
                return 2
            if n in dp:
                return dp[n]
            else:
                dp[n] = climb(n-1, dp) + climb(n-2, dp)

            return dp[n]

        return climb(n)
            
            