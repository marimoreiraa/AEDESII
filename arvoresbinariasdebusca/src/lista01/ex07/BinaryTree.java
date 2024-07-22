package lista01.ex07;

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

    public Node sucessor(long value){
        return recursiveSucessor(root, value);
    }

    private Node recursiveSucessor(Node node, long value){
        if(node == null) return null; //Valor não encontrado
        else if(value < node.item) return recursiveSucessor(node.left, value); //Busca na esquerda
        else if(value > node.item) {
            //Busca na direita mas o sucessor pode estar na raivx
            Node potencialSucessor = recursiveSucessor(node.right, value);
            if(potencialSucessor != null){
                return potencialSucessor;
            }
            else return node; //Nó atual é o sucessor
        }
        else return recursiveSucessor(node.right, value);
    }
}
