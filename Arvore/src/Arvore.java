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

    public void RemoveElemento(int informacao){
        Node raiz = getArvore();
        if (raiz == null) {
            return;
        }
        PercorreInOrdem(raiz.getEsquerda());

        if (raiz.getInformacao() == informacao)

        PercorreInOrdem(raiz.getDireita());
    }

    public Node getArvore() {
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

    }
}