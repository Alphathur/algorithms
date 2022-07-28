package com.examples.leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *
 *
 * 提示：
 *
 * 1 <= n <= 8
 * Related Topics
 * 字符串
 * 动态规划
 * 回溯
 */
public class GenerateParenthesis {

    /**
     *
     * n = 0 时 result = []
     * n = 1 时 result = ["()"]
     * n = 2 时 result = ["(())", "()()"]
     * 最开始有一个空字符串 a = "", 然后有一个字符串 b = "()"
     * 遍历 a 字符串的每个字符的位置，插入 b 字符串，每一轮会生成一个 List<String> 并且去重得到最终的结果
     *
     * () ==>
     * .()  ()() 0
     * (.)  (()) 1
     * ( ). ()() 2
     *
     * @param n
     * @return
     *
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<> ();
        res.add ("()");
        for (int i = 1; i < n; i++) {
            List<String> newRes = new ArrayList<> ();
            for(String temp : res) {
                for (int j = 0; j < temp.length (); j++) {
                    newRes.add (temp.substring (0, j) + "()" + temp.substring (j));
                }
            }
            res = newRes;
        }
        return res.stream ().distinct ().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        new GenerateParenthesis ().generateParenthesis (3);
    }
}
