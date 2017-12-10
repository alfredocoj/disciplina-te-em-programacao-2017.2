
package conjuntos;
import java.util.LinkedList;
import java.util.ArrayList;
public class ConjuntoEspalhamento {
    private ArrayList<LinkedList<String>> tabela = new ArrayList<LinkedList<String>>();
    private int tamanho=0;
    public ConjuntoEspalhamento(){
        for (int i=0;i<26;i++){
            LinkedList<String> lista = new LinkedList<String>();
            tabela.add(lista);
        }
    }
        private int calculaIndiceDaTabela(String palavra){
        return palavra.toLowerCase().charAt(0) %26;
        }
    
    public void adiciona(String palavra){
         if(!this.contem(palavra)){
             int indice = this.calculaIndiceDaTabela(palavra);
             LinkedList<String> lista =this.tabela.get(indice);
             lista.add(palavra);
             this.tamanho=this.tamanho+1;
         }
    }
    public void remove (String palavra){
        if(this.contem(palavra)){
            int indice = this.calculaIndiceDaTabela(palavra);
            LinkedList<String> lista = this.tabela.get(indice);
            lista.remove(palavra);
            this.tamanho=this.tamanho-1;
        }
    }
    public boolean contem (String palavra){
        int indice = this.calculaIndiceDaTabela(palavra);
        LinkedList<String> lista = this.tabela.get(indice);
        return lista.contains(palavra);
    }
    
    public ArrayList<String> pegaTodas(){
        ArrayList<String> palavras = new ArrayList<String>();
        for (int i=0;i<this.tabela.size();i++){
            palavras.addAll(this.tabela.get(i));
        }
        return palavras;
    }
    public int tamanho(){
        return this.tamanho;
    }
    
    
}
