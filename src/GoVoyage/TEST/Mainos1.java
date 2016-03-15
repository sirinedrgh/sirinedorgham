
package GoVoyage.TEST;

import GoVoyage.DAO.villeDAO;
import GoVoyage.ENTITIES.ville;
import GoVoyage.IDAO.IvilleDAO;


public class Mainos1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        
       ville v =new ville(788,"Eurpppaa","fraaaaance",7,8,"autriche","top","top1");

       IvilleDAO iv= new villeDAO();
       //iv.insertVille(v);
      //iv.updateVille(v); 
       iv.deleteVille(7);
     // iv.displayAllvilles();
       //iv.findvilleById(5);
      //System.out.println(iv.displayAllvilles());
        //System.out.println(iv.findvilleById(5));
        //System.out.println(iv.findvilleBynom("Europaa"));

          
       
    }
    
}
