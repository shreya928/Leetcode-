class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int totPoints = 0;
        for(int i=0; i<n; i++){
            totPoints += cardPoints[i];
        }
        if(k==n)return totPoints;
        int currSum = 0;
        for(int i=0; i<n-k; i++){
            currSum += cardPoints[i];
        }
        int minSum = currSum;
        for(int i=n-k; i<n; i++){
            currSum += cardPoints[i] - cardPoints[i-(n-k)];
            minSum = Math.min(minSum, currSum);
        }
        return totPoints - minSum;
    }
}