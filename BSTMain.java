package Trees;

public class BSTMain {
    public static void main(String[] args) {
//        BoundaryTraversal bst = new BoundaryTraversal();
//        VerticalTraversal bst = new VerticalTraversal();
//        TopView bst = new TopView();
//        BottomView bst = new BottomView();
//        RightView bst = new RightView();
//        LowestCommonAncestorII bst = new LowestCommonAncestorII();
//        MaximumWidth bst = new MaximumWidth();
//        NodeDistanceK bst = new NodeDistanceK();
        MaximumTimeToBurnTree bst = new MaximumTimeToBurnTree();
//        bst.insert(15);
        bst.insert(10);
        bst.insert(2);
        bst.insert(30);
        bst.insert(1);
        bst.insert(5);
        bst.insert(17);
        bst.insert(60);
//        bst.insert(16);
//        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        bst.populateSorted(nums);
//        bst.display();
//        bst.inorder();
//        System.out.println(bst.balance());
//        bst.inorder();
//        bst.preInPostTraversal();
//        System.out.println(bst.traverseBoundary(bst.root));
//        bst.zigzagLevelOrder(bst.root);
//        bst.vertical(bst.root);
//        System.out.println(bst.lowestCommonAncestor(bst.root, bst.root.left, bst.root.right).value);
        System.out.println(bst.minTime(bst.root, 2));
    }

}
