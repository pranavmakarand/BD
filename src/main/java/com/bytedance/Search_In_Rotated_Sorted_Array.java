package com.bytedance;

public class Search_In_Rotated_Sorted_Array {
	
	public int search(int[] nums, int target) {
		int ans = binarySearch(nums, target);
		return ans;
	}

	private static int binarySearch(int nums[], int target) {

		int low = 0;
		int high = nums.length - 1;

		while (low <= high) {

			int mid = (low + high) / 2;

			if (nums[mid] == target)
				return mid;
			if (nums[low] <= nums[mid]) {
				if (nums[low] <= target && target <= nums[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
			if (nums[high] > nums[mid]) {
				if (nums[mid] <= target && target <= nums[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}

		return -1;
	}

}
