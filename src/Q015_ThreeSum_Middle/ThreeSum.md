# 三数之和

## 题目描述

给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

 

示例：

```java
给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
```

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



## 解题思路

对于这类题目，我的思路是先排序，然后使用双指针来遍历数组

本题要求和为0的三个数，可以在一次for循环遍历中加入left和right两个左右指针，若三个位置的数加起来等于0，则将其加入list中，再把list加入大list。然后移动左右指针，直到其相遇，此时完成一次遍历。

为了保证题目要求的唯一性，最好的方法就是排序，这样相等的值就会相邻，遍历时若相邻两个值相等，跳过这个数据即可，代码如下：

```java
public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        //排序
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0; i < len; ++i) {
            // 排序后的数组若较小的一个大于0，则不可能有后续的三个数之和为0
            if(nums[i] > 0) return lists;

            // 若该位置的元素与上一次遍历的数字相等，就跳过这次循环，保证唯一性
            if(i > 0 && nums[i] == nums[i-1]) continue;

            //当前指针与左右指针
            int curr = nums[i];
            int L = i+1, R = len-1;
            
            while (L < R) {
                int tmp = curr + nums[L] + nums[R];
                if(tmp == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(curr);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    lists.add(list);
                    // 保证唯一性，跳过相邻的相等元素
                    while(L < R && nums[L+1] == nums[L]) ++L;
                    while (L < R && nums[R-1] == nums[R]) --R;
                    ++L;
                    --R;
                } else if(tmp < 0) {
                    // 三数和小于0，左指针右移
                    ++L;
                } else {
                    // 三数之和大于0，右指针左移
                    --R;
                }
            }
        }
        return lists;
    }
```

