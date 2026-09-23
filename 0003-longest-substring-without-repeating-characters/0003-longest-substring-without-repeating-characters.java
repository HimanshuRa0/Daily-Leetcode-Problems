class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> lastSeen = new HashMap<>();
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (lastSeen.containsKey(ch) && lastSeen.get(ch) >= left) {
                left = lastSeen.get(ch) + 1;
            }
            lastSeen.put(ch, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}