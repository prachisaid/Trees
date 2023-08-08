package Trees;

import java.util.*;

public class BinarySearchTree {
    public static class Node{
        int value;
        Node left;
        Node right;
        int height;

        public Node(int value){
            this.value = value;
        }

        public int getValue(){
            return value;
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

    Node root;

    public BinarySearchTree(){}

    public int height(Node node){
        if(node == null){
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void insert(int val){
        root = insert(root, val);
    }

    private Node insert (Node node, int value){
        if(node == null){
            node = new Node(value);
            return node;
        }
        if(value < node.value){
            node.left = insert(node.left, value);
        }
        else{
            node.right = insert(node.right, value);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    public void populateSorted(int[] nums){
        populateSorted(nums, 0, nums.length);
    }

    private void populateSorted(int[] nums, int start, int end){
        if(start >= end){
            return;
        }
        int mid = (start + end) / 2;
        this.insert(nums[mid]);
        populateSorted(nums, start, mid);
        populateSorted(nums, mid + 1, end);
    }
    public boolean balance(){
        return balanced(root);
    }

    private boolean balanced(Node node){
        if(node == null){
            return true;
        }

        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public void display(){
        display(root, "Root node: ");
    }

    private void display(Node node, String details) {
        if(node == null){
            return;
        }

        System.out.println(details + node.getValue());
        display(node.left, "Left child of: " + node.getValue() + ": ");
        display(node.right, "Right child of: " + node.getValue() + ": ");
    }

    public void preorder(){
        preorder(root);
    }

//    private void preorder(Node node){
//        if(node == null){
//            return;
//        }
//
//        System.out.println(node.value);
//        preorder(node.left);
//        preorder(node.right);
//    }

    public void inorder(){
        inorder(root);
    }

//    private void inorder(Node node){
//        if(node == null){
//            return;
//        }
//
//        inorder(node.left);
//        System.out.println(node.value);
//        inorder(node.right);
//    }

    public void postorder(){
        postorder(root);
    }

//    private void postorder(Node node){
//        if(node == null){
//            return;
//        }
//
//        postorder(node.left);
//        postorder(node.right);
//        System.out.println(node.value);
//    }

    public void bfs(){
        bfs(root);
    }

    private void bfs(Node node){
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if(node == null){
            return;
        }

        queue.add(node);

        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> temp = new ArrayList<>();

            for(int i = 0; i < levelNum; i++){
                if(queue.peek().left != null){
                    queue.add(queue.peek().left);
                }
                if(queue.peek().right != null){
                    queue.add(queue.peek().right);
                }

                temp.add(queue.poll().value);
            }

            ans.add(temp);
        }

        System.out.println(ans);
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

    private void inorder(Node n){
        List<Integer> ans = new ArrayList<>();
        if(n == null){
            return;
        }

        Stack<Node> stack = new Stack<>();
        Node node = n;

        while(true){
            if(node != null){
                stack.push(node);
                node = node.left;
            }
            else{
                if(stack.isEmpty()){
                    break;
                }

                node = stack.pop();
                ans.add(node.value);
                node = node.right;
            }
        }

        System.out.println(ans);
    }

    private void postorder(Node node){
        List<Integer> lst = new ArrayList<>();
        if(node == null){
            return;
        }

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(node);

        while(!s1.isEmpty()){
            node = s1.pop();
            s2.push(node);

            if(node.left != null){
                s1.push(node.left);
            }

            if(node.right != null){
                s1.push(node.right);
            }
        }

        while(!s2.isEmpty()){
            lst.add(s2.pop().value);
        }
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

        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }
}
