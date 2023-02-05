import java.util.*;

class Main {

  // Problem Statement #
  // Given a set with distinct elements, find all of its distinct subsets.

  // Example 1:

  // Input: [1, 3]
  // Output: [], [1], [3], [1,3]
  // Example 2:

  // Input: [1, 5, 3]
  // Output: [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3]

  public List<List<Integer>> subset(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>();
    subsets.add(new ArrayList<>());

    for (int currentNum : nums) {// currentNUm=2
      // we will take the existing subsets and insert the current number in them to
      // create a new subset
      int n = subsets.size(); // n=2
      for (int i = 0; i < n; i++) {
        // create a new subset from existing subset and insert the current element
        List<Integer> set = new ArrayList<>(subsets.get(i)); // [], [],[1]
        set.add(currentNum); // [1,2]
        subsets.add(set);// [],[1],[2],[1,2]
      }
    }
    return subsets;
  }

  // Problem Statement #
  // Given a set of numbers that might contain duplicates, find all of its
  // distinct subsets.

  // Example 1:

  // Input: [1, 3, 3]
  // Output: [], [1], [3], [1,3], [3,3], [1,3,3]

  public List<List<Integer>> subsetDupl(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> subsets = new ArrayList<>();
    subsets.add(new ArrayList<>());
    int startIndex = 0, endIndex = 0;
    for (int i = 0; i < nums.length; i++) {
      startIndex = 0;
      // if current and the prev elements are same, create new subsets only from the
      // subsets added in the prev steps
      if (i > 0 && nums[i] == nums[i - 1])
        startIndex = endIndex + 1;
      endIndex = subsets.size() - 1;
      for (int j = startIndex; j <= endIndex; j++) {
        // create a new subset from existing subset and insert the current element
        List<Integer> set = new ArrayList<>(subsets.get(j));
        set.add(nums[i]); //
        subsets.add(set);//
      }
    }
    return subsets;
  }

  public static void main(String[] args) {
    Main main = new Main();

    List<List<Integer>> result = main.subset(new int[] { 1, 5, 3 });

    System.out.println(result);

    List<List<Integer>> result1 = main.subsetDupl(new int[] { 1, 3, 3 });

    System.out.println(result1);
  }
}