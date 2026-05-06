class Solution {
    class Pair{
        String s;
        int len;
        public Pair(String s, int len){
            this.s = s;
            this.len = len;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = 1;
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<wordList.size(); i++){
            set.add(wordList.get(i));
        }
        if(!set.contains(endWord))return 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord,1));

        while(!q.isEmpty()){
            Pair p = q.poll();
            String curr = p.s;
            len = p.len;
            if(curr.equals(endWord))return len;

            char[] arr = curr.toCharArray();
            for(int i=0; i<arr.length; i++){
                char original = arr[i];
                for(char ch='a'; ch<='z'; ch++){
                    arr[i] = ch;
                    String nextWord = new String(arr);
                    if(set.contains(nextWord)){
                        q.offer(new Pair(nextWord,len+1));
                        set.remove(nextWord);
                    }
                }
                arr[i] = original; 
            }
        }
        return 0;
    }
}