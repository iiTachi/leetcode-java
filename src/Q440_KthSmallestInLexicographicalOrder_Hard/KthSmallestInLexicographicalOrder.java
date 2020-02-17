package Q440_KthSmallestInLexicographicalOrder_Hard;

/**
 * @author Howie Lu
 * @version Updated at 2020-02-06
 * @Description 字典序的第K小数字
 * 给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。
 *
 * 注意：1 ≤ k ≤ n ≤ 109。
 *
 * 示例 :
 *
 * 输入:
 * n: 13   k: 2
 *
 * 输出:
 * 10
 *
 * 解释:
 * 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
 *
 */
public class KthSmallestInLexicographicalOrder {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k = k - 1;
        while (k > 0) {
            //计算前缀之间的step数
            int steps = getSteps(n, curr, curr + 1);
            //前缀间距太大，需要深入一层
            if (steps > k) {
                curr *= 10;
                //多了一个确定节点，继续-1
                k -= 1;
            }
            //间距太小，需要扩大前缀范围
            else {
                curr += 1;
                k -= steps;
            }
        }
        return curr;
    }

    private int getSteps(int n, long curr, long next) {
        // 获取某一前缀n下的所有数字个数
        int steps = 0;
        while (curr <= n) {
            // 十叉树不总是满的，所以需要使用min(n + 1, next)
            steps += Math.min(n + 1, next) - curr;
            curr *= 10;
            next *= 10;
        }
        return steps;
    }
}
