class Solution:
    def merge(self, nums1, m, nums2, n):
        a = m - 1
        b = n - 1

        for k in range(m + n - 1, -1, -1):

            if b < 0:
                break

            if a >= 0 and nums1[a] > nums2[b]:
                nums1[k] = nums1[a]
                a -= 1
            else:
                nums1[k] = nums2[b]
                b -= 1


# Input
nums1 = [1, 2, 3, 0, 0, 0]
m = 3

nums2 = [2, 5, 6]
n = 3

# Create object
solution = Solution()

# Call merge
solution.merge(nums1, m, nums2, n)

# Print result
print(nums1)