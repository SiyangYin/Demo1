package com.example.springplayground.demo;

public class JZ597 {

    static double max = Double.MIN_VALUE;
    static TreeNode maxNode;

    public static void main(String[] args) {
        int[] a = {1, -5, 11, 1, 2, 4, -2};
        TreeNode root = TreeNode.build(a, 0);
        run(root);
        a = new int[]{1, -5, 11};
        root = TreeNode.build(a, 0);
        run(root);
    }

    static void run(TreeNode node) {
        dfs(node);
        System.out.println(max);
        System.out.println(maxNode);
    }

    static int[] dfs(TreeNode node) {
        if (node == null) return new int[]{0, 0};
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int[] self = new int[]{left[0] + right[0] + node.val, left[1] + right[1] + 1};
        double avg = (double) self[0] / self[1];
        if (avg > max) {
            max = avg;
            maxNode = node;
        }
        return self;
    }
}
