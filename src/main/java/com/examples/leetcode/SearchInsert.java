package com.examples.leetcode;

/**
 //给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 //
 // 请必须使用时间复杂度为 O(log n) 的算法。
 //
 //
 //
 // 示例 1:
 //
 //
 //输入: nums = [1,3,5,6], target = 5
 //输出: 2
 //
 //
 // 示例 2:
 //
 //
 //输入: nums = [1,3,5,6], target = 2
 //输出: 1
 //
 //
 // 示例 3:
 //
 //
 //输入: nums = [1,3,5,6], target = 7
 //输出: 4
 //
 //
 //
 //
 // 提示:
 //
 //
 // 1 <= nums.length <= 104
 // -104 <= nums[i] <= 104
 // nums 为 无重复元素 的 升序 排列数组
 // -104 <= target <= 104
 //
 // Related Topics 数组 二分查找
 // 👍 1659 👎 0
 */
public class SearchInsert {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        System.out.println (new SearchInsert ().searchInsert ( nums,5)); //2
        System.out.println (new SearchInsert ().searchInsert ( nums,2)); //1
        System.out.println (new SearchInsert ().searchInsert ( nums,7)); //4
        int[] nums1 = new int[]{1,3,5,6};
        System.out.println (new SearchInsert ().searchInsert ( nums1,0)); //0
        int[] nums2 = new int[]{1,3};
        System.out.println (new SearchInsert ().searchInsert ( nums2,3)); //1
        int[] nums3 = new int[]{1};
        System.out.println (new SearchInsert ().searchInsert ( nums3,0)); //0
    }

    public int searchInsert(int[] nums, int target) {
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            if (target <= nums[i]) {
                return i;
            }
            if (target > nums[i] && i < l-1 && target < nums[i+1]) {
                return i+1;
            }
        }
        if (target == nums[l-1]) {
            return l-1;
        }
        return l;
    }
}
