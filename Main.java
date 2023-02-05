import java.util.*;

class Main {

  public List<List<Integer>> subset(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>();
    subsets.add(new ArrayList<>());

    for (int currentNum : nums) {//currentNUm=2
      // we will take the existing subsets and insert the current number in them to
      // create a new subset  
      int n = subsets.size(); //n=2
      for (int i = 0; i < n; i++) {
        // create a new subset from existing subset and insert the current element
        List<Integer> set = new ArrayList<>(subsets.get(i)); //[], [],[1]
        set.add(currentNum); //[1,2]
        subsets.add(set);//[],[1],[2],[1,2]
      }
    }
    return subsets;
  }

  public static void main(String[] args) {
    Main main = new Main();

    List<List<Integer>> result = main.subset(new int[] { 1, 3 });

    System.out.println(result);
  }
}