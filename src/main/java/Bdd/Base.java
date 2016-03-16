package Bdd;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author fredericlopesgoncalvesmagalhaes
 */
public class Base {
  public final static int MYSQL = 0, ORACLEBDD = 1, ACCESS = 2;
  private final static String 
          DRIVER_MYSQL="com.mysql.jdbc.Driver",
          DRIVER_ORACLE="oracle.jdbc.OracleDriver", 
          DRIVER_ACCESS="sun.jdbc.odbc.JdbcOdbcDriver";
  private final static String 
          URL_MYSQL="jdbc:mysql://localhost:8889/EmplDept",
          URL_ORACLE="jdbc:oracle:thin:@localhost:8889:EmplDept",
          URL_ACCESS="jdbc:odbc:EmplDept";
  
  private static Connection con;
  private static Statement stmt;
  private static PreparedStatement prepStmt;
  
  private static void getConnection(int bdd) {
    Properties prop = new Properties();
    prop.put("user", "root"); prop.put("password", "root");
    try {
    switch(bdd) {
      case MYSQL :
        Class.forName(DRIVER_MYSQL); // chargement en mémoire du Driver de la BDD MySQL
        prop.put("charSet", "UTF-8");
        // Création d'une instance de Class réalisant l'interface Connection.
        // Cette instance nous est inconnue, elle est fournie par le 
        // constructeur de la BDD (Oracle, MySQL, etc...).      
        con = DriverManager.getConnection(URL_MYSQL, prop);
        break;
      case ORACLEBDD :
        Class.forName(DRIVER_ORACLE); // chargement en mémoire du Driver de la BDD Oracle
        con = DriverManager.getConnection(URL_ORACLE, prop);
        break;
      case ACCESS :
        Class.forName(DRIVER_ACCESS); // chargement en mémoire du Driver de la BDD Access
        prop.put("charSet", "ISO-8859-1");
        con = DriverManager.getConnection(URL_ACCESS, prop);
        break;
    }
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  } // getConnection
  
  public static Statement createStatement() {
    // Création d'une instance de Statement permettant d'exécuter les instructions SQL
    // Idem que pour la Connection, nous ne connaissons pas le code se trouvant en amont car
    // nous exploitons une interface.
    getConnection(MYSQL);
    try {
      stmt = con.createStatement(); 
      return stmt;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  } // createStatement
  
  // CONSTANTES POUR LA CREATION D'INSTANCE DE PreparedStatement
  private static final String QUERY_GET_EMPLOYES = 
          "SELECT * FROM Employe";
  private static final String QUERY_GET_DEP = 
          "SELECT NoDept, NomDept, NomLieu FROM Departement JOIN Lieu ON Lieu.NoLieu = Departement.NoLieu";
  private static final String QUERY_GET_FONC =
          "SELECT * FROM Fonction";
  private static final String QUERY_INSERT_EMPL = 
          "INSERT INTO Employe (NomEmpl,PrenomEmpl,NoFonc,DateEmpl,NoDept) VALUES (?,?,?,?,?)";
  private static final String QUERY_DELETE_EMPL = 
          "DELETE FROM Employe WHERE NoEmpl = ?";
  // FIN DES CONSTANTES //
  
  public static ResultSet getAllEmployes() {
    getConnection(MYSQL);
    try {
      prepStmt = con.prepareStatement(QUERY_GET_EMPLOYES); 
      return prepStmt.executeQuery();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  } // getAllEmploye
  
  public static ResultSet getAllDepartements() {
    getConnection(MYSQL);
    try {
      prepStmt = con.prepareStatement(QUERY_GET_DEP); 
      return prepStmt.executeQuery();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  } // getAllDepartements
  
  public static ResultSet getAllFonctions() {
    getConnection(MYSQL);
    try {
      prepStmt = con.prepareStatement(QUERY_GET_FONC); 
      return prepStmt.executeQuery();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  } // getAllFonctions
  
  public static PreparedStatement insertBddEmploye() {
    getConnection(MYSQL);
    try {
      prepStmt = con.prepareStatement(QUERY_INSERT_EMPL); 
      return prepStmt;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  } // insertBddEmploye
  
  public static PreparedStatement deleteBddEmploye() {
    getConnection(MYSQL);
    try {
      prepStmt = con.prepareStatement(QUERY_DELETE_EMPL); 
      return prepStmt;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  } // deleteBddEmploye
  
  public static void closeBdd() {
    try {
      con.close();
      prepStmt.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  } // closeBdd
  
} // Base