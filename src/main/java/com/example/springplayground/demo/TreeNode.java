package com.example.springplayground.demo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }

    public static TreeNode build(int[] t, int i) {
        if (i >= t.length || t[i] == -1) return null;
        TreeNode node = new TreeNode(t[i]);
        node.left = build(t, 2 * i + 1);
        node.right = build(t, 2 * i + 2);
        return node;
    }

    public static boolean ifLeaf(TreeNode node) {
        return node.right == null && node.right == null;
    }

    public static void bfs(TreeNode root) {
        if (root == null) return;
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);
        while (!dq.isEmpty()) {
            TreeNode node = dq.poll();
            if (node.val != -1) {
                list.add(node.val);
            } else {
                list.add(-1);
                continue;
            }
            if (node.left != null) {
                dq.offer(node.left);
            } else {
                dq.offer(new TreeNode(-1));
            }
            if (node.right != null) {
                dq.offer(node.right);
            } else {
                dq.offer(new TreeNode(-1));
            }
        }
        while (list.get(list.size() - 1) == -1) {
            list.remove(list.size() - 1);
        }
        System.out.println(list);
    }

    public static void main(String[] args) {

    }

    static void run() {

    }
}
