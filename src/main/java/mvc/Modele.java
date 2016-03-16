package mvc;

import java.util.ArrayList;
import java.util.Observable;
import donnees.Departement;
import donnees.Employe;
import donnees.Fonction;

/**
 *
 * @author fredericlopesgoncalvesmagalhaes
 */
public class Modele extends Observable {
  
  private ArrayList alstEmployes;
  private ArrayList alstDepartements;
  private ArrayList alstFonctions;
  
  public Modele() {
    super();
    alstEmployes = new ArrayList();
    alstDepartements = new ArrayList();
    alstFonctions = new ArrayList();
  } // Constructeur
    
  public void deleteEmploye(int i) {
    alstEmployes.remove(i);
    setChanged();
    notifyObservers(new Action(Action.DELETE, i));
  } // deleteEmploye
  
  public void addEmploye(Employe o) {
    int i = getIndSort(o, alstEmployes);
    alstEmployes.add(i, o);
    setChanged();
    notifyObservers(new Action(Action.INSERT, i));
  } // addEmploye
  
  public void addDepartement(Departement o) {
    int i = getIndSort(o, alstDepartements);
    alstDepartements.add(i, o);
  } // addDepartement
  
  public void addFonction(Fonction o) {
    int i = getIndSort(o, alstFonctions);
    alstFonctions.add(i, o);
  } // addFonction
  
  public Fonction getFonction(Fonction f) {
    return (Fonction)alstFonctions.get(alstFonctions.indexOf(f));
  } // getFonction
  
  public Fonction getFonction(int i) {
    return (Fonction)alstFonctions.get(i);
  } // getFonction
  
  public Departement getDepartement(Departement d) {
    return (Departement)alstDepartements.get(alstDepartements.indexOf(d));
  } // getDepartement
  
  public Departement getDepartement(int i) {
    return (Departement)alstDepartements.get(i);
  } // getDepartement
    
  public Employe getEmploye(int i) {
    return (Employe)alstEmployes.get(i);
  } // getEmploye
  
  private String[] getArray(ArrayList alst) {
    String[] lst = new String[alst.size()];
    for(int i=0; i<alst.size(); i++) {
      lst[i] = alst.get(i).toString();
    }
    return lst;
  } // getArray
  
  public String[] getArrayDepartements() {
    return getArray(alstDepartements);
  } // getLstDep
  
  public String[] getArrayFonctions() {
    return getArray(alstFonctions);
  } // getLstFonc

  private int getIndSort(Comparable c, ArrayList alst) {
    int pos, n = alst.size();
    if(n <= 0 || c.compareTo(alst.get(0)) < 0) {
      pos = 0;
    } else if (c.compareTo(alst.get(n-1)) >= 0) {
      pos = n;
    } else {
      int g=0, d=n;
      while(g<d-1) {
        int m = (d+g)/2;
        if(c.compareTo(alst.get(m)) >= 0) {
          g = m;
        } else {
          d = m;
        }
      }
      pos = d;
    }
    return pos;
  } // getIndSort
  
}