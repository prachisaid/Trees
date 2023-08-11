package Trees;

import java.util.ArrayList;

public class LowestCommonAncestor extends BinarySearchTree{
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        ArrayList<Node> lst = new ArrayList<>();
        path(p, root, lst);
        ArrayList<Node> lst2 = new ArrayList<>();
        path(q, root, lst2);
        Node node = null;

        for (int j = 0; j < lst2.size(); j++) {
            if(lst.contains(lst2.get(j))){
                node = lst.get(j);
            }
        }

        return node;
    }

    private boolean path(Node p, Node root, ArrayList<Node> lst){
        if(root == null){
            return false;
        }

        lst.add(root);
        if(root == p){
            return true;
        }

        if(path(p, root.left, lst) || path(p, root.right, lst)){
            return true;
        }

        lst.remove(lst.size() - 1);
        return false;
    }
}
