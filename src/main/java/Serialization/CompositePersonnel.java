package Serialization;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 */

/** Classe CompositePersonnel qui herite de la classe Abstraire Interface_annuaire
 * @author Win10
 *
 */
public class CompositePersonnel implements Interface_annuaire, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7949412292635467767L;
	//private String nomAnnuaire;
    private  int id;
    
    private ArrayList<Interface_annuaire> listPersonnels = new ArrayList<Interface_annuaire>();

    public void tostring() 
    {
        System.out.println("ID : "+id);
        for (Interface_annuaire ip : listPersonnels) {
			ip.tostring();
    }
    }
   
    /* 
     * Constructeur qui prend une chaine de caracteres en entree 
     */
    public CompositePersonnel(int id)
    {
    	 this.id = id;
    	 listPersonnels = new ArrayList<Interface_annuaire>();
    }
   
    /* 
     * Methode pour ajouter des personnels dans la liste 
     */
    public void addPersonnel(Interface_annuaire personnel)
    {
        listPersonnels.add(personnel);
    }
    /* 
     * Methode pour supprimer des personnels de la liste 
     */

    public void removePersonnel(Interface_annuaire personnel)
    {
        listPersonnels.remove(personnel);
    }
    /* 
     * Cette methode renvoie un iterateur sur ListPersonnels
     */
    public Iterator<Interface_annuaire> iterator() {
		return listPersonnels.iterator();
	}
  
    public final int getId() {
        return id;
    }
    public void setId(int id) {
    	this.id=id;
    }


}
