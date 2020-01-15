package Q005_LongestPalindromicSubstring_Middle;

/**
 * @author Howie Lu
 * @version Updated at 2020/01/12
 * @description 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // 对奇数长度的串，中心是一个字符
            int len1 = expandAroundCenter(s, i, i);
            // 对偶数长度的串，中心是两个字符
            int len2 = expandAroundCenter(s, i, i + 1);
            // len即为最长回文子串的长度
            int len = Math.max(len1, len2);
            if (len > end - start) {
                // start为最长回文子串的开始位置
                start = i - (len - 1) / 2;
                // end为最长回文子串的结束位置
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    // expandAroundCenter方法通过从中心向两边拓展来求解最长的回文子串的长度
    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        // 从中心开始，若两边字符相等则继续向两边拓展
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
