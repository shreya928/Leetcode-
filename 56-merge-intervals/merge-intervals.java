class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        arr.add(new ArrayList<>());
        arr.get(0).add(intervals[0][0]);
        arr.get(0).add(intervals[0][1]);
        int i=1;
        while(i<intervals.length){
            int u =arr.get(arr.size()-1).get(0);
            int v = arr.get(arr.size()-1).get(1);

            if(intervals[i][0]<=v && intervals[i][1]>v){
                arr.get(arr.size()-1).set(1, intervals[i][1]);
            }else if(intervals[i][0]>v){
                arr.add(new ArrayList<>());
                arr.get(arr.size()-1).add(intervals[i][0]);
                arr.get(arr.size()-1).add(intervals[i][1]);
            }
            i++;
        }
        int ans[][] = new int[arr.size()][2];
        for(int j=0; j<arr.size(); j++){
            ans[j][0] = arr.get(j).get(0);
            ans[j][1] = arr.get(j).get(1);
        }
        return ans;
    }
}