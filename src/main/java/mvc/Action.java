/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

/**
 *
 * @author fredericlopesgoncalvesmagalhaes
 */
public class Action {
  
  public static final int INSERT = 0, DELETE = 1, UPDATE = 2; // UPDATE NON UTILISE !
  
  private int act;
  private int ind;
  
  public Action(int act, int ind) {
    this.act = act;
    this.ind = ind;
  } // Constructeur
  
  public int getAct() {return act;} // getAct
  public int getInd() {return ind;} // getPos
  
}
