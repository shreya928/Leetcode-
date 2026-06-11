class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m==0 && n==0)return;
        if(n==0)return; 
        int i=0, j=nums1.length-nums2.length, k=0;
        while(i<nums1.length && k<nums2.length){
            if(nums1[i]>nums2[k]){
                nums1[j] = nums1[i];
                nums1[i] = nums2[k];
                k++;
                j++;
            }
            if(nums1[i]==0){
                nums1[i] = nums2[k];
                k++;
            }
            i++;
        }
        Arrays.sort(nums1);
    }
}