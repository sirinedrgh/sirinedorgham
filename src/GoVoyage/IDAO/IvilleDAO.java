/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GoVoyage.IDAO;

import GoVoyage.ENTITIES.ville;
import java.util.ArrayList;

/**
 *
 * @author sirine
 */
public interface IvilleDAO {
    boolean insertVille(ville v);
    void deleteVille(int id);
    boolean updateVille(ville v);
   ArrayList<ville> displayAllvilles();
    ville findvilleById(int id);
    ville findvilleBynom(String nom);



    
}
