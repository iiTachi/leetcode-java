package Q001_TwoSum_Easy;

import java.util.HashMap;

/**
 * @author Howie Lu
 * @version Updated at 2020/01/04
 * @description
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for(int i = 0; i < length; ++i){
            //计算每个元素到达target需要的差值
            int difference = target - nums[i];
            //如果map中有以该差值为key的entry，则说明找到了这两个数，返回其下标
            if(map.containsKey(difference)){
                return new int[] {map.get(difference), i};
            }
            //将数组元素值作为key，下标作为value放入map中
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("没有两个数的和等于" + target);
    }
}
