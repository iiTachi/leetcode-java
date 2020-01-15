# 整数反转

## 题目描述

给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:

```bash
输入: 123
输出: 321
```

 示例 2:

```bash
输入: -123
输出: -321
```

示例 3:

```bash
输入: 120
输出: 21
```


注意:

假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。


来源：[整数反转](https://leetcode-cn.com/problems/reverse-integer)

## 解题思路

反转整数类似于反转字符串，持续将原整数x最后一位弹出，并推到新整数rev的最后一位

弹出最后一位操作：

```java
pop = x % 10;
x /= 10;
```

推入新整数：

```java
rev = rev * 10 + pop;
```



而`rev * 10 + pop`操作可能会导致溢出，需要进行判断

若`rev > Integer.MAX_VALUE / 10`，则会正溢出

若`rev < Integer.MIN_VALUE / 10`，则会负溢出

代码如下：

```java
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
```

