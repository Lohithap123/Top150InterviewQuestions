class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        if len(nums)==0:return []
        nums.append(nums[-1]+1)
        k=[]
        i=0
        while i<len(nums)-1:
            j=i
            rr=[]
            while j<len(nums)-1:
                if nums[j]+1 in nums:
                    rr.append(nums[j])
                    j+=1
                else:
                    rr.append(nums[j])
                    j+=1
                    break
            if len(rr)!=1:
                k.append(str(rr[0])+"->"+str(rr[-1]))
            else:
                k.append(str(rr[0]))
            i=j
        return k
