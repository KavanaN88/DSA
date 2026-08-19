public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int a = m - 1;
        int b = n - 1;

        for (int k = m + n - 1; k >= 0; k--) {

            if (b < 0) {
                break;
            }

            if (a >= 0 && nums1[a] > nums2[b]) {
                nums1[k] = nums1[a];
                a--;
            } else {
                nums1[k] = nums2[b];
                b--;
            }
        }
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;

        int[] nums2 = {2, 5, 6};
        int n = 3;

        merge(nums1, m, nums2, n);

        // Print result
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }
}