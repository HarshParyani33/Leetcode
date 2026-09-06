class Solution {
    public List<String> generateParenthesis(int n) {
        int close = 0;
        int open = 0;
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        return GP(n,close, open, sb, res );
    }

    public List<String> GP(int n, int close, int open, StringBuilder sb, List<String> res){
        if(open == n && close ==n){
            res.add(sb.toString());
            return res;
        }
        if(open<n ){
            sb.append('(');
            GP(n, close, open+1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(close<open){
            sb.append(')');
            GP(n, close+1, open, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        return res;
    }
}