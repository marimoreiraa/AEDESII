package general;

import java.util.Scanner;

public class BinaryTree {
    public static void main(String[] args) {
        try (Scanner read = new Scanner(System.in)) {
            Tree tree = new Tree();
            int option;
            long x;
            System.out.println("\nPrograma Arvore Binaria de Números long");
            do{
                System.out.print("\n***********************************");
                System.out.print("\nEntre com a opcao:");
                System.out.print("\n ----1: Inserir");
                System.out.print("\n ----2: Excluir");
                System.out.print("\n ----3: Pesquisar");
                System.out.print("\n ----4: Exibir");
                System.out.print("\n ----5: Sair do programa");
                System.out.print("\n***********************************");
                System.out.print("\n-> ");
                option = read.nextInt();
                switch(option) {
                    case 1: {
                        System.out.print("\n Informe o valor (long) -> ");
                        x = read.nextLong();
                        tree.insert(x);
                        break;
                    }
                    case 2: {
                        System.out.print("\n Informe o valor (long) -> ");
                        x = read.nextLong();
                        if ( !tree.remove(x) )
                            System.out.print("\n Valor nao encontrado!");;
                        break;
                    }
                    case 3: {
                        System.out.print("\n Informe o valor (long) -> ");
                        x = read.nextLong();
                        if( tree.search(x) != null )
                            System.out.print("\n Valor Encontrado");
                        else
                            System.out.print("\n Valor nao encontrado!");
                        break;
                    }
                    case 4: {
                        tree.walk();
                        break;
                    }
                } // fim switch
            } while(option != 5);
        }
    }

}
