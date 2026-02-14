// class Solution {
//     public int characterReplacement(String s, int k) {
//         HashMap<Character,Integer> hm = new HashMap<>();
//         int i=0;
//         int maxFreq = 0;
//         int max = 0;
//         for(int j=0; j<s.length(); j++){
//             char ch = s.charAt(j);
//             hm.put(ch,hm.getOrDefault(ch,0)+1);
//             maxFreq = Math.max(maxFreq, hm.get(ch));
//             if(maxFreq+k < j-i+1){
//                 hm.put(s.charAt(i),hm.get(s.charAt(i))-1);
//                 i++;
//             }
//             max = Math.max(max,j-i+1);
//         }return max;
//     }
// }
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
