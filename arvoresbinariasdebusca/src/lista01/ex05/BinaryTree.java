package lista01.ex05;

public class BinaryTree {
    private Node root;

    public BinaryTree(){
        root = null;
    }
    
    public void insert(long item){
        Node node = new Node();
        node.item = item;
        node.left = null;
        node.right = null;

        if(root == null) root = node;
        else{
            Node current = root;
            Node parent;
            while(true){
                parent = current;
                if(item < current.item){
                    current = current.left;
                    if(current == null){
                        parent.left = node;
                        return;
                    }
                }
                else{
                    current = current.right;
                    if(current == null){
                        parent.right = node;
                        return;
                    }
                    }
                }
        }
    
    }


    public Node getRoot() {
        return root;
    }


    public void setRoot(Node root) {
        this.root = root;
    }
}
