import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{13,-5,3,3,-1,13,3,1,-9,
                                -4,9,12,6,-9,-6,-12,-8,
                                3,12,14,4,-15,2,-11,4,
                                -12,10,9,-6,-3,-8,14,7,
                                3,2,-8,-7,-10,8,-8,-7,
                                -6,-11,6,-7,-2,9,-8,8,
                                -2,13,-10,-2,0,-14,-13,
                                -4,11,3,-3,-7,3,-4,8,13,
                                13,-15,-9,10,0,-2,-12,1,
                                2,9,1,8,-4,8,-7,9,7,-2,
                                -15,14,0,-13,-13,-12,-2,
                                -1,-11,8,10,12,6,8,4,12,
                                3,11,-12,-2,-3,5,-15,6,
                                -10,-4,-1,-1,-10,13};


        if(nums.length < 3){
            System.out.println("Invalid array");
        }
        Arrays.sort(nums);
        int arrLength= nums.length;
        Set<List<Integer>> resultsSet = new HashSet<>();
        for (int i = 0; i < arrLength-2; i++) {
            int currentNumber = nums[i];
            int leftPointer = i+1;
            int rightPointer = arrLength-1;
            for (int j = i; j < arrLength; j++) {
               int sum = currentNumber + nums[leftPointer] + nums[rightPointer];
               if(sum == 0){
                   List<Integer> result = new ArrayList<>();
                   result.add(currentNumber);
                   result.add(nums[leftPointer]);
                   result.add(nums[rightPointer]);
                   resultsSet.add(result);
                   leftPointer ++;
               } else if(sum < 0){
                   leftPointer++;
               } else {
                   rightPointer--;
               }
               if(leftPointer == rightPointer){
                   break;
               }
            }
        }
        System.out.println(resultsSet.stream().toList());
    }
}
