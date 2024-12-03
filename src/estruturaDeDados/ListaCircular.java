package estruturaDeDados;

public class ListaCircular {
    private class No {
        int valor;
        No proximo;

        No(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    private No cabeca; // Início da lista
    private int tamanho; // Quantidade de elementos na lista

    public ListaCircular() {
        this.cabeca = null;
        this.tamanho = 0;
    }

    public void insereInicio(int i) {
        No novoNo = new No(i);
        if (cabeca == null) {
            cabeca = novoNo;
            cabeca.proximo = cabeca; // Referência circular
        } else {
            No atual = cabeca;
            while (atual.proximo != cabeca) {
                atual = atual.proximo;
            }
            novoNo.proximo = cabeca;
            atual.proximo = novoNo;
            cabeca = novoNo;
        }
        tamanho++;
    }

    public void insereFim(int i) {
        No novoNo = new No(i);
        if (cabeca == null) {
            cabeca = novoNo;
            cabeca.proximo = cabeca;
        } else {
            No atual = cabeca;
            while (atual.proximo != cabeca) {
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
            novoNo.proximo = cabeca;
        }
        tamanho++;
    }

    public boolean buscaElemento(int i) {
        if (cabeca == null) {
            return false;
        }
        No atual = cabeca;
        do {
            if (atual.valor == i) {
                return true;
            }
            atual = atual.proximo;
        } while (atual != cabeca);
        return false;
    }

    public Object buscaIndice(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }
        No atual = cabeca;
        for (int i = 0; i < indice; i++) {
            atual = atual.proximo;
        }
        return atual.valor;
    }

    public void removeInicio() {
        if (cabeca == null) {
            throw new IllegalStateException("Lista vazia");
        }
        if (tamanho == 1) {
            cabeca = null;
        } else {
            No atual = cabeca;
            while (atual.proximo != cabeca) {
                atual = atual.proximo;
            }
            cabeca = cabeca.proximo;
            atual.proximo = cabeca;
        }
        tamanho--;
    }

    public void removeFim() {
        if (cabeca == null) {
            throw new IllegalStateException("Lista vazia");
        }
        if (tamanho == 1) {
            cabeca = null;
        } else {
            No atual = cabeca;
            No anterior = null;
            while (atual.proximo != cabeca) {
                anterior = atual;
                atual = atual.proximo;
            }
            anterior.proximo = cabeca;
        }
        tamanho--;
    }

    public void removeIndice(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }
        if (indice == 0) {
            removeInicio();
            return;
        }
        No atual = cabeca;
        No anterior = null;
        for (int i = 0; i < indice; i++) {
            anterior = atual;
            atual = atual.proximo;
        }
        anterior.proximo = atual.proximo;
        tamanho--;
    }

    public void insereElementoPosicao(int i, int posicao) {
        if (posicao < 0 || posicao > tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        if (posicao == 0) {
            insereInicio(i);
            return;
        }
        No novoNo = new No(i);
        No atual = cabeca;
        for (int j = 0; j < posicao - 1; j++) {
            atual = atual.proximo;
        }
        novoNo.proximo = atual.proximo;
        atual.proximo = novoNo;
        tamanho++;
    }
}

