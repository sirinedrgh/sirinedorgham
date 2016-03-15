/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GoVoyage.DAO;


import GoVoyage.ENTITIES.ville;
import GoVoyage.IDAO.IvilleDAO;
import GoVoyage.UTIL.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author sirine
 */
public class villeDAO implements IvilleDAO {
     private Connection cnx;

    public villeDAO() {
       cnx=MyConnection.getInstance();
    }
     
      

    @Override
    public boolean insertVille(ville v) {
    String query ="INSERT INTO ville (nom, pays,latitude, longitude, description, type, langue) "
                 + "VALUES (?,?,?,?,?,?,?)"; 
    
         try {
            PreparedStatement pSt = cnx.prepareStatement(query);
            pSt.setString(1,v.getNom());
            
            pSt.setString(2,v.getPays());
            pSt.setDouble(3,v.getLatitude());
            pSt.setDouble(4,v.getLongitude());
            pSt.setString(5,v.getDescription());
            pSt.setString(6,v.getType());
            pSt.setString(7,v.getLangue());

            
            pSt.executeUpdate();
            System.out.println("ville ajouté----");
            return true;
            
        } catch (SQLException ex) {
            System.out.println("ville non ajouté!");
            return false;
        }   
     
    }

    @Override
    public void deleteVille(int id) {
        String requete = "DELETE FROM ville WHERE id=? ";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("ville supprimée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }  
    }

    @Override
    public boolean updateVille(ville v) {

    String query = "UPDATE ville SET nom=? ,pays=? ,latitude=? ,longitude=? ,description=? ,type=? ,langue=?  WHERE id=? ";
        
         try {
            PreparedStatement pSt = cnx.prepareStatement(query);
            pSt.setString(1,v.getNom());
            
            pSt.setString(2,v.getPays());
            pSt.setDouble(3,v.getLatitude());
            pSt.setDouble(4,v.getLongitude());
            pSt.setString(5,v.getDescription());
            pSt.setString(6,v.getType());
            pSt.setString(7,v.getLangue());
            pSt.setDouble(8,v.getId()); 
            
            pSt.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println("echec de la modification!!!");
            return false;
        }        
    }

    @Override
    public ArrayList<ville> displayAllvilles() {
        ArrayList<ville> listeville = new ArrayList<>();

        String requete = "select * from ville";
        try {
            Statement statement = cnx.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                ville v = new ville();
              
            
                v.setId(resultat.getInt(1));
                v.setNom(resultat.getString(2));
                v.setPays(resultat.getString(3));
                v.setLatitude(resultat.getInt(4));
                
                v.setLongitude(resultat.getInt(5));
                v.setDescription(resultat.getString(6));
                v.setType(resultat.getString(7));
                v.setLangue(resultat.getString(8));
               

                listeville.add(v);
        /*        
       for(circuit elem: listecircuit)
       {
       	 System.out.println (elem);
       }*/
            }
            return listeville;
            
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement de la liste  " + ex.getMessage());
            return null;
        }  
    
    
    }

    @Override
    public ville findvilleById(int idd) {

    ville v = new ville();
        String requete = "select * from ville where id=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setInt(1, idd);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
            
                v.setId(resultat.getInt(1));
                v.setNom(resultat.getString(2));
                v.setPays(resultat.getString(3));
                v.setLatitude(resultat.getInt(4));
                
                v.setLongitude(resultat.getInt(5));
                v.setDescription(resultat.getString(6));
                v.setType(resultat.getString(7));
                v.setLangue(resultat.getString(8));
            }
            return v;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du ville " + ex.getMessage());
            return null;
        }
    
    
    }

    @Override
    public ville findvilleBynom(String n) {
        
            ville v = new ville();
        String requete = "select * from ville where nom=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1, n);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                v.setId(resultat.getInt(1));
                v.setNom(resultat.getString(2));
                v.setPays(resultat.getString(3));
                v.setLatitude(resultat.getInt(4));
                
                v.setLongitude(resultat.getInt(5));
                v.setDescription(resultat.getString(6));
                v.setType(resultat.getString(7));
                v.setLangue(resultat.getString(8));
            }
            return v;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche " + ex.getMessage());
            return null;
        }
    }

    }
    
 

    

