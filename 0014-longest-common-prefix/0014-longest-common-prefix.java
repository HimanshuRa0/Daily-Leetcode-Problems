class Solution {
    public String longestCommonPrefix(String[] strs) {

        String criteriaStr = strs[0];
        String longestCommonPrefix = strs[0];

        for (int i = 1; i < strs.length; i++) {

            while (!strs[i].startsWith(criteriaStr)) {
                criteriaStr = criteriaStr.substring(0, criteriaStr.length() - 1);
            }
            longestCommonPrefix = criteriaStr;
        }

        return longestCommonPrefix;
    }
}