package Trees;

import java.util.Stack;

public class AverageSubtree extends BinarySearchTree{
    public static void main(String[] args) {
        AverageSubtree bst = new AverageSubtree();
        bst.insert(5);
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        bst.insert(14);

        System.out.println(bst.averageOfSubtree(bst.root));
    }

    public int averageOfSubtree(Node root) {
        int[] result = new int[1];
        postorder(root, result);
        Stack<Integer> stack = new Stack<>();
        if(stack.contains(1));
        return result[0];
    }

    public int[] postorder(Node root, int[] result){
        if(root == null) {
            return new int[] {0, 0};
        }

        int[] left = postorder(root.left, result);
        int[] right = postorder(root.right, result);

        int sum = root.value + left[0] + right[0];
        int cnt = 1 + left[1] + right[1];

        if(root.value == (sum / cnt)){
            result[0]++;
        }

        return new int[] {sum, cnt};
    }
}
