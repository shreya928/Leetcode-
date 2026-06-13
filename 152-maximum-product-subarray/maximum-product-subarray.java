class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int maxProd = nums[0];
        int minProd = nums[0];

        // Traverse from second element
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            // Swap if current is negative
            if (curr < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            // Update max and min product
            maxProd = Math.max(curr, maxProd * curr);
            minProd = Math.min(curr, minProd * curr);

            // Update result
            res = Math.max(res, maxProd);
        }

        return res;
    }
}
