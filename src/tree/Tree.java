package tree;

public class Tree {

    private Node root;

    public Tree(int rootData){
        if (root == null) {
            this.root = new Node(null, null, rootData);
        }
    }

    public void addNode(int data){
        addNodeHelper(data, root);
    }

    public void addNodeHelper(int data, Node currentNode){
        if(data < currentNode.data){

        }
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
