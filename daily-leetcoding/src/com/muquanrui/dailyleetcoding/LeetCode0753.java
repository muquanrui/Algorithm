package com.muquanrui.dailyleetcoding;

import java.util.HashSet;
import java.util.Set;

/**
 * @author muquanrui
 * @date 2023/1/10 11:44
 */

public class LeetCode0753 {
    StringBuilder sb = new StringBuilder();
    int n, k, mod;
    // 记录访问过的边
    Set<Integer> visited = new HashSet<>();

    public String crackSafe(int N, int K) {
        n = N;
        k = K;
        mod = (int) Math.pow(10, n - 1);
        // 从0点出发
        dfs(0);
        sb.append("0".repeat(n - 1));
        return sb.toString();
    }

    void dfs(int u) {
        // 对于每个点循环出去的k条边即可
        for (int i = 0; i < k; i++) {
            // 边的编号
            int v = u * 10 + i;
            // 已经访问过的边跳过
            if (visited.contains(v)) {
                continue;
            }
            // 标记访问过的边
            visited.add(v);
            // 去掉第一位为节点编号
            dfs(v % mod);
            // 添加最后一位数字
            sb.append(i);
        }
    }
}
