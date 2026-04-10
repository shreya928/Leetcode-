
class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int i = 0, maxFreq = 0, maxLen = 0;

        for (int j = 0; j < s.length(); j++) {
            int idx = s.charAt(j) - 'A';
            freq[idx]++;

            maxFreq = Math.max(maxFreq, freq[idx]);

            // shrink window if invalid
            if ((j - i + 1) - maxFreq > k) {
                freq[s.charAt(i) - 'A']--;
                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
        }

        return maxLen;
    }
}