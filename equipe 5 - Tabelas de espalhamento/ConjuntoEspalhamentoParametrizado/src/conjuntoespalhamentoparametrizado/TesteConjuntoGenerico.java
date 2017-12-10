
package conjuntoespalhamentoparametrizado;

public class TesteConjuntoGenerico {
    public static void main(String[] args) {
        ConjuntoEspalhamentoParametrizado conjunto = new ConjuntoEspalhamentoParametrizado();
        conjunto.adiciona(12);
        conjunto.adiciona('g');
        conjunto.adiciona(1.5);
        conjunto.adiciona("#@%");
        conjunto.adiciona("Gaby");
        conjunto.adiciona("Gizele");
        conjunto.adiciona("oi");
        
        System.out.println(conjunto.pegaTodos());
        
        //conjunto.remove(12);
        System.out.println(conjunto.pegaTodos());
    }
}

