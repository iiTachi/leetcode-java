package Q167_TwoSumII_Easy;

import java.util.ArrayList;

/**
 * @author Howie Lu
 * @version Updated at 2020-02-12
 * @Description
 */
public class TwoSumII {
    public ArrayList<int[]> twoSum(int[] numbers, int target) {
        ArrayList<int[]> list = new ArrayList<>();
        int low = 0;
        int high = numbers.length-1;
        while(low < high)
        {
            int small = numbers[low];
            int big = numbers[high];
            if(small + big > target)
                high--;
            else if(small + big < target)
                low++;
            else if(small + big == target)
            {
                int[] res = new int[] {low+1, high+1};
                list.add(res);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TwoSumII twoSumII = new TwoSumII();
        int [] nums = {1,2,4,7,8,11,15};
        int target = 15;
        System.out.println("hello");
        ArrayList<int[]> x = twoSumII.twoSum(nums, target);
        System.out.println(x.get(0));
        System.out.println("world");
    }
}
