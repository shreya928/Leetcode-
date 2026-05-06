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

            StringBuilder sb = new StringBuilder(curr);
            for(int i=0; i<curr.length(); i++){
                char original = curr.charAt(i);
                for(int j=0; j<26; j++){
                    sb.setCharAt(i, (char)('a' + j));
                    String nextWord = sb.toString();
                    if(set.contains(nextWord)){
                        q.offer(new Pair(nextWord,len+1));
                        set.remove(nextWord);
                    }
                }
                sb.setCharAt(i, original); 
            }
        }
        return 0;
    }
}