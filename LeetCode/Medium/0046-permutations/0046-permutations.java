class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums)
            numsList.add(num);
        recPermute(numsList, new ArrayList<>());
        return result;
    }

    public void recPermute(List<Integer> nums, List<Integer> list) {
        if (nums.size() == 0){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            list.add(num);
            nums.remove(i);
            recPermute(nums, list);
            nums.add(i,num);
            list.remove(list.size()-1);
        }
    }
}