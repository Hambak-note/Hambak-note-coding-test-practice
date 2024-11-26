import java.io.*;
import java.util.*;

public class Main {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> preorderList = new ArrayList<>();

        String line;
        while(true) {

            line = br.readLine();
            if(line == null || line.equals("")) break;
            preorderList.add(Integer.parseInt(line));
        }

        int[] preorder = preorderList.stream().mapToInt(i -> i).toArray();

        TreeNode BST = constructBSTFromPreorder(preorder, 0, preorder.length - 1);
        postOrderTraversal(BST);
        System.out.println(sb);
    }

    private static TreeNode constructBSTFromPreorder(int[] preorder, int start, int end) {

        if(start > end) return null;

        TreeNode root = new TreeNode(preorder[start]);

        int rightStart = start + 1;
        while( rightStart <= end && preorder[rightStart] < root.value) {
            rightStart++;
        }

        root.left = constructBSTFromPreorder(preorder, start + 1, rightStart - 1);
        root.right = constructBSTFromPreorder(preorder, rightStart, end);

        return root;
    }

    private static void postOrderTraversal(TreeNode node) {

        if(node == null) return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        sb.append(node.value + "\n");
    }
}

class TreeNode {

    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}