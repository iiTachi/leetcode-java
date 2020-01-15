# 无重复字符的最长字串

## 题目描述

给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

```c
输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
```

示例 2:

```c
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
```

示例 3:

```c
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
```

来源：[无重复的最长字串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters)




## 解题思路

使用：滑动窗口

滑动窗口其实就是一个队列,比如例题中的 `abcabcbb`，进入这个队列（窗口）为 `abc `满足题目要求，当再进入 a，队列变成了 `abca`，这时候不满足要求。所以，我们要移动这个队列

我们只要把队列的左边的元素移出就行了，直到满足题目要求

一直维持这样的队列，找出队列出现最长的长度时候，求出解

时间复杂度：O(n)

代码：

```java
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        // 如果s长度为0，则直接返回0
        if (s.length()==0) return 0;
        // 使用map来模拟窗口，字符做key保证唯一，下标做value
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0; // 保存当前不包含重复字符的最长字串的长度
        int left = 0; // 不包含重复字符的最长字串的开始下标（即最左边的下标）
        for(int i = 0; i < s.length(); i ++){
            // 如果map中包含该key，则更新left的值
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            // 无论map中包不包含，都把该位置字符对应的entry放入map
            map.put(s.charAt(i),i);
            // 更新max，即为当前max与i-left+1中较大的那一个
            max = Math.max(max,i-left+1);
        }
        return max;
    }
}
```

