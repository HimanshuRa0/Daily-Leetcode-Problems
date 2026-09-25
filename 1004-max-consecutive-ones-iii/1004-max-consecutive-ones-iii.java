class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxlength=0, left=0 ,right=0, zeros=0;
        while(right<nums.length)
        {
            if(nums[right]==0) zeros++;
            if(zeros>k)
            {
                if(nums[left]==0) zeros--;
                left++;
            }
            maxlength=Math.max(maxlength,right-left+1);
            right++;
        }
        return maxlength;
    }
}