import java.util.*;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int[] dp = new int[n];
        int[] parent = new int[n];

        Arrays.fill(dp, 1);

        int maxLen = 1;
        int lastIndex = 0;

        for (int i = 0; i < n; i++) {
            parent[i] = i;

            for (int prev = 0; prev < i; prev++) {
                if (nums[i] % nums[prev] == 0 && dp[prev] + 1 > dp[i]) {
                    dp[i] = dp[prev] + 1;
                    parent[i] = prev;
                }
            }

            if (dp[i] > maxLen) {
                maxLen = dp[i];
                lastIndex = i;
            }
        }

        // reconstruct subset
        List<Integer> result = new ArrayList<>();

        while (parent[lastIndex] != lastIndex) {
            result.add(nums[lastIndex]);
            lastIndex = parent[lastIndex];
        }

        result.add(nums[lastIndex]);

        Collections.reverse(result);
        return result;
    }
}