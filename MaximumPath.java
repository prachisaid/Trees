package Trees;

public class MaximumPath extends BinarySearchTree{
    public int maxPathSum(Node node) {
        int[] diameter = new int[1];
        maxPathCount(node, diameter);
        return diameter[0];
    }

    private int maxPathCount(Node node, int[] maxVal){
        if(node == null){
            return 0;
        }

        int left = Math.max(0, maxPathCount(node.left, maxVal));
        int right = Math.max(0, maxPathCount(node.right, maxVal));

        maxVal[0] = Math.max(maxVal[0], left + right + node.value);

        return node.value + Math.max(left, right);
    }
}
