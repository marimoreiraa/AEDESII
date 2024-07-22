package lista01.ex02;
import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        try (Scanner read = new Scanner(System.in)) {
            BinaryTree tree = new BinaryTree();
            int option;
            long item;
            System.out.println("\nArvore Binaria de Números");
            do{
                System.out.println("\n1 - Inserir\n2 - Exibir em Ordem\n3 - Sair");
                option = read.nextInt();
                switch(option){
                    case 1:
                        try {
                            System.out.println("Digite um número: ");
                            item = read.nextLong();
                            tree.insert(item);
                            } 
                        catch (Exception e) {
                            System.out.println("Erro: " + e.getMessage());
                        }
                        break;
                    case 2:
                        tree.walk();
                        break;
                }
            }while(option!=3);
        }
    }
}
