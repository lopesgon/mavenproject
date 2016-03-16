package presentation;

import Bdd.Base;
import donnees.Fonction;
import donnees.Departement;
import donnees.Employe;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.PreparedStatement;
import mvc.Modele;

/**
 * 634.1 Programmation - TP P01
 * 
 * Fenêtre principale:
 * - visualisation des employés;
 * - supression de l'employé courant;
 * - ouverture de la fenêtre de saisie d'un nouvel employé.
 *
 * @author lopesmagalhaesfrederic
 * @version 1.0
 */
public class FrmMain extends java.awt.Frame {
  
  private Modele modele;
  
  /** Constructeur */
  public FrmMain () {
    initComponents();
    modele = new Modele();
    modele.addObserver(new ListObserver(lstEmployes));
    initDonnees();
  } // Constructeur

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
   * content of this method is always regenerated by the Form Editor.
   */
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    lstEmployes = new java.awt.List();
    java.awt.Label label1 = new java.awt.Label();
    tfNom = new java.awt.TextField();
    java.awt.Label label2 = new java.awt.Label();
    tfPrenom = new java.awt.TextField();
    java.awt.Label label3 = new java.awt.Label();
    tfDateEngagement = new java.awt.TextField();
    java.awt.Label label4 = new java.awt.Label();
    tfFonction = new java.awt.TextField();
    java.awt.Label label5 = new java.awt.Label();
    tfDepartement = new java.awt.TextField();
    java.awt.Label label6 = new java.awt.Label();
    tfLieu = new java.awt.TextField();
    btnSupprimer = new java.awt.Button();
    btnNouveau = new java.awt.Button();

