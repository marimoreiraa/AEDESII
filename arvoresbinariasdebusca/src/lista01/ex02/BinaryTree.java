package lista01.ex02;

public class BinaryTree {
    private Node root;

    public BinaryTree(){
        root = null;
    }

    public void insert(long item){
        Node node = new Node();
        node.item = item;
        node.right = null;
        node.left = null;
        if (root == null) root=node;
        else{
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (item < current.item) {
                    current = current.left;
                    if (current == null) {
                        parent.left = node;
                        return;
                    }
                } 
                else {
                    current = current.right;
                    if (current == null) {
                        parent.right = node;
                        return;
                    }
                }
            
                
            }
        }
    }

    public void walk(){
        System.out.println("\n Exibindo em Ordem: ");
        inOrder(root);
    }

    public void inOrder(Node current){
        if (current != null) {
            inOrder(current.left);
            System.out.println(current.item+" ");
            inOrder(current.right);
        }
    }
}
