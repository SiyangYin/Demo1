package com.example.springplayground.demo;

public class JZ847 {

//    4
//  2   6
// 1 3 5 7

//    4
//  3   6
//     5 7

//  2
// 1

//      5
//    2   7
//   1 3 6

//    2
//   1 3

//      5
//       7
//      6

    public static void main(String[] args) {
        int[] t = {4, 2, 6, 1, 3, 5, 7};
        int v = 2;
        TreeNode root = TreeNode.build(t, 0);
        TreeNode node = run(root, v);
        TreeNode.bfs(node);
        t = new int[]{5, 2, 7, 1, 3, 6};
        v = 4;
        root = TreeNode.build(t, 0);
        node = run(root, v);
        TreeNode.bfs(node);
    }

    static TreeNode run(TreeNode root, int v) {
        if (root == null) return null;
        TreeNode[] a = dfs(root, v);
        return cnt(a[0]) > cnt(a[1]) ? a[0] : a[1];
    }

    static TreeNode[] dfs(TreeNode node, int v) {
        if (node == null) return new TreeNode[2];
        if (node.val <= v) {
            TreeNode[] a = dfs(node.right, v);
            node.right = a[0];
            return new TreeNode[]{node, a[1]};
        } else {
            TreeNode[] a = dfs(node.left, v);
            node.left = a[1];
            return new TreeNode[]{a[0], node};
        }
    }

    static int cnt(TreeNode node) {
        if (node == null) return 0;
        return cnt(node.left) + cnt(node.right) + 1;
    }
}
