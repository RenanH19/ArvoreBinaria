public class Arvore {
    private Node Arvore;

    Arvore(){
    }

    public void insereOrdenado(int informacao){
        if(Arvore == null){
            Arvore = new Node(informacao);
            return;
        }
        Node atual = Arvore;

        while(true) {
            if (informacao >= atual.getInformacao()) {
                if (atual.getDireita() == null) {
                    Node novoNo = new Node(informacao);
                    atual.setDireita(novoNo);
                    return;
                }
                atual = atual.getDireita();
            } else {
                if (atual.getEsquerda() == null) {
                    Node novoNo = new Node(informacao);
                    atual.setEsquerda(novoNo);
                    return;
                }
                atual = atual.getEsquerda();
            }
        }
    }

    public void PercorreInOrdem(Node raiz){
        if (raiz == null) {
            return;
        }
        PercorreInOrdem(raiz.getEsquerda());
        System.out.print(" - " + raiz.getInformacao() + " - ");

        PercorreInOrdem(raiz.getDireita());
    }

    public void PercorrePreOrdem(Node raiz){
        if (raiz == null){
            return;
        }
        System.out.print(" - " + raiz.getInformacao() + " - ");

        PercorrePreOrdem(raiz.getEsquerda());
        PercorrePreOrdem(raiz.getDireita());
    }

    public void PercorrePosOrdem(Node raiz){
        if (raiz == null){
            return;
        }

        PercorrePosOrdem(raiz.getEsquerda());
        PercorrePosOrdem(raiz.getDireita());
        System.out.print(" - " + raiz.getInformacao() + " - ");
    }

    public int calculaAlturaPos(Node raiz){
        if (raiz == null){
            return -1;
        }

        int alturaEsquerda = 0;
        int alturaDireita = 0;
        alturaEsquerda = calculaAlturaPos(raiz.getEsquerda());
        alturaDireita = calculaAlturaPos(raiz.getDireita());

        if (alturaDireita > alturaEsquerda){
            return alturaDireita + 1;
        }
        return alturaEsquerda + 1;
    }

    public Node RemoveElemento(int informacao, Node raiz) {
        if (raiz == null) {
            return null;
        }

        if (informacao == raiz.getInformacao()){
            System.out.println("Localizou elemento no nó " + raiz + " " + raiz.getInformacao());
            if (raiz.getDireita() != null){
                return raiz.getDireita();
            } else if(raiz.getEsquerda() != null){
                return raiz.getEsquerda();
            } else {
                return null;
            }
        }

        if (informacao > raiz.getInformacao()){
                raiz.setDireita(RemoveElemento(informacao, raiz.getDireita()));
        } else {
                raiz.setEsquerda(RemoveElemento(informacao, raiz.getEsquerda()));
        }
        return raiz; //chega aqui caso a informacao nao é a que procuro, logo vai retornar o proprio nó que será usado no setDireita ou esquerda, sem modificar a estrutura, só será modifica quando informacao == raiz.getinformacao
    }

    public Node getArvore(){
        return Arvore;
    }

    public static void main(String[] args) {
        Arvore arvorezinha = new Arvore();
        int[] vetor = {14, 15, 4, 9, 7, 18, 3, 5, 16, 20, 17, 9, 5};

        for(int i = 0; i < 13; i++ ){
            arvorezinha.insereOrdenado(vetor[i]);
        }

        arvorezinha.PercorreInOrdem(arvorezinha.getArvore());
        System.out.println();
        arvorezinha.PercorrePreOrdem(arvorezinha.getArvore());
        System.out.println();
        arvorezinha.PercorrePosOrdem(arvorezinha.getArvore());
        System.out.println();
        arvorezinha.RemoveElemento(7, arvorezinha.getArvore());
        System.out.println("Ordem após remoção: ");
        arvorezinha.PercorreInOrdem(arvorezinha.getArvore());

    }
}