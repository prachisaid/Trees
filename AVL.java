package Trees;

public class AVL {
    public static class Node{
        private int value;
        private Node left;
        private Node right;
        private int height;

        public Node(int value){
            this.value = value;
        }

        public int getValue(){
            return value;
        }
    }

    private Node root;

    public AVL(){}

    public int height(){
        return height(root);
    }
    private int height(Node node){
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
        return rotate(node);
    }

    private Node rotate(Node node){
        if(height(node.left) - height(node.right) > 1){
            // left heavy
            if(height(node.left.left) - height(node.left.right) > 0){
               // LL Case
                return LL_Rotate(node);
            }
            if(height(node.left.left) - height(node.left.right) < 0){
                // LR Case
                node.left = LL_Rotate(node.left);
                return RR_Rotate(node);
            }
        }

        if(height(node.left) - height(node.right) < -1){
            // right heavy
            if(height(node.right.left) - height(node.right.right) < 0){
                // RR Case
                return RR_Rotate(node);
            }
            if(height(node.right.left) - height(node.right.right) > 0){
                // RL Case
                node.right = RR_Rotate(node.right);
                return LL_Rotate(node);
            }
        }

        return node;
    }

    private Node LL_Rotate(Node p){
        Node c = p.left;
        Node g = c.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;
        return c;
    }

    private Node RR_Rotate(Node p){
        Node c = p.right;
        Node g = c.right;
        Node t = c.left;

        c.left = p;
        p.right = t;

        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return c;
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
}

