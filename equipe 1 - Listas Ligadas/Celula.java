package listaligada_f;

public class Celula{
    private Celula proxima;
    private Celula anterior;
    private Object elemento;

    public Celula(Celula proxima, Object elemento) {
     this.proxima = proxima;
     this.elemento = elemento;
     }

  public Celula(Object elemento) {
     this.elemento = elemento;
  }

  public void setProxima(Celula proxima) {
      this.proxima = proxima;
  }

  public Celula getProxima() {
     return proxima;
  }
  
  public Object getElemento() {
      return elemento;
  }
  
  public Celula getAnterior() {
    return anterior;
  }
  
  public void setAnterior(Celula anterior) {
    this.anterior = anterior;
  }
}
