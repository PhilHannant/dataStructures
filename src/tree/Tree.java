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

    public void printInorder(){
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
