package arvoresbinarias.ex01;

public class Tree {
    private Node root; // Raiz
    public Tree() { //Inicializa a arvore
        root = null;
    }

    public void insert(long v){
        Node node = new Node(); //criar um novo nó
        node.item = v; //atribui o valor recebido ao item de dados do nó
        node.right = null;
        node.left = null;

        if(root==null) root = node;
        else{ //se não for a raiz
            Node current = root;
            Node before;
            while(true){
                before = current;
                if (v <= current.item) { //ir para a esquerda
                    current = current.left;

                    if (current == null) {
                        before.left = node;
                        return;
                    }
                }
                else{
                    current = current.right; //ir para a direita
                    if (current==null){
                        before.right = node;
                        return;
                    }
                }
            }
        }
    }

    public Node search(long key){
        if(root == null) return null; // se a arvore esta vazia
        Node current = root; //começa a procurar da raiz
        while (current.item != key){ // enquanto nao encontrar
            if(key < current.item) current = current.left; //vai para a esquerda
            else current = current.right; // vai para a direita
            if(current == null) return null; // sai se encontrar uma folha
        }
        return current;
    }

    public boolean remove(long v){
        if(root == null) return false; // se a arvore esta vazia
        Node current = root;
        Node dad = root;
        boolean left_child = true;

        // Buscar o valor
        while(current.item != v){ // enquanto nao encontrar
            dad = current;
            if(v < current.item){ // caminha para a esquerda
                current = current.left;
                left_child = true; // é filho a esquerda? true
            }
            else{ // caminha para a direita
                current = current.right;
                left_child = false; // é filho a direita? false
            }
        }
        if (current == null) return false; // sai se encontra uma folha vinculada ao pai

        //se não possui nenhum filho (se for uma folha), remove ele
        if(current.left == null && current.right == null){
            if(current == root) root = null; //se for a raiz
            else if(left_child) dad.left = null; //se for flho a esquerda do pai
            else dad.right = null; // se for filho a direita do pai
        }

        // Se é pai e não possui um filho a direita, substitui pela subarvore a direita
        else if(current.right ==null){
            if(current == root) root = current.left; // se for a raiz
            else if (left_child) dad.left=current.left; // se for filho a esquerda do pai
            else dad.right = current.left; // se for filho a direita do pai
        }

        // Se é pai e nao possui um filho a esquerda, substitui pela subarvore a esquerda
        else if( current.left == null){
            if(current == root) root = current.right; // se for a raiz
            else if (left_child) dad.left=current.right; // se for filho a esquerda do pai
            else dad.right = current.right; // se for filho a direita do pai
        }

        // Se possui mais de um filho, se for um avô ou outro grau maior de parentesco
        else{
            Node after = node_after(current);
            // Usando sucessor que seria o Nó mais a esquerda da subarvore a direita do No que deseja-se remover
            if(current == root) root = after; // se for a raiz
            else if(left_child) dad.left = after; // se for filho a esquerda do pai
            else dad.right = after; // se for filho a direita do pai
            after.left = current.left;  // acertando o ponteiro a esquerda do sucessor agora que ele assumiu
                                        // a posição correta na arvore
        }
        return true;
    }

    // O sucessor é o Nó mais a esquerda da subarvore a direita do No que foi passado como parametro do metodo
    public Node node_after(Node delete){ // O parametro é a referencia para o No que deseja-se apagar
        Node after_dad = delete;
        Node after = delete;
        Node current = delete.right; // vai para a subarvore a direita

        while(current != null){ // enquanto nao chegar no Nó mais a esquerda
            after_dad = after;
            after = current;
            current = current.left; // caminha para a esquerda
        }
        if(after != delete.right){ // se sucessor nao é o filho a direita do Nó que deverá ser eliminado
            after_dad.left = after.left; // pai herda os filhos do sucessor que sempre serão a direita
            // lembrando que o sucessor nunca poderá ter filhos a esquerda, pois, ele sempre será o
            // Nó mais a esquerda da subarvore a direita do Nó apaga.
            // lembrando também que sucessor sempre será o filho a esquerda do pai
            after.right = delete.right; // guardando a referencia a direita do sucessor para
            // quando ele assumir a posição correta na arvore

        }
        return after;
    }

    public void walk(){
        System.out.print("\n Exibindo em ordem: ");
        inOrder(root);
        System.out.print("\n Exibindo em pós-ordem: ");
        posOrder(root);
        System.out.print("\n Exibindo em pre-ordem: ");
        preOrder(root);
        System.out.print("\n Altura da arvore: " + height(root));
        System.out.print("\n Quantidade de folhas: " + leaves(root));
        System.out.print("\n Quantidade de Nós: " + coutNodes(root));
        if (root != null ) {  // se arvore nao esta vazia
            System.out.print("\n Valor minimo: " + min().item);
            System.out.println("\n Valor maximo: " + max().item);
        }

    }

    public void inOrder(Node current){
        if (current!=null){
            inOrder(current.left);
            System.out.print(current.item + " ");
            inOrder(current.right);
        }
    }

    public void posOrder(Node current){
        if(current != null){
            posOrder(current.left);
            posOrder(current.right);
            System.out.print(current.item + " ");
        }
    }

    public void preOrder(Node current){
        if(current != null){
            System.out.print(current.item + " ");
            preOrder(current.left);
            preOrder(current.right);
        }
    }

    public int height(Node current) {
        if(current == null || (current.left == null && current.right == null))
            return 0;
        else {
            if (height(current.left) > height(current.right))
                return ( 1 + height(current.left) );
            else
                return ( 1 + height(current.right) );
        }
    }

    public int leaves(Node current) {
        if(current == null) return 0;
        if(current.left == null && current.right == null) return 1;
        return leaves(current.left) + leaves(current.right);
    }

    public int coutNodes(Node current) {
        if(current == null)  return 0;
        else return ( 1 + coutNodes(current.left) + coutNodes(current.right));
    }

    public Node min() {
        Node current = root;
        Node before = null;
        while (current != null) {
            before = current;
            current = current.left;
        }
        return before;
    }

    public Node max() {
        Node current = root;
        Node before = null;
        while (current != null) {
            before = current;
            current = current.right;
        }
        return before;
    }
}
