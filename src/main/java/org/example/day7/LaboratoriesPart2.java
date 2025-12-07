package org.example.day7;

import org.example.AocInput;
import org.example.Puzzle;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("D")
public class LaboratoriesPart2 extends Puzzle {
    public LaboratoriesPart2(AocInput input) {
        super(input);
    }

    class TreeNode {
        int[] index;
        TreeNode left;
        TreeNode right;

        public TreeNode() {

        }

        public TreeNode(int[]index) {
            this.index = index;
        }

        public TreeNode(int[] index, TreeNode left, TreeNode right) {
            this.index = index;
            this.left = left;
            this.right = right;
        }
    }


    @Override
    public Object solve() {
            List<String> input = aocInput.lines();
            char[][] diagram = new char[input.size()][];
            for (int i = 0; i < input.size(); i++) {
                diagram[i] = input.get(i).toCharArray();
            }

            // Find starting column (S)
            int startCol = -1;
            for (int i = 0; i < diagram[0].length; i++) {
                if (diagram[0][i] == 'S') {
                    startCol = i;
                    break;
                }
            }

            // Find first splitter below S
            int firstRow = -1;
            for (int row = 1; row < diagram.length; row++) {
                if (diagram[row][startCol] == '^') {
                    firstRow = row;
                    break;
                }
            }

            if (firstRow == -1) {
                return 1L; // No splitters, one path straight down
            }

            // Use memoization: key = "row,col" -> number of paths from there
            Map<String, Long> memo = new HashMap<>();
            return countPaths(firstRow, startCol, diagram, memo);

    }

    private long countPaths(int row, int col, char[][] diagram, Map<String, Long> memo) {
        String key = row + "," + col;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Find next splitter going LEFT (col - 1)
        long leftPaths = 1; // Default: no more splitters, reaches bottom = 1 path
        for (int r = row + 1; r < diagram.length; r++) {
            if (col - 1 >= 0 && diagram[r][col - 1] == '^') {
                leftPaths = countPaths(r, col - 1, diagram, memo);
                break;
            }
        }

        // Find next splitter going RIGHT (col + 1)
        long rightPaths = 1; // Default: no more splitters, reaches bottom = 1 path
        for (int r = row + 1; r < diagram.length; r++) {
            if (col + 1 < diagram[r].length && diagram[r][col + 1] == '^') {
                rightPaths = countPaths(r, col + 1, diagram, memo);
                break;
            }
        }

        long total = leftPaths + rightPaths;
        memo.put(key, total);
        return total;
    }

//    public int countPaths(TreeNode root) {
//        if (root == null) {
//            return 0;  // Edge case: no tree at all
//        }
//
//        // If left child exists, count paths through it; otherwise, left direction is 1 path to bottom
//        int leftPaths = (root.left != null) ? countPaths(root.left) : 1;
//
//        // If right child exists, count paths through it; otherwise, right direction is 1 path to bottom
//        int rightPaths = (root.right != null) ? countPaths(root.right) : 1;
//
//        return leftPaths + rightPaths;
//    }

//    public int countNodes(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//
//        // Preorder: root first, then left, then right
//        int count = 1;  // count current node
//        count += countNodes(root.left);
//        count += countNodes(root.right);
//
//        return count;
//    }
//    public void preOrder(TreeNode root, char[][] diagram) {
//        if (root == null) {
//            return;
//        }
//
//        findNextChildren(root, diagram);
//        preOrder(root.left, diagram);
//        preOrder(root.right, diagram);
//    }

//    public void printPreOrder(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//
//        System.out.println(Arrays.toString(root.index));
//        printPreOrder(root.left);
//        printPreOrder(root.right);
//    }



//    public void findNextChildren(TreeNode node, char[][] diagram) {
//        for (int i = node.index[0]; i < diagram.length; i++) {
//            if (node.left == null && diagram[i][node.index[1] -1 ] == '^') {
//                node.left = new TreeNode(new int[]{i, node.index[1] -1});
//            }
//
//            if (node.right == null && diagram[i][node.index[1] + 1 ] == '^') {
//                node.right = new TreeNode(new int[]{i, node.index[1] +1});
//            }
//        }
//
//    }

    void printChars(char[][] chars) {
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                System.out.print(chars[i][j]);
            }
            System.out.println();
        }
    }
}
