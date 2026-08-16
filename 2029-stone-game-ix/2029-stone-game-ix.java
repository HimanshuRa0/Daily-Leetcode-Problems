class Solution {
public boolean stoneGameIX(int[] stones){
int[] cnt = new int[3];
// Step 1: Count remainders
for (int x : stones) {
cnt[x % 3]++;
}
int a = cnt[1]; // remainder 1
int b = cnt[2]; // remainder 2
int c = cnt[0]; // remainder 0

// Step 2: Check number of remainder-0 stones
if (c % 2 == 0) {
return a > 0 && b > 0;
}
// Odd number of remainder-0 stones
return Math.abs(a - b) > 2;
}
}