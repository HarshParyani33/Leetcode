class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> diary = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int sum = 0;
        return CS(candidates, candidates.length, target, 0, diary, res, sum);
    }
    public List<List<Integer>> CS(int[] candidates, int n, int t, int idx,  List<Integer> diary, List<List<Integer>> res,int sum){
        if(idx ==n){
            if(sum== t){
               res.add(new ArrayList<>(diary));
               
            }
            return res;
        }
        CS(candidates, candidates.length, t, idx+1, diary, res, sum);

        if(candidates[idx]+sum <=t){
            diary.add(candidates[idx]);
            sum = sum+candidates[idx];
            CS(candidates, candidates.length, t, idx, diary, res, sum);
            diary.remove(diary.size() - 1);
            sum -=candidates[idx];
        }
        return res;
    }
}