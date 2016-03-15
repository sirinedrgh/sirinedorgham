
package GoVoyage.IDAO;

import GoVoyage.ENTITIES.circuit;
import java.util.ArrayList;

public interface IcircuitDAO {
    
    boolean insertCircuit(circuit cr);
    
    boolean updateCircuit(circuit cr);
    
    void deleteCircuit(int id);
    
    ArrayList<circuit> displayAllcircuits();
    
    circuit findcircuitById(int id);
    
    circuit findcircuitByvilledep(String villedepart);
 
}
