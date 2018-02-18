package tree;

public class Tree {

    private Node root;

    public Tree(int rootData){
        if (root == null) {
            this.root = new Node(null, null, rootData);
        }
    }

    public void addNode(int data) {
        if (data != root.data) {
            addNodeHelper(data, root);
        }
    }


    public void addNodeHelper(int data, Node currentNode){
        if(data < currentNode.data) {
            if (currentNode.left == null) {
                currentNode.left = new Node(null, null, data);
            } else {
                addNodeHelper(data, currentNode.left);
            }
        } else if (data > currentNode.data){
            if (currentNode.right == null) {
                currentNode.right = new Node(null, null, data);
            } else {
                addNodeHelper(data, currentNode.right);
            }
        }
    }

    public void printInOrder(){
        System.out.println("inOrder");
        printInOrderHelper(root);
    }

    public void printInOrderHelper(Node current){
        if(current == null){
            return;
        }
        printInOrderHelper(current.left);
        System.out.println(current.data);
        printInOrderHelper(current.right);

    }

    public void printPreOrder(){
        System.out.println("preOrder");
        printPreOrderHelper(root);
    }

    public void printPreOrderHelper(Node current){
        if(current == null){
            return;
        }
        System.out.println(current.data);
        printPreOrderHelper(current.left);
        printPreOrderHelper(current.right);

    }

    public void printPostOrder(){
        System.out.println("postOrder");
        printPostOrderHelper(root);
    }

    public void printPostOrderHelper(Node current){
        if(current == null){
            return;
        }
        printPostOrderHelper(current.left);
        printPostOrderHelper(current.right);
        System.out.println(current.data);
    }


    public int getMax(){
        return getMaxHelper(root);
    }

    public int getMaxHelper(Node current){
        if(current.right == null){
            return current.data;
        } return getMaxHelper(current.right);
    }

    public int getMin(){
        return getMinHelper(root);
    }

    public int getMinHelper(Node current){
        if(current.left == null){
            return current.data;
        } return getMinHelper(current.left);
    }

    private class Node {

        private Node left;
        private Node right;
        private int data;


        public Node(Node left, Node right, int data){
            this.left = left;
            this.right = right;
            this.data = data;
        }
    }
}
