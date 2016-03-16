package donnees;

/**
 *
 * @author fredericlopesgoncalvesmagalhaes
 */
public class Fonction implements Comparable {
  
  private int id;
  private String fct;
  
  public Fonction(int id, String fct) {
    this.id = id; this.fct = fct;
  } // Constructeur
  
  public Fonction(int id) {
    this(id, "-1");
    this.id = id;
  } // Constructeur
  
  public int getId() {return id;} // getId
  public String getFonction() {return fct;} // getFonction
  
  public boolean equals(Object o) {
    Fonction f = (Fonction)o;
    return this.id == f.id;
  } // equals
  
  public String toString() {return fct;} // toString
  
  public int compareTo(Object o) {
    int id = ((Fonction)o).id;
    if(this.id > id) {return 1;} else if(this.id < id) {return -1;} else {return 0;}
  } // compareTo
  
}