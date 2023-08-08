package Trees;
import java.util.*;

public class BoundaryTraversal extends BinarySearchTree{
    public ArrayList<Integer> traverseBoundary(Node root){
        ArrayList<Integer> res = new ArrayList<>();
        if(isLeaf(root) == false){
            res.add(root.value);
        }
        addLeftBoundary(root, res);
        addLeaves(root, res);
        addRightBoundary(root, res);
        return res;
    }

    void addLeftBoundary(Node node, ArrayList<Integer> res){
        Node cur = node.left;

        while(cur != null){
            if(isLeaf(cur) == false){
                res.add(cur.value);
            }

            if(cur.left != null){
                cur = cur.left;
            }
            else{
                cur = cur.right;
            }
        }
    }

    void addRightBoundary(Node node, ArrayList<Integer> res){
        Node cur = node.right;
        ArrayList<Integer> lst = new ArrayList<>();

        while(cur != null){
            if(isLeaf(cur) == false){
                lst.add(cur.value);
            }

            if(cur.right != null){
                cur = cur.right;
            }
            else{
                cur = cur.left;
            }
        }

        for(int i = lst.size() - 1; i >= 0; --i){
            res.add(lst.get(i));
        }
    }

    void addLeaves(Node node, ArrayList<Integer> res){
        if(isLeaf(node)){
            res.add(node.value);
            return;
        }

        if(node.left != null){
            addLeaves(node.left, res);
        }

        if(node.right != null){
            addLeaves(node.right, res);
        }
    }

    private boolean isLeaf(Node cur) {
        return (cur.left == null) && (cur.right == null);
    }
}
