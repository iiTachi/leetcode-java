package Q016_ThreeSumClosest_Middle;

import java.util.Arrays;

/**
 * @author Howie Lu
 * @version Updated at 2020-02-25
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        if(nums[0] == nums[length-1]) return 3 * nums[0]; //所有元素都相同
        int ans = nums[0] + nums[1] + nums[2];
        if(ans == target) return target; //ans刚好等于target
        for(int i = 0; i < length; ++i) {
            int left = i + 1;
            int right = length - 1;
            while(left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if(Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum; //sum距离target更近，将ans更新为sum的值
                if(sum > target)
                    --right;
                else if(sum < target)
                    ++left;
                else
                    return ans;
            }
        }
        return ans;
    }
}
