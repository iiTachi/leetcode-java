package Q007_ReverseInteger_Easy;

/**
 * @author Howie Lu
 * @version Updated at 2020/01/11
 * @description
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class ReverseInteger {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            // 弹出x的最后一位
            int pop = x % 10;
            x /= 10;
            // 如果rev大于Integer.MAX_VALUE / 10或者小于Integer.MIN_VALUE / 10，则会溢出
            if (rev > Integer.MAX_VALUE / 10)
                return 0;
            if (rev < Integer.MIN_VALUE / 10)
                return 0;
            // 将弹出的一位推入rev的最后一位
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
