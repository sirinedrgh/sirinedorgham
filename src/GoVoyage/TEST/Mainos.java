
package GoVoyage.TEST;

import GoVoyage.DAO.circuitDAO;
import GoVoyage.ENTITIES.circuit;
import GoVoyage.IDAO.IcircuitDAO;

public class Mainos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        //ajout d'un circuit
       circuit cr =new circuit(5,"Europaa","francedo","london","suede","autriche","top","top1","top2","top3",8,7,5,6,6,9,5,7);
       IcircuitDAO icr = new circuitDAO() ;
       //icr.insertCircuit(cr);
       //icr.updateCircuit(cr);
       //icr.deleteCircuit(5);
       //System.out.println(cr.toString());
       //affichage tt:
       //icr.displayAllcircuits();
       //icr.findcircuitById(6);
       //System.out.println(icr.findcircuitById(6));
       //icr.findcircuitByvilledep("ALL");
        System.out.println(icr.findcircuitByvilledep("france"));

       
       
    }
    
}
