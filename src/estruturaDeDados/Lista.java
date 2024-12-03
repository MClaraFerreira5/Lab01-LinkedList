package estruturaDeDados;

public class Lista {
    int[] lista = new int[10];
    int quantidade;

    public Lista() {
        this.quantidade = 0;
        
    }

    public void insereInicio(int i) {
        if(lista.length == quantidade)
            return;
        for(int j = quantidade; j > 0; j--){
            lista[j] = lista[j-1];
        }
        lista[0] = i;
        quantidade++;
       
    }

    public boolean buscaElemento(int i) {
        for(int j = 0; j < quantidade; j++){
            if(lista[j] == i)
                return true;
        }
        return false;
    }

    public Object buscaIndice(int i) {
        for(int j = 0; j < quantidade; j++){
            if(lista[j] == i)
                return j;
        }
        return -1;
    }

    public void insereFim(int i) {
        if(lista.length == quantidade)
            return;
        lista[quantidade] = i;
        quantidade++;
    }

    public void removeInicio() {
        if(quantidade == 0)
            return;
        for(int j = 0; j < quantidade; j++){
            lista[j] = lista[j+1];
        }
        quantidade--;

    }

    public void removeFim() {
        if(quantidade == 0)
            return;
        lista[quantidade-1] = 0;
        quantidade--;
    }

    public void removeIndice(int i) {
        if(i < 0 || i >= quantidade)
            return;
        for(int j = i; j < quantidade - 1; j++){
            lista[j] = lista[j+1];
        }
        quantidade--;
    }

    public void insereElementoPosicao(int posicao, int valor) {
        if(quantidade == lista.length || posicao < 0 || posicao > quantidade)
            return;
        for(int j = quantidade; j > posicao; j++){
            lista[j] = lista[j-1];
        }
        lista[posicao] = valor;
        quantidade++;
    }

}