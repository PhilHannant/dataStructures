package tree;

import lists.LinkedList;
import lists.Queue;

public class Tree {

    private Node root;
    private Queue<Integer> deleteQueue;

    public Tree(int rootData){
        if (root == null) {
            this.root = new Node(null, null, rootData);
        }
    }

    public Node findNode(int nodeData){
        try {
            if (root.data == nodeData) return root;
            return findNodeHelper(root, nodeData);
        } catch (NullPointerException ex) {
            System.out.println("not found");
            return null;
        }
    }

    public Node findNodeHelper(Node current, int nodeData){
        if(current != null) {
            if (current.data == nodeData) {
                return current;
            } else {
                if(nodeData < current.data){
                    return findNodeHelper(current.left, nodeData);
                } else {
                    return findNodeHelper(current.right, nodeData);
                }
            }
        }
        return null;
    }

    public Object[] findPrevious(int nodeData){
        try {
            if (root.data == nodeData){
                Object[] nodeDetails = {root, "root"};
                return nodeDetails;
            }
            return findPreviousHelper(null, root, nodeData, "");
        } catch (NullPointerException ex) {
            System.out.println("not found");
            return null;
        }
    }

    public Object[] findPreviousHelper(Node previous, Node current, int nodeData, String side){
        if(current != null) {
            if (current.data == nodeData) {
                Object[] nodeDetails = {previous, side};
                return nodeDetails;
            } else {
                if(nodeData < current.data){
                    return findPreviousHelper(current, current.left, nodeData, "left");
                } else {
                    return findPreviousHelper(current, current.right, nodeData, "right");
                }
            }
        }
        return null;
    }

    public void addNode(int data) {
        if(root == null){

        }
        if (data != root.data || root == null) {
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

    public boolean deleteNode(int nodeData){
        //goto node, add all children to queue, remove pointers and then add children from queue to the tree.
        Node node = findNode(nodeData);
        if (node == null) return false;
        deleteQueue = new Queue<Integer>(null);
        getChildren(node);
        Object[] previous = findPrevious(nodeData);
        Node previousNode = (Node) previous[0];
        System.out.println(previous[1]);
        if (previous[1] == "root") {
            root = null;
        } else if (previous[1] == "left"){
            previousNode.left = null;
        }  else {
            previousNode.right = null;
        }
        deleteQueue.deQueue();
          while(!deleteQueue.isEmpty()){
            if (deleteQueue.peek() != null) {
                addNode(deleteQueue.deQueueWithData());
            }
        }
        return true;
    }

    public void getChildren(Node current){
        if(current == null) {
            return;
        }
        deleteQueue.enQueue(current.data);
        getChildren(current.left);
        getChildren(current.right);
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

    public int deepestNode(){
        int deepest = 0;
        deepest = deepestNodeHelper(root);
        return deepest;
    }

    public int deepestNodeHelper(Node current){
        int rightMax = 0;
        int leftMax = 0;
        if(current == null){
            return -1;
        }
        rightMax = deepestNodeHelper(current.right);
        leftMax = deepestNodeHelper(current.left);
        return Math.max(rightMax, leftMax) + 1;
    }

    public int getData(Node node){
        try {
            return node.data;
        } catch (NullPointerException ex){
            ex.printStackTrace();
            System.out.println("not found");
            return -1;
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
