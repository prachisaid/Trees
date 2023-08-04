package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BinaryTree {

    public BinaryTree(){

    }

    private static class Node{
        private int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }
    }

    private class Pair{
        private Node node;
        int num;

        public Pair(){

        }
        public Pair(Node node, int num){
            this.node = node;
            this.num = num;
        }
    }

    private Node root;

    public void insert(Scanner sc){
        System.out.println("Enter the root node value");
        int value = sc.nextInt();
        root = new Node(value);

        populate(sc, root);
    }

    private void populate(Scanner sc, Node node){
        System.out.println("Do you want to enter left of " + node.value);
        boolean left = sc.nextBoolean();

        if(left){
            System.out.println("Enter the value of left of " +node.value);
            int value = sc.nextInt();
            node.left = new Node(value);
            populate(sc, node.left);
        }

        System.out.println("Do you want to enter right of " + node.value);
        boolean right = sc.nextBoolean();

        if(right){
            System.out.println("Enter the value of right of " +node.value);
            int value = sc.nextInt();
            node.right = new Node(value);
            populate(sc, node.right);
        }
    }

    public void display(){
        display(root, "");
    }

    private void display(Node node, String indent){
        if(node == null){
            return;
        }

        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "");
    }

    public void prettyDisplay(){
        prettyDisplay(root, 0);
    }

    private void prettyDisplay(Node node, int level){
        if(node == null){
            return;
        }

        prettyDisplay(node.right, level+1);

        if(level != 0){
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }

            System.out.println("|------->" +node.value);
        }
        else{
            System.out.println(node.value);
        }

        prettyDisplay(node.left, level+1);

    }

    public void preorder(){
        preorder(root);
    }
    
    private void preorder(Node node){
        List<Integer> ans = new ArrayList<>();
        if(node == null){
            return;
        }

        Stack<Node> stack = new Stack<>();
        Node n = node;
        stack.push(n);

        while(!stack.isEmpty()){
            ans.add(stack.peek().value);
            n = stack.pop();

            if(n.right != null){
                stack.push(n.right);
            }
            if(n.left != null){
                stack.push(n.left);
            }
        }

        System.out.println(ans);
    }

    public void preInPostTraversal(){
        preInPostTraversal(root);
    }

    private void preInPostTraversal(Node node){
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(node, 1));
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        if(root == null){
            return;
        }

        while(!stack.isEmpty()){
            Pair p = stack.pop();

            if(p.num == 1){
                pre.add(p.node.value);
                p.num++;
                stack.push(p);

                if(p.node.left != null){
                    stack.push(new Pair(p.node.left, 1));
                }
            }

            else if(p.num == 2){
                in.add(p.node.value);
                p.num++;
                stack.push(p);

                if(p.node.right != null){
                    stack.push(new Pair(p.node.right, 1));
                }
            }

            else{
                post.add(p.node.value);
            }
        }
    }
}
