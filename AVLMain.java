package Trees;

public class AVLMain {
    public static void main(String[] args) {
        AVL avl = new AVL();
        avl.insert(1);
        avl.insert(2);
        avl.insert(3);
        avl.insert(4);
        avl.insert(5);
        avl.insert(6);
        avl.insert(7);

        System.out.println(avl.height());
        avl.display();
    }
}
