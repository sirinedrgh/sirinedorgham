
package GoVoyage.DAO;

import GoVoyage.ENTITIES.circuit;
import GoVoyage.IDAO.IcircuitDAO;
import GoVoyage.UTIL.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class circuitDAO implements IcircuitDAO{
    
    private Connection cnx;

    public circuitDAO() {
        cnx=MyConnection.getInstance();
    }
    
    //ajouter circuit
    @Override
    public boolean insertCircuit(circuit cr) {
        
    String query ="INSERT INTO circuit(nomcircuit, villedepart, destination1, destination2, destination3, descriptionvd, description1, description2, description3, latitudevd, longitudevd, latitude1, longitude1, latitude2, longitude2, latitude3, longitude3) "
                 + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    
         try {
            PreparedStatement pSt = cnx.prepareStatement(query);
            pSt.setString(1, cr.getNomcircuit());
            
            pSt.setString(2, cr.getVilledepart());
            pSt.setString(3, cr.getDestination1());
            pSt.setString(4, cr.getDestination2());
            pSt.setString(5, cr.getDestination3());
            
            pSt.setString(6, cr.getDescriptionvd());
            pSt.setString(7, cr.getDescription1());
            pSt.setString(8, cr.getDescription2());   
            pSt.setString(9, cr.getDescription3());
            
            pSt.setDouble(10, cr.getLatitudevd());
            pSt.setDouble(11, cr.getLongitudevd());
            pSt.setDouble(12, cr.getLatitude1());  
            pSt.setDouble(13, cr.getLongitude1());
            pSt.setDouble(14, cr.getLatitude2());
            pSt.setDouble(15, cr.getLongitude2()); 
            pSt.setDouble(16, cr.getLatitude3());
            pSt.setDouble(17, cr.getLongitude3()); 
            
            pSt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println("CIRCUIT non ajouté!");
            return false;
        }   
 
       
    }

    //modifier circuit
    @Override
    public boolean updateCircuit(circuit cr) {
        
    String query = "UPDATE circuit SET nomcircuit=? ,villedepart=? ,destination1=? ,destination2=? ,destination3=? ,descriptionvd=? ,description1=? ,description2=? ,description3=? ,latitudevd=? ,longitudevd=? ,latitude1=? ,longitude1=? ,latitude2=? ,longitude2=? ,latitude3=? ,longitude3=? WHERE id=? ";
        
         try {
            PreparedStatement pSt = cnx.prepareStatement(query);
            pSt.setString(1, cr.getNomcircuit());
            
            pSt.setString(2, cr.getVilledepart());
            pSt.setString(3, cr.getDestination1());
            pSt.setString(4, cr.getDestination2());
            pSt.setString(5, cr.getDestination3());
            
            pSt.setString(6, cr.getDescriptionvd());
            pSt.setString(7, cr.getDescription1());
            pSt.setString(8, cr.getDescription2());   
            pSt.setString(9, cr.getDescription3());
            
            pSt.setDouble(10, cr.getLatitudevd());
            pSt.setDouble(11, cr.getLongitudevd());
            pSt.setDouble(12, cr.getLatitude1());  
            pSt.setDouble(13, cr.getLongitude1());
            pSt.setDouble(14, cr.getLatitude2());
            pSt.setDouble(15, cr.getLongitude2()); 
            pSt.setDouble(16, cr.getLatitude3());
            pSt.setDouble(17, cr.getLongitude3()); 
            pSt.setDouble(18, cr.getId()); 
            
            pSt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println("echec de la modification!!!");
            return false;
        }        
    }

    //suprimer circuit
    @Override
    public void deleteCircuit(int id) {
        String requete = "DELETE FROM circuit WHERE id=? ";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("CIRCUIT supprimée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }        
     
    }
    
    

    //aficher la liste de tt les circuit
    @Override
    public ArrayList<circuit> displayAllcircuits() {
        ArrayList<circuit> listecircuit = new ArrayList<>();

        String requete = "select * from circuit";
        try {
            Statement statement = cnx.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                circuit cr = new circuit();
                cr.setNomcircuit(resultat.getString(1));
                cr.setVilledepart(resultat.getString(2));
                cr.setDestination1(resultat.getString(3));
                cr.setDestination2(resultat.getString(4));
                cr.setDestination3(resultat.getString(5));

                listecircuit.add(cr);
        /*        
       for(circuit elem: listecircuit)
       {
       	 System.out.println (elem);
       }*/
            }
            return listecircuit;
            
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement de la liste des circuit " + ex.getMessage());
            return null;
        }        
    
    }

    @Override
    public circuit findcircuitById(int id) {
        circuit cr = new circuit();
        String requete = "select * from circuit where id=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                cr.setNomcircuit(resultat.getString(1));
                cr.setVilledepart(resultat.getString(2));
            }
            return cr;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du circuit " + ex.getMessage());
            return null;
        }
    }

    @Override
    public circuit findcircuitByvilledep(String nom) {
        circuit cr = new circuit();
        String requete = "select * from circuit where villedepart=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1, nom);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                cr.setNomcircuit(resultat.getString(1));
                cr.setVilledepart(resultat.getString(2));
            }
            return cr;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return null;
        }
    }
    

    
    
}
