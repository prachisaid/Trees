package Trees;

public class LCABst extends BinarySearchTree{

    public Node lowestCommonAncestor(Node root, Node p, Node q){
        if (root == null) return null;

        int cur = root.value;

        if(cur < p.value && cur < q.value){
            return lowestCommonAncestor(root.right, p, q);
        }
        if(cur > p.value && cur > q.value){
            return lowestCommonAncestor(root.left, p,  q);
        }

        return root;
    }
    public static void main(String[] args) {
        LCABst bst = new LCABst();

        bst.insert(6);
        bst.insert(4);
        bst.insert(3);
        bst.insert(5);
        bst.insert(7);
        bst.insert(8);
        bst.insert(1);

//        System.out.println(bst.lowestCommonAncestor(bst.root));
    }
}
