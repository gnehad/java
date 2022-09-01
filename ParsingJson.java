import org.json.simple.JSONArray;
import org.json.simple.JSONObject;                                      //Package la libraire JSON simple
import java.util.*;

class ParsingJson {

   public static void main(String[] args) {
      /*
       * [
       *    {"1" : [
       *             {"code":", "420-925-RO", "nom":"Systèmes d'exploitation 1"},
       *             {"code":", "201-043-RO", "nom":"Mathématiques pour Informatique"},
       *             {"code":", "201-906-RO", "nom":"Algorithmique et programmation structurée"}
       *           ]
       *    }, 
       *    {"2" : [
       *           ]
       *    }
       * ]
       * 
       */
      JSONArray coursesList = new JSONArray();
      JSONObject session = new JSONObject();

      JSONObject courseDetails= new JSONObject();
      courseDetails.put("code", "420-925-RO");
      courseDetails.put("nom", "Systèmes d'exploitation 1");
      coursesList.add(courseDetails);
      courseDetails.put("code", "201-043-RO");
      courseDetails.put("nom", "Mathématiques pour Informatique");
      coursesList.add(courseDetails);
      courseDetails.put("code", "201-906-RO");
      courseDetails.put("nom", "Algorithmes et programmation structurée");
      coursesList.add(courseDetails);
      session.put("1", coursesList);


      System.out.println("Cours de la session 1 : ");
      /*session.get(1) représente la valeur associée à la clé 1 de l'objet. autrement dit, 
      * c'est l'ensemble des cours de la session 1. s
      */

      ArrayList<JSONObject> listeCours = (ArrayList)(session.get("1"));
      for(int i = 0; i < listeCours.size(); i++){
         System.out.println(listeCours.get(i));
      }
   }
}