package tree;

import lists.LinkedList;
import lists.Queue;

import java.util.Collection;
import java.util.Iterator;

public class Tree {

    private Node root;
    private Queue<Integer> deleteQueue;
    private int result;
    private int maxLevel;

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

    public Node findPrevious(int nodeData){
        try {
            if (root.data == nodeData){
                return null;
            }
            return findPreviousHelper(null, root, nodeData);
        } catch (NullPointerException ex) {
            System.out.println("not found");
            return null;
        }
    }

    public Node findPreviousHelper(Node previous, Node current, int nodeData){
        if(current != null) {
            if (current.data == nodeData) {
                return previous;
            } else {
                if(nodeData < current.data){
                    return findPreviousHelper(current, current.left, nodeData);
                } else {
                    return findPreviousHelper(current, current.right, nodeData);
                }
            }
        }
        return null;
    }

    public Object[] findPreviousObj(int nodeData){
        try {
            if (root.data == nodeData){
                Object[] nodeDetails = {root, "root"};
                return nodeDetails;
            }
            return findPreviousHelperObj(null, root, nodeData, "");
        } catch (NullPointerException ex) {
            System.out.println("not found");
            return null;
        }
    }

    public Object[] findPreviousHelperObj(Node previous, Node current, int nodeData, String side){
        if(current != null) {
            if (current.data == nodeData) {
                Object[] nodeDetails = {previous, side};
                return nodeDetails;
            } else {
                if(nodeData < current.data){
                    return findPreviousHelperObj(current, current.left, nodeData, "left");
                } else {
                    return findPreviousHelperObj(current, current.right, nodeData, "right");
                }
            }
        }
        return null;
    }

    public void addNode(int data) {
        if (data != root.data) {
            addNode(data, root);
        }
    }


    public void addNode(int data, Node currentNode){
        if(data < currentNode.data) {
            if (currentNode.left == null) {
                currentNode.left = new Node(null, null, data);
            } else {
                addNode(data, currentNode.left);
            }
        } else if (data > currentNode.data){
            if (currentNode.right == null) {
                currentNode.right = new Node(null, null, data);
            } else {
                addNode(data, currentNode.right);
            }
        }
    }

    public boolean deleteNode(int nodeData) {
        //if root is null exit
        if (root == null) {
            return false;
        } else {
            deleteNode(root, nodeData);
            return true;
        }
    }


    public Node deleteNode(Node node, int nodeData) {
        if (node == null) {
            return null;
        }
        if (nodeData < node.data) {
            node.left = deleteNode(node.left, nodeData);
        } else if (nodeData > node.data){
            node.right = deleteNode(node.right, nodeData);
        } else {
            if (node.right == null && node.left == null) {
                return null;
            } else if (node.right == null) {
                return node.left;
            } else if (node.left == null) {
                return node.right;
            }
            node.data = getMin(node.right);
            node.right = deleteNode(node.right, node.data);
            return node;
        }
    return node;
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


    public boolean isSubTreeLesser(Node node, int value) {
        if (node == null) {
            return true;
        }
        if (node.data < value && isSubTreeLesser(node.left, value) && isSubTreeLesser(node.right, value)){
            return true;
        } else {
            return false;
        }
    }

    public boolean isSubTreeGreater(Node node, int value) {
        if (node == null) {
            return true;
        }
        if (node.data > value && isSubTreeGreater(node.left, value) && isSubTreeGreater(node.right, value)){
            return true;
        } else {
            return false;
        }
    }

    public boolean checkBST(){
        System.out.println(Integer.MIN_VALUE);
        return checkBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    //O(N)

    public boolean checkBST(Node node, int max, int min){
        if(node == null ){
            return true;
        }
        if (node.data > min && node.data < max &&
                checkBST(node.left, node.data, min) &&
                checkBST(node.right, max, node.data)){
            return true;
        } else {
            return false;
        }
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
        return getMin(root);
    }

    public Node getMinNode(Node current){
        if(current.left == null){
            return current;
        } return getMinNode(current.left);
    }

    public int getMin(Node current){
        if(current.left == null){
            return current.data;
        } return getMin(current.left);
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

    public Node invertTree() {
        if(root!=null){
            invertTreeHelper(root);
        }

        return root;
    }

    public void invertTreeHelper(Node n){

        Node temp = n.left;
        n.left = n.right;
        n.right = temp;

        if(n.left!=null)
            invertTreeHelper(n.left);

        if(n.right!=null)
            invertTreeHelper(n.right);
    }


    public boolean checb(Node current, int min, int max){
        if(current == null){
            return true;
        }
        if(current.data > min && current.data < max &&
                checb(current.right, current.data, max) &&
                checb(current.left, min, current.data)){
            return true;
        } else {
            return false;
        }

    }

    public int getDeepestNode(){
        maxLevel = -1;
        result = -1;

        getDeepestNode(root, 0);
        return result;
    }

    public void getDeepestNode(Node node, int level){
        if(node != null){

            getDeepestNode(node.left, level++);

            if(level > maxLevel){

                maxLevel = level;
                result = node.data;
            }

            getDeepestNode(node.right, level++);
        }
    }

    public void levelOrderTraversal() {
        java.util.Queue<Node> levelOrder = new java.util.LinkedList<Node>();
        Node temp = root;
        levelOrder.add(temp);
        while(!levelOrder.isEmpty()){

            temp = levelOrder.remove();
            System.out.print(temp.data + " ");

            if(temp.left != null){
                levelOrder.add(temp.left);
            }
            if (temp.right != null){
                levelOrder.add(temp.right);
            }
        }
    System.out.println();

    }

    public int countNodes(){
        return countNodes(root);
    }

    public int countNodes(Node node){
        if(node != null) return countNodes(node.left) + countNodes(node.right) + 1;
        else return 0;
    }

    public Node find(int data){
        return find2(root, data);
    }

    public Node find(int data, Node node){
        if(node != null) {
            if (data == node.data) {
                return node;
            } else {
                if (data < node.data) {
                    return find(data, node.left);
                } else {
                    return find(data, node.right);
                }
            }
        }
        return null;
    }

    public Node find2(Node node, int data){
        if(node == null){
            return null;
        } else {
            if(data == node.data){
                return node;
            } else {
                if(data < node.data){
                    return find2(node.left, data);
                } else {
                    return find2(node.right, data);
                }
            }
        }
    }

    public int findSecondLargest(){
        return findSecondLargest(root);
    }

    public int findSecondLargest(Node node){
        if(node == null || (node.left == null && node.right == null)){
            return -1;
        }
        if(node.left != null && node.right == null){
            return getMaxHelper(node.left);
        }

        if(node.right != null && node.right.left == null && node.right.right == null){
            return node.data;
        }
        return findSecondLargest(node.right);
    }

    public int findLargest(){
        return findLargest(root);
    }

    public int findLargest(Node node){
        Node current = node;
        while(current.right != null){
            current = current.right;
        }
        return current.data;
    }

    public void topView(){
        if(root != null){
            topViewHelper(root);
        }
    }

    public void topViewHelper(Node node){
        if(node.left != null){
            traverseLeft(node.left);
        }
        System.out.println(node.data);
        if(node.right != null){
            traverseRight(node.right);
        }

    }

    public void traverseLeft(Node node){
        if(node.left != null){
            traverseLeft(node.left);
        }
        System.out.println(node.data);
    }

    public void traverseRight(Node node){
        System.out.println(node.data);
        if(node.right != null){
            traverseRight(node.right);
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
