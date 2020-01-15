package Q003_LongestSubstringWithoutRepeatingCharacters_Middle;

import java.util.HashMap;

/**
 * @author Howie Lu
 * @version Updated at 2020/01/12
 * @description
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */

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
