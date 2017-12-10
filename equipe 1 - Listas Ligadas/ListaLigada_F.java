package listaligada_f;
import java.util.Scanner;

public class ListaLigada_F {
    
    private Celula primeira;
  
    private Celula ultima;

    private int totalDeElementos;
  
  
  
    public void adicionaNoComeco(Object elemento) {           //MÉTODO DE ADICIONAR NO COMEÇO
        Celula nova = new Celula(this.primeira, elemento);
        this.primeira = nova;
    
        if(this.totalDeElementos == 0){
            // caso especial da lista vazia
            this.ultima = this.primeira;
        }
        this.totalDeElementos++;
  }
  
    public void adiciona(Object elemento) {               //MÉTODO DE ADICIONAR NO FINAL
        if (this.totalDeElementos == 0) {
            this.adicionaNoComeco(elemento);
        } else {
            Celula nova = new Celula(elemento);
            this.ultima.setProxima(nova);
            this.ultima = nova;
            this.totalDeElementos++;
        }
    }
  /*
    public String toString() {                        //MÉTODO DE PERCORRER A LISTA

    // Verificando se a Lista está vazia
    if(this.totalDeElementos == 0){
         return "[]";
    }
  
    StringBuilder builder = new StringBuilder("[");
    Celula atual = primeira;

    // Percorrendo até o penúltimo elemento.
    for (int i = 0; i < this.totalDeElementos - 1; i++) {
         builder.append(atual.getElemento());
          builder.append(", ");
          atual = atual.getProxima();
    }

    // último elemento
    builder.append(atual.getElemento());
    builder.append("]");
  
    return builder.toString();
}   
  */
    
public void getLista(){     //MÉTODO DE PERCORRER A LISTA
    if(this.totalDeElementos == 0){
        System.out.println("[]");
    }else{
        Celula aux = this.primeira;
        System.out.print("[");
        for(int i = 0;i<this.totalDeElementos-1;i++){
            System.out.print(aux.getElemento()+",");
            aux = aux.getProxima();
        }
        System.out.println(aux.getElemento()+"]");
    }
}
    
    public Object pega(int posicao) {       //MÉTODO PARA PEGAR ELEMENTO DA LISTA
        return this.pegaCelula(posicao).getElemento();
}     
    
    
    private boolean posicaoOcupada(int posicao){              //MÉTODO AUXILIAR DE ADICIONAR OU REMOVER EM QUALQUER POSIÇÃO DA LISTA
        return posicao >= 0 && posicao < this.totalDeElementos;
}

    private Celula pegaCelula(int posicao) {      
        if(!this.posicaoOcupada(posicao)){
             throw new IllegalArgumentException("Posição não existe");
        }

    Celula atual = primeira;
    
    for (int i = 0; i < posicao; i++) {
        atual = atual.getProxima();
    }
    
    return atual;
}
    
 
  
    public void adiciona(int posicao, Object elemento) {         //MÉTODO PRINCIPAL DE ADICIONAR EM QUALQUER POSIÇÃO DA LISTA
        if(posicao == 0){ // No começo.
             this.adicionaNoComeco(elemento);
        } else if(posicao == this.totalDeElementos){ // No fim.
              this.adiciona(elemento);
            } else {
                Celula anterior = this.pegaCelula(posicao - 1);
                Celula nova = new Celula(anterior.getProxima(), elemento);
                anterior.setProxima(nova);
                this.totalDeElementos++;
  }
}
  
    public void removeDoComeco() {              //MÉTODO DE REMOVER DO COMEÇO  OBS: IGUAL PARA DUPLAMENTE LIGADA
        if (!this.posicaoOcupada(0)) {
           throw new IllegalArgumentException("Posição não existe");
    }

    this.primeira = this.primeira.getProxima();
    this.totalDeElementos--;
  
    if (this.totalDeElementos == 0) {
        this.ultima = null;
    }
}
    
    public void removeDoFim() {     //MÉTODO DE REMOVER DO FIM OBS: IGUAL PARA DUPLAMENTE LIGADA  
        if (!this.posicaoOcupada(this.totalDeElementos - 1)) {
        throw new IllegalArgumentException("Posição não existe");
    }
    if (this.totalDeElementos == 1) {
        this.removeDoComeco();
    } else {
        Celula penultima = this.ultima.getAnterior();
        penultima.setProxima(null);
        this.ultima = penultima;
        this.totalDeElementos--;
    }
}
    
    public void remove(int posicao) {  //MÉTODO DE REMOVER DE QUALQUER POSIÇÃO OBS: IGUAL PARA DUPLAMENTE LIGADA
        if (!this.posicaoOcupada(posicao)) {
        throw new IllegalArgumentException("Posição não existe");
    }

    if (posicao == 0) {
        this.removeDoComeco();
    } /*else if (posicao == this.totalDeElementos - 1) {
        this.removeDoFim();*/
     else {
        Celula anterior = this.pegaCelula(posicao - 1);
        Celula atual = anterior.getProxima();
        Celula proxima = atual.getProxima();
    
        anterior.setProxima(proxima);
        proxima.setAnterior(anterior);
    
        this.totalDeElementos--;
  }
}

