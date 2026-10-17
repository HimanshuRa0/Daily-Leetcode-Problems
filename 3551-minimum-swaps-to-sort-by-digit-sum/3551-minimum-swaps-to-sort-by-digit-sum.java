class Solution {
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = getDigitSum(nums[i]);
            arr[i][1] = nums[i];
            arr[i][2] = i;
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
        int swapCount = 0;
        for (int i = 0; i < n; i++) {
            while (arr[i][2] != i) {
                int targetIdx = arr[i][2];
                int[] temp = arr[i];
                arr[i] = arr[targetIdx];
                arr[targetIdx] = temp;
                swapCount++;
            }
        }
        return swapCount;
    }
}