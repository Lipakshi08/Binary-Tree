package BinaryTree;

public class Tree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class TreeInfo{
        int ht;
        int dam;
        TreeInfo(int ht, int dam){
            this.ht = ht;
            this.dam = dam;
        }
    }
    static class BinaryTree {
        static int idx = -1;

        public Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }
    public static TreeInfo diameter(Node root){
        if (root == null) {
            return new TreeInfo(0, 0);
        }
        TreeInfo left = diameter(root.left);
        TreeInfo right = diameter(root.right);

        int myHeight = Math.max(left.ht, right.ht) + 1;
        int dam1 = left.dam;
        int dam2 = right.dam;
        int dam3 = left.ht + right.ht + 1;

        int mydam = Math.max(Math.max(dam1, dam2), dam3);
        TreeInfo myInfo = new TreeInfo(myHeight, mydam);
        return myInfo;
    }
    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(diameter(root).dam);
    }
}
