class Solution:
    def canJump(self, nums: List[int]) -> bool:
        last_position = 0
        for i in range(len(nums)):
            if i > last_position:
                return False
            last_position = max(last_position, i + nums[i])
            if last_position >= len(nums) - 1:
                return True
        return last_position >= len(nums) - 1
