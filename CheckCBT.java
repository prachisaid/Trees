package Trees;

public class CheckCBT extends BinarySearchTree {
    public boolean isCompleteTree(Node root) {
        int count = countNodes(root);
        return isCBT(root, 0, count);
    }

    private boolean isCBT(Node root, int i, int count) {
        if (root == null) return true;

        if (i >= count) return false;

        else {
            boolean left = isCBT(root.left, (2 * i + 1), count);
            boolean right = isCBT(root.right, (2 * i + 2), count);

            return (left && right);
        }
    }

    private int countNodes(Node root) {
        if (root == null) return 0;

        int ans = 1 + countNodes(root.left) + countNodes(root.right);

        return ans;

    }
}
