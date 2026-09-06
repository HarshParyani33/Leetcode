class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        StringBuilder sb= new StringBuilder();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        String[]arr = new String[]{"--", "--", "abc", "def","ghi","jkl", "mno", "pqrs", "tuv", "wxyz"};
        return LC(digits, 0, arr, res, sb);
    }
    public List<String> LC(String digits, int i, String[]arr, List<String>res, StringBuilder sb){
        if(i== digits.length()){
            res.add(sb.toString());
            return res;
        }
        int num =digits.charAt(i) - '0';
        String choice = arr[num];

        for(int j=0; j<choice.length(); j++){
            sb.append(choice.charAt(j));
            LC(digits, i+1, arr, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        return res;
    }
}