package lista01.ex07;

public class Ex07 {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);
        tree.insert(1);

        long value = 4;
        Node sucessor = tree.sucessor(value);
        if(sucessor != null){
            System.out.println("Sucessor de " + value + " é " + sucessor.item);
        }
        else{
            System.out.println("Não existe sucessor de " + value);
        }
    }
}
