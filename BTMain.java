package Trees;

import java.util.Scanner;

public class BTMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree bt = new BinaryTree();
        bt.insert(sc);
//        bt.prettyDisplay();
        bt.preInPostTraversal();
    }
}
