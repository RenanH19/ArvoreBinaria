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

    public Node removeMaiorElemento(Node raiz) {
        if (raiz == null) {
            return null;
        }
        if (raiz.getDireita() != null) {
            raiz.setDireita(removeMaiorElemento(raiz.getDireita()));
        } else {
            if (raiz.getEsquerda() != null){
                return raiz.getEsquerda();
            }
            return null; //se chegou aqui, é um nó folha, logo a extremidade maior da arvore, retorno ela para dar um set null no nó que chamou ela.
        }
        return raiz;
    }

    public Node removeMenorElemento(Node raiz) {
        if (raiz == null) {
            return null;
        }
        if (raiz.getEsquerda() != null) {
            raiz.setEsquerda(removeMenorElemento(raiz.getEsquerda()));
        } else {
            if (raiz.getDireita() != null){
                return raiz.getDireita();
            }
            return null; //se chegou aqui, é um nó folha, logo a extremidade menor da arvore, retorno ela para dar um set null no nó que chamou ela.
        }
        return raiz;
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
        System.out.println();

        arvorezinha.removeMaiorElemento(arvorezinha.getArvore());
        System.out.println("Removendo maior elemento");
        arvorezinha.PercorreInOrdem(arvorezinha.getArvore());
        System.out.println();

        arvorezinha.removeMenorElemento(arvorezinha.getArvore());
        System.out.println("Removendo menor elemento");
        arvorezinha.PercorreInOrdem(arvorezinha.getArvore());
        System.out.println();

        arvorezinha.removeMaiorElemento(arvorezinha.getArvore());
        System.out.println("Removendo maior elemento");
        arvorezinha.PercorreInOrdem(arvorezinha.getArvore());
        System.out.println();

        arvorezinha.removeMaiorElemento(arvorezinha.getArvore());
        System.out.println("Removendo maior elemento");
        arvorezinha.PercorreInOrdem(arvorezinha.getArvore());
        System.out.println();

        arvorezinha.removeMenorElemento(arvorezinha.getArvore());
        System.out.println("Removendo menor elemento");
        arvorezinha.PercorreInOrdem(arvorezinha.getArvore());
        System.out.println();




    }
}