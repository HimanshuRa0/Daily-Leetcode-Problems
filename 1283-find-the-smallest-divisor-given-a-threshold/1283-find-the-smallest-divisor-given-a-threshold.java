class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = 0;
        for (int num : nums) {
            if (num > right) {
                right = num;
            }
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            long currentSum = 0;
            for (int num : nums) {
                currentSum += (num + mid - 1) / mid; 
            }          
            if (currentSum <= threshold) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}