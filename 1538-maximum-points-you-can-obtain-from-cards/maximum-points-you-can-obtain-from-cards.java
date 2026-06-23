class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int totPoints = 0;
        for(int num:cardPoints){
            totPoints += num;
        }
        if(k == n)return totPoints;
        int curr = 0;
        for(int i=0; i<n-k; i++){
            curr += cardPoints[i];
        }
        int maxPoint = totPoints - curr;
        for(int j=n-k; j<n; j++){
            curr += cardPoints[j] - cardPoints[j-(n-k)];
            maxPoint = Math.max(maxPoint, totPoints - curr);
        }
        return maxPoint;
    }
}