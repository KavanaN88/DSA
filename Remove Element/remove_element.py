def remove_element(nums, val):
    k = 0

    for num in nums:
        if num != val:
            nums[k] = num
            k += 1

    return k


nums = [3, 2, 2, 3]
val = 3

k = remove_element(nums, val)

print("k =", k)
print("nums =", nums[:k])