    setResizable(false);
    setTitle("Consultation des employés");
    addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowClosing(java.awt.event.WindowEvent evt) {
        formWindowClosing(evt);
      }
    });

    lstEmployes.addItemListener(new java.awt.event.ItemListener() {
      public void itemStateChanged(java.awt.event.ItemEvent evt) {
        lstEmployesItemStateChanged(evt);
      }
    });

    label1.setText("Nom");

    tfNom.setEnabled(false);

    label2.setText("Prénom");

    tfPrenom.setEnabled(false);

    label3.setText("Date d'engagement");

    tfDateEngagement.setEnabled(false);

    label4.setText("Fonction");

    tfFonction.setEnabled(false);

    label5.setText("Département");

    tfDepartement.setEnabled(false);

    label6.setText("Lieu");

    tfLieu.setEnabled(false);

    btnSupprimer.setEnabled(false);
    btnSupprimer.setLabel("Supprimer");
    btnSupprimer.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnSupprimerActionPerformed(evt);
      }
    });

    btnNouveau.setLabel("Nouveau ...");
    btnNouveau.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnNouveauActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(lstEmployes, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(30, 30, 30)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(tfPrenom, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                  .addComponent(tfNom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(tfDateEngagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(tfFonction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(tfDepartement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(tfLieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
              .addGroup(layout.createSequentialGroup()
                .addComponent(btnSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(btnNouveau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(tfNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(tfPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(tfDateEngagement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(25, 25, 25)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(tfFonction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(28, 28, 28)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(tfDepartement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(tfLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(15, 15, 15)
            .addComponent(btnSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(lstEmployes, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(btnNouveau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  /* Fermeture de l'application */
  private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    System.exit(0);
  }//GEN-LAST:event_formWindowClosing

  private void lstEmployesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_lstEmployesItemStateChanged
    int i = lstEmployes.getSelectedIndex();
    if (i!=-1) { 
      Employe e = modele.getEmploye(i);
      tfDateEngagement.setText(e.getDateEngagement().toString());
      tfDepartement.setText(e.getDepartement().toString());
      tfFonction.setText(e.getFonction().toString());
      tfLieu.setText(e.getDepartement().getLieu());
      tfNom.setText(e.getNom());
      tfPrenom.setText(e.getPrenom());
      btnSupprimer.setEnabled(true);
    } else {
      btnSupprimer.setEnabled(false);
    }
  }//GEN-LAST:event_lstEmployesItemStateChanged

  private void btnNouveauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNouveauActionPerformed
    FrmNouveau.getInstance(this).setVisible(true);
  }//GEN-LAST:event_btnNouveauActionPerformed

  private void clearTextFields() {
    tfDateEngagement.setText("");
    tfDepartement.setText("");
    tfFonction.setText("");
    tfLieu.setText("");
    tfNom.setText("");
    tfPrenom.setText("");
  } // clearTextFields
  
  private void btnSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupprimerActionPerformed
    int i = lstEmployes.getSelectedIndex();
    lstEmployes.deselect(i);
    prepStmt = Base.deleteBddEmploye();
    try {
      prepStmt.setInt(1, modele.getEmploye(i).getId());
      prepStmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    closeBdd();
    modele.deleteEmploye(i);
    clearTextFields();
  }//GEN-LAST:event_btnSupprimerActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private java.awt.Button btnNouveau;
  private java.awt.Button btnSupprimer;
  private java.awt.List lstEmployes;
  private java.awt.TextField tfDateEngagement;
  private java.awt.TextField tfDepartement;
  private java.awt.TextField tfFonction;
  private java.awt.TextField tfLieu;
  private java.awt.TextField tfNom;
  private java.awt.TextField tfPrenom;
  // End of variables declaration//GEN-END:variables

  // ATTRIBUT POUR L'EXECUTION DES REQUETES //
  private PreparedStatement prepStmt = null;
  
  private void closeBdd() {
    Base.closeBdd();
  } // closeConnection
  
  private void initDep() {
    try {
      ResultSet rset = Base.getAllDepartements();
      while(rset.next()) {
        int id = rset.getInt("NoDept");
        String dept = rset.getString("NomDept");
        String lieu = rset.getString("NomLieu");
        modele.addDepartement(new Departement(id, dept, lieu));
      }
    } catch(SQLException e) {
      e.printStackTrace();
    }
  } // initDep
  
  private void initFonc() {
    try {
      ResultSet rset = Base.getAllFonctions();
      while(rset.next()) {
        int id = rset.getInt("NoFonc");
        String dept = rset.getString("NomFonc");
        modele.addFonction(new Fonction(id, dept));
      }
    } catch(SQLException e) {
      e.printStackTrace();
    }
  } // initFonc
  
  private void initEmpl() {
    try {
      ResultSet rset = Base.getAllEmployes();
      while (rset.next()) {
        int id = rset.getInt("NoEmpl");
        String nom = rset.getString("NomEmpl");
        String prenom = rset.getString("PrenomEmpl");
        int noFonc = rset.getInt("NoFonc");
        Fonction f = modele.getFonction(new Fonction(noFonc));
        int noDep = rset.getInt("NoDept");
        Departement d = modele.getDepartement(new Departement(noDep));
        Date dateEng = rset.getDate("DateEmpl");
        modele.addEmploye(new Employe(id, nom, prenom, f, dateEng, d));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  } // initEmpl
  
  private void initDonnees() {
    initDep();
    initFonc();
    initEmpl();
    closeBdd();
  } // initDonnees
  
  public String[] getArrayDepartements() {
    return modele.getArrayDepartements();
  } // getLstDep
  
  public String[] getArrayFonctions() {
    return modele.getArrayFonctions();
  } // getLstFonc
  
  public void addEmploye(String nom, String prenom, int indFonc, Date dateEng, int indDep) {
    prepStmt = Base.insertBddEmploye();
    Departement dept = modele.getDepartement(indDep);
    Fonction fonc = modele.getFonction(indFonc);
    try {
      prepStmt.setString(1, nom.toUpperCase());
      prepStmt.setString(2, prenom);
      prepStmt.setInt(3, fonc.getId());
      prepStmt.setDate(4, dateEng);
      prepStmt.setInt(5, dept.getId());
      prepStmt.executeUpdate();
      closeBdd();
      Employe emp = new Employe(nom, prenom, fonc, dateEng, dept);
      modele.addEmploye(emp);
    } catch (SQLException e) {
      e.printStackTrace();
      System.out.println("ERREUR DANS L'INSERTION D'UN NOUVEL EMPLOYE DANS LA BASE DE DONNEES!");
    }
  } // addEmploye
  
} // FrmMain
