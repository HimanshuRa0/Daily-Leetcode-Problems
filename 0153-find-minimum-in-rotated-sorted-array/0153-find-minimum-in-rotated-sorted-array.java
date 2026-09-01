class Solution {
    public int findMin(int[] nums) {
        int ans=Integer.MAX_VALUE;
        int low = 0, high = nums.length - 1;
        while(low<=high){
        int mid=(low+high)/2;
        if(nums[low]<=nums[high])
        {
            ans=Math.min(ans,nums[low]);
            break;
        }
        if(nums[low]<=nums[mid])
        {
            ans=Math.min(ans,nums[low]);
            low=mid+1;
        }
        else{
            high=mid-1;
            ans=Math.min(ans,nums[mid]);
        }
    }
    return ans;
    }
}
