import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        int resultSize = nums1.length + nums2.length;

        int j = 0;
        int k = 0;
        int[] result = new int[resultSize];
        for(int i = 0; i < resultSize; i++){
            if(j < nums1.length && k < nums2.length) {
                if (nums1[j] <= nums2[k]) {
                    result[i] = nums1[j];
                    j++;
                } else {
                    result[i] = nums2[k];
                    k++;
                }
            } else {
                if(j < nums1.length){
                    result[i] = nums1[j];
                    j++;
                }
                if(k < nums2.length){
                    result[i] = nums2[k];
                    k++;
                }
            }
        }
        double median = 0;
        if(resultSize % 2 == 0){
            median = (double)(result[((resultSize / 2) - 1)] + result[(resultSize / 2)]) / 2;
        } else {
            median = result[(resultSize/2)];
        }
        System.out.println(Arrays.toString(result));
        System.out.println(median);
    }
}
