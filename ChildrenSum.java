package Trees;

public class ChildrenSum extends BinarySearchTree{
    public static void changeTree(Node root) {
        if(root == null) return;

        int child = 0;

        if(root.left != null){
            child += root.left.value;
        }

        if(root.right != null){
            child += root.right.value;
        }

        if(child >= root.value){
            root.value = child;
        }
        else{
            if(root.left != null) root.left.value = root.value;
            else if(root.right != null) root.right.value = root.value;
        }

        changeTree(root.left);
        changeTree(root.right);

        int tot = 0;
        if(root.left != null) tot += root.left.value;
        if(root.right != null) tot += root.right.value;
        if(root.left != null || root.right != null) root.value = tot;
    }
}
