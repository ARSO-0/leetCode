public class Main {

    public static void main(String[] args) {
        int[] height = new int[]{1,1};

        int left = 0;
        int right = height.length - 1;
        int currentMax = 0;

        while(left < right){
            int w = right - left;
            int h = Math.min(height[left], height[right]);
            int area = h * w;
            currentMax = Math.max(currentMax, area);
            if(height[left] < height[right]) left++;
            else if(height[left] > height[right]) right--;
            else {
                left++;
                right--;
            }
        }
       System.out.println(currentMax);
    }
}
