class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int prod = 1;
        int curr = n;
        while(curr!=0){
            int num = curr%10;
            curr = curr/10;
            sum += num;
            prod *= num;
        }
        int tot = sum + prod;
        return n % tot == 0;
    }
}