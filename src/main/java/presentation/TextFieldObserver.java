/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.awt.TextField;
import java.util.Observable;
import java.util.Observer;
import mvc.Action;
import mvc.Modele;

/**
 *
 * @author fredericlopesgoncalvesmagalhaes
 */
class TextFieldObserver implements Observer {

  private TextField tfDateEngagement, tfDepartement, tfFonction, tfLieu, tfNom, tfPrenom;
  
  public TextFieldObserver(TextField tfDateEngagement, TextField tfDepartement, TextField tfFonction, 
          TextField tfLieu, TextField tfNom, TextField tfPrenom) {
    this.tfDateEngagement = tfDateEngagement;
    this.tfDepartement = tfDepartement;
    this.tfFonction = tfFonction;
    this.tfLieu = tfLieu;
    this.tfNom = tfNom;
    this.tfPrenom = tfPrenom;
  } // Constructeur

  public void update(Observable o, Object arg) {
    Modele m = (Modele)o; Action a = (Action)arg;
    switch(a.getAct()) {
      case Action.INSERT :
        
        break;
      case Action.DELETE : 
        
        break;
      case Action.UPDATE :
        
        break;
    }
  }
  
}
