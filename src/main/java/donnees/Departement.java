/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package donnees;

/**
 *
 * @author fredericlopesgoncalvesmagalhaes
 */
public class Departement implements Comparable {
  private int id;
  private String dpt;
  private String lieu;
  
  public Departement(int id, String dpt, String lieu) {
    this.id = id; this.dpt = dpt; this.lieu = lieu;
  } // Constructeur
  
  public Departement(int id) {
    this(id, "-1", "-1");
    this.id=id;
  } // Constructeur
  
  public int getId() {return id;} // getId
  public String getDepartement() {return dpt;} // getDepartement
  public String getLieu() {return lieu;} // getLieu
  
  public boolean equals(Object o) {
    Departement d = (Departement)o;
    return this.id == d.id;
  } // equals
  
  public String toString() {return dpt;} // toString
  
  public int compareTo(Object o) {
    int id = ((Departement)o).id;
    if(this.id > id) {return 1;} else if(this.id < id) {return -1;} else {return 0;}
  } // compareTo
  
}