    public boolean contem(Object elemento) {        //MÉTODO DE SABER SE UM ELEMENTO ESTÁ NA LISTA
        Celula atual = this.primeira;

        while (atual != null) {
            if (atual.getElemento().equals(elemento)) {
            return true;
        }
        atual = atual.getProxima();
    }
    return false;
}

public int tamanho(){           //MÉTODO DE SABER O TOTAL DE ELEMENTOS
    return this.totalDeElementos;
}


//*********************************************************************************LISTA DUPLAMENTE LIGADA

public void adicionaNoComecoDupla(Object elemento) {  //MÉTODO DE ADICIONAR NO COMEÇO
  if(this.totalDeElementos == 0){
    Celula nova = new Celula(elemento);
    this.primeira = nova;
    this.ultima = nova;
  } else {
    Celula nova = new Celula(this.primeira, elemento);
    this.primeira.setAnterior(nova);
    this.primeira = nova;
  }
  this.totalDeElementos++;
}

public void adicionaDupla(Object elemento) {    //MÉTODO DE ADICIONAR NO FINAL
  if (this.totalDeElementos == 0) {
    this.adicionaNoComeco(elemento);
  } else {
    Celula nova = new Celula(elemento);
    this.ultima.setProxima(nova);
    nova.setAnterior(this.ultima);
    this.ultima = nova;
    this.totalDeElementos++;
  }
}

public void adicionaDupla(int posicao, Object elemento) {       //MÉTODO DE ADICIONAR EM QUALQUER POSIÇÃO
  if(posicao == 0){ // No começo.
    this.adicionaNoComeco(elemento);
  } else if(posicao == this.totalDeElementos){ // No fim.
    this.adiciona(elemento);
  } else {
    Celula anterior = this.pegaCelula(posicao - 1);
    Celula proxima = anterior.getProxima();
    Celula nova = new Celula(anterior.getProxima(), elemento);
    nova.setAnterior(anterior);
    anterior.setProxima(nova);
    proxima.setAnterior(nova);
    this.totalDeElementos++;
  }
}





    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        ListaLigada_F l = new ListaLigada_F();
        int op, var1,var2,var3,var4, var5, var6, var7, pos1,pos2,pos3, pos4,pos5,sair = 0;
        
    do{
        System.out.println("                                            *****LISTA LIGADA******\n");
        System.out.println("Digite uma opção para LISTA SIMPLESMENTE LIGADA:                    Digite uma opção para LISTA DUPLAMENTE LIGADA:\n\n1-Adicionar no começo                                               10-Adicionar no começo\n2-Adicionar no fim                                                  11-Adicionar no fim\n3-Adicionar em qualquer posição                                     12-Adicionar em qualquer posição\n4-Pegar um elemento da lista                                        13-Remover do começo da lista\n5-Remover do começo da lista                                        14-Remover do fim da lista");
        System.out.println("6-Remover do fim da lista                                           15-Remover de qualquer posição\n7-Remover de qualquer posição\n8-Verificar elemento na lista\n9-Percorrer Lista(VALE PARA OS DOIS)\n                                            16-SAIR DO PROGRAMA");
       
        
        op = ler.nextInt();
        
        switch(op){
            case 1:
                System.out.println("Digite o elemento a ser inserido: ");
                var1 = ler.nextInt();
                l.adicionaNoComeco(var1);
                System.out.println("Elemento adicionado");
            break;
            
            case 2:
                System.out.println("Digite o elemento a ser inserido: ");
                var2 = ler.nextInt();
                l.adiciona(var2);
                System.out.println("Elemento adicionado");
            break;
            
            case 3:
                System.out.println("Digite o elemento a ser inserido: ");
                var3 = ler.nextInt();
                System.out.println("Digite a posição: OBS- A PARTIR DO 0");
                pos1 = ler.nextInt();                
                l.adiciona(pos1, var3);
                System.out.println("Elemento adicionado");
            break;
            
            case 4:
                System.out.println("Digite a posição do elemento: ");
                pos2 = ler.nextInt();
                System.out.println(l.pega(pos2));
            break;
            
            case 5:
                l.removeDoComeco();
                System.out.println("Elemento retirado");
            break;
            
            case 6:
                l.removeDoFim();
                System.out.println("Elemento retirado");
            break;
            
            case 7:
                System.out.println("Digite a posição do elemento: OBS- A PARTIR DO 0");
                pos3 = ler.nextInt();
                l.remove(pos3);
                System.out.println("Elemento retirado");
            break;
            
            case 8:
                System.out.println("Digite o elemento: ");
                var4 = ler.nextInt();
                if(l.contem(var4) == true){
                    System.out.println("Está na lista");
                }else{
                    System.out.println("Não está na lista");
                };
            break;
            
            case 9:
                l.getLista();               
            break;
            
            case 10:
                System.out.println("Digite o elemento:");
                var5 = ler.nextInt();
                l.adicionaNoComecoDupla(var5);
                System.out.println("Elemento adicionado");
            break;
            
            case 11:
                System.out.println("Digite o elemento:");
                var6 = ler.nextInt();
                l.adicionaDupla(var6);
                System.out.println("Elemento adicionado");
            break;
            
            case 12:
                System.out.println("Digite o elemento:");
                var7 = ler.nextInt();
                System.out.println("Digite a posição: OBS- A PARTIR DO 0");
                pos4 = ler.nextInt();
                System.out.println("Elemento adicionado");
                l.adicionaDupla(pos4, var7);
            break;
            
            case 13:
                l.removeDoComeco();
                System.out.println("Elemento retirado");
            break;
            
            case 14:
                l.removeDoFim();
                System.out.println("Elemento retirado");
            break;
            
            case 15:
                System.out.println("Digite  a posição:");
                pos5 = ler.nextInt();
                l.remove(pos5);
                System.out.println("Elemento retirado");
            break;
            case 16:
                sair = 1;
            break;
            
            default:
                System.out.println("Insira uma opção válida");
            break;
        }    
    }while(sair == 0);
    
}
}