import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        int target = 6;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            int lookUpNumber = target - nums[i];
            if(map.containsKey(lookUpNumber)){
                System.out.println(map.get(lookUpNumber) + " " + i);
                break;
            }
            map.put(nums[i], i);
        }
    }
}
