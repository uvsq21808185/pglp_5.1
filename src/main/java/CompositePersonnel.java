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
	
	private String nomAnnuaire;
    private ArrayList<Interface_annuaire> listPersonnels = new ArrayList<Interface_annuaire>();

    public void tostring() 
    {
        System.out.println("Annuaire de "+nomAnnuaire);
        for (Interface_annuaire ip : listPersonnels) {
			ip.tostring();
    }
    }
   
    /* 
     * Constructeur qui prend une chaine de caracteres en entree 
     */
    public CompositePersonnel(String nom)
    {
        this.nomAnnuaire = nom;
    }
    /* 
     * Constructeur par default 
     */
    public CompositePersonnel(){
    	
    }
   
    /* 
     * M�thode pour ajouter des personnels dans la liste 
     */
    public void addPersonnel(Interface_annuaire personnel)
    {
        listPersonnels.add(personnel);
    }
    /* 
     * M�thode pourcsupprimer des personnels de la liste 
     */

    public void removePersonnel(Personnel personnel)
    {
        listPersonnels.remove(personnel);
    }
    /* 
     * Cette m�thode renvoie un it�rateur sur ListPersonnels
     */
    public Iterator<Interface_annuaire> iterator() {
		return listPersonnels.iterator();
	}
    /* 
     * Cette m�thode renvoie le nom de l'annuaire
     */
    public final String getNomAnnuaire() {
    	return nomAnnuaire;
    
    }


}
