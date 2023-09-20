package Trees;

class NodeValue extends BinarySearchTree{
    public int maxValue, minValue, maxSize;

    NodeValue(int minValue, int maxValue, int maxSize){
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.maxSize = maxSize;
    }
}

public class LargestBST extends BinarySearchTree{
    public NodeValue largestBSTHelper(Node root){
        if(root == null){
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        NodeValue left = largestBSTHelper(root.left);
        NodeValue right = largestBSTHelper(root.right);

        if(left.maxValue < root.value && root.value < right.minValue){
            return new NodeValue(Math.min(root.value, left.minValue), Math.max(root.value, right.maxValue),
                    left.maxSize + right.maxSize + root.value);
        }

        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }

    public int largestBST(Node root){
        return largestBSTHelper(root).maxSize;
    }

    public static void main(String[] args) {
        LargestBST bst = new LargestBST();

        bst.insert(6);
        bst.insert(4);
        bst.insert(3);
        bst.insert(5);
        bst.insert(7);
        bst.insert(8);
        bst.insert(1);

        System.out.println(bst.largestBST(bst.root));
    }
}
