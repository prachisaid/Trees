package Trees;

import java.util.ArrayList;
import java.util.List;

public class PrintPaths extends BinarySearchTree{
    public List<String> binaryTreePaths(Node root) {
        List<String> lst = new ArrayList<>();
        paths(root, lst, "");
        return lst;
    }

    private void paths(Node root, List<String> ans, String p){
        if(root.left == null && root.right == null){
            p += root.value;
            ans.add(p);
            return;
        }

        paths(root.left, ans, p + root.value + "->");
        paths(root.right, ans, p + root.value + "->");
    }
}
