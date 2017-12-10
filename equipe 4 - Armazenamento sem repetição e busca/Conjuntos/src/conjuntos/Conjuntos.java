
package conjuntos;

public class Conjuntos {

    public static void main(String[] args) {
    ConjuntoEspalhamento conjunto = new ConjuntoEspalhamento();
    
    conjunto.adiciona("palavra");
    conjunto.adiciona("computador");
    conjunto.adiciona("apostila");
    conjunto.adiciona("instrutor");
    conjunto.adiciona("mesa");
            conjunto.adiciona("telefone");
            if (!conjunto.contem("apostila")){
                System.out.println("Erro :  Não tem a palavra apostila!");
            }
            conjunto.remove("apostila");
             if (conjunto.contem("apostila")){
                System.out.println("Erro : tem a palavra apostila!");
            }
              if (conjunto.tamanho()!=5){
                System.out.println("Erro : o tamanho do conjunto deveria ser 5!");
            }
              if(conjunto.contem("computador")){
                  System.out.println("possui computador!");
              }
              if (conjunto.contem("instrutor")){
                  System.out.println("\npossui instrutor!");
              }
             
    }
    
}
