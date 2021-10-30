//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 1352 👎 0


package leetcode.editor.cn;

//Java：数组中的第K个最大元素
public class P215KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new P215KthLargestElementInAnArray().new Solution();
        // TO TEST
        final int kthLargest = solution.findKthLargest(new int[]{2,1}, 2);
        System.out.println(kthLargest);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            int p = 0;
            int r = nums.length - 1;
            int q = 0;
            final int res = nums.length - k;
            while (p <= r) {
                q = partition(nums, p, r);
                if (q < res) {
                    p = q + 1;
                } else if (q > res) {
                    r = q - 1;
                } else {
                    break;
                }
            }
            return nums[q];

        }

        private int partition(int[] nums, int p, int r) {
            int temp = nums[p];
            int i = p;
            int j = r;
            while (i < j) {
                while (nums[j] >= temp && i < j) {
                    j--;
                }
                if (i < j) {
                    nums[i] = nums[j];
                }
                while (nums[i] <= temp && i < j) {
                    i++;
                }
                if (i < j) {
                    nums[j] = nums[i];
                }
            }
            nums[i] = temp;
            return i;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}