class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int k = 1; k * k <= n; k++) {
            if (n % k == 0) {
                if (isSortable(nums, n, k)) {
                    sum += k;
                }
                int pairedDivisor = n / k;
                if (pairedDivisor != k && isSortable(nums, n, pairedDivisor)) {
                    sum += pairedDivisor;
                }
            }
        }
        return sum;
    }
    private boolean isSortable(int[] nums, int n, int k) {
        int prevMax = -1;
        for (int start = 0; start < n; start += k) {
            int end = start + k - 1;
            int drops = 0;
            int dropIdx = -1;
            for (int i = start; i < end; i++) {
                if (nums[i] > nums[i + 1]) {
                    drops++;
                    dropIdx = i;
                    if (drops > 1) {
                        return false;
                    }
                }
            }
            int currMin;
            int currMax;
            if (drops == 0) {
                currMin = nums[start];
                currMax = nums[end];
            } else {
                if (nums[end] > nums[start]) {
                    return false;
                }
                currMin = nums[dropIdx + 1];
                currMax = nums[dropIdx];
            }
            if (prevMax > currMin) {
                return false;
            }
            prevMax = currMax;
        }
        return true;
    }
}