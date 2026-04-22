class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int arr[] = new int[n];
        Arrays.fill(arr,1);
        int count=0;
        for(int i=0; i<n-1; i++){
            if(ratings[i]<ratings[i+1]){
                arr[i+1] = arr[i]+1;
            }
        }
        for(int i=n-1; i>0; i--){
            if(ratings[i-1]>ratings[i]){
                arr[i-1] = Math.max(arr[i-1], arr[i] + 1);
            }
        }
        for(int i=0; i<n; i++){
            count += arr[i];
        }
        return count;
    }
}