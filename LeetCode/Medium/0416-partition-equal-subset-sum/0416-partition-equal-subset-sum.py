class Solution(object):
    def canPartition(self, nums):
        total=sum(nums)
        if (total%2!=0):
            return False
        half=total//2
        dp=[False for i in range(half+1)]
        dp[0]=True
        for num in nums:
            for j in range(len(dp)-1,num-1,-1):
                if(dp[j-num]):
                    dp[j]=True

        return dp[-1]
        

        