package presentation;

import donnees.Employe;
import java.awt.List;
import java.util.Observable;
import java.util.Observer;
import mvc.Action;
import mvc.Modele;

/**
 *
 * @author fredericlopesgoncalvesmagalhaes
 */
public class ListObserver implements Observer {
  
  // Composants gérés par l'observeur //
  private List lstEmployes;
  
  public ListObserver (List lstEmployes) {this.lstEmployes = lstEmployes;} // Constructeur

  public void update(Observable o, Object arg) {
    Modele m = (Modele)o; Action a = (Action)arg;
    switch(a.getAct()) {
      case Action.INSERT :
        Employe e = m.getEmploye(a.getInd());
        lstEmployes.add(e.toString(), a.getInd());
        lstEmployes.select(a.getInd());
        break;
      case Action.DELETE : 
        lstEmployes.remove(a.getInd());
        break;
      case Action.UPDATE :
        // NON UTILISE ! JE LE LAISSE POUR MONTRER UNE EVENTUELLE AMELIORATION POSSIBLE DU PROGRAMME
        break;
    }
  } // update
  
}
