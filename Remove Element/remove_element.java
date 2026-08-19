public class remove_element {

    public static int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            if (nums[left] == val) {
                nums[left] = nums[right];
                right--;
            } else {
                left++;
            }
        }

        return left;
    }

    public static void main(String[] args) {

        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;

        int k = removeElement(nums, val);

        System.out.println("k = " + k);

        System.out.print("nums = [");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i]);

            if (i < k - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}