package donnees;

import java.util.Date;

/**
 * 634.1 Programmation - TP P01
 * 
 * @author lopesmagalhaesfrederic
 * @version 1.0
 */
public class Employe implements Comparable {
  
  private int id;
  private String nom, prenom;
  private Departement departement;
  private Fonction fonction;
  private Date dateEng;
  
  public Employe(String nom, String prenom, Fonction fonction, Date dateEng, Departement departement) {
    this.nom = nom;
    this.prenom = prenom;
    this.fonction = fonction;
    this.departement = departement;
    this.dateEng = dateEng;
  } // Constructeur
  
  public Employe (int id, String nom, String prenom, Fonction fonction, Date dateEng, Departement departement) {
    this(nom, prenom, fonction, dateEng, departement);
    this.id = id;
  } // Constructeur
  
  // Getteurs //
  public int getId() {return id;} // getId
  public String getNom() {return nom;}
  public String getPrenom() {return prenom;}
  public Fonction getFonction() {return fonction;}
  public Departement getDepartement() {return departement;}
  public Date getDateEngagement() {return dateEng;}
  
  public boolean equals(Object o) {
    return this.id == ((Employe)o).getId();
  } // equals
    
  public int compareTo(Object o) {
    Employe e = (Employe)o;
    int res = nom.compareTo(e.getNom());
    if(res != 0) {
      return res;
    }
    res = prenom.compareTo(e.getPrenom());
    if(res != 0) {
      return res;
    }
    return dateEng.compareTo(e.getDateEngagement());
  } // compareTo
  
  public String toString() {
    return nom.toUpperCase() + " " + prenom;
  } // toString
  
}