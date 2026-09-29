class Solution {
    public int[][] diagonalSort(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        // Diagonals starting from first row
        for (int col = 0; col < m; col++) {

            ArrayList<Integer> arr = new ArrayList<>();

            int i = 0;
            int j = col;

            while (i < n && j < m) {
                arr.add(mat[i][j]);
                i++;
                j++;
            }

            Collections.sort(arr);

            i = 0;
            j = col;
            int idx = 0;

            while (i < n && j < m) {
                mat[i][j] = arr.get(idx);
                idx++;
                i++;
                j++;
            }
        }

        // Diagonals starting from first column
        for (int row = 1; row < n; row++) {

            ArrayList<Integer> arr = new ArrayList<>();

            int i = row;
            int j = 0;

            while (i < n && j < m) {
                arr.add(mat[i][j]);
                i++;
                j++;
            }

            Collections.sort(arr);

            i = row;
            j = 0;
            int idx = 0;

            while (i < n && j < m) {
                mat[i][j] = arr.get(idx);
                idx++;
                i++;
                j++;
            }
        }

        return mat;
    }
}