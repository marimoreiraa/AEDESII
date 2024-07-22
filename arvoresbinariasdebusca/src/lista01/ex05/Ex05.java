package lista01.ex05;

public class Ex05 {

    public static boolean verifyTrees(Node root1, Node root2){
        if(root1 == null && root2 == null) return true;
        else if(root1 == null || root2 == null) return false;
        else if(root1.getItem() != root2.getItem()) return false;
        else return verifyTrees(root1.getLeft(), root2.getLeft()) && 
                    verifyTrees(root1.getRight(),root2.getRight());
    }

    public static void main(String[] args) {
        BinaryTree tree1 = new BinaryTree();
        tree1.insert(10);
        tree1.insert(5);
        tree1.insert(15);

        BinaryTree tree2 = new BinaryTree();
        tree2.insert(10);
        tree2.insert(5);
        tree2.insert(16);

        if(verifyTrees(tree1.getRoot(), tree2.getRoot())){
            System.out.println("As árvores são iguais");
        }
        else{
            System.out.println("As árvores são diferentes");
        }
    }
}
