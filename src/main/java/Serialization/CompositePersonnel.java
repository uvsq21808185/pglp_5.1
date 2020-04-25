package Serialization;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/** Classe CompositePersonnel qui herite de la classe Abstraire Interface_annuaire
 * @author Win10
 *
 */
public class CompositePersonnel implements Interface_annuaire, Serializable {
	/*
	 * Le numero de serie poue la serialisation.
	 */
	private static final long serialVersionUID = -7949412292635467767L;
	/*
	 * Identifiant d'un composite.
	 */
    private  int id;
    /*
     * La liste des personnels.
     */
    private ArrayList<Interface_annuaire> listPersonnels;
    /*
     * une valeur pour incrementer a chaque fois l'id du nouveau composite.
     */
	private static int next = 1;
    /*
     * La methode qui implemente l'interface Interface_annuaire.
     */
    public void tostring() 
    {
        System.out.println("ID : "+id);
        for (Interface_annuaire ip : listPersonnels) {
			ip.tostring();}   
    }
    /*
	 * String representant l'objet Personnel : on aura besoin de cette methode pour le test
	 * tester si le String de l'objet Personnel est le meme que le string de l'objet deseralizer
	 */
	public String tostring_test() {
		String s ="ID : " + id;
		for (Interface_annuaire ip : listPersonnels) {
			s+= ip.tostring_test() + "  ";
		}
		return s + "\n" ;
	}
    /* 
     * Constructeur qui prend l'identifiant du composite en entree.
     */
    public CompositePersonnel(int id)
    {
    	 this.id = id;
    	 listPersonnels = new ArrayList<Interface_annuaire>();
    }
    /*
     * Constructeur par defaut de CompositePersonnels.
     */
    public CompositePersonnel() {
        id = next++;
        listPersonnels = new ArrayList<Interface_annuaire>();
    }
    /* 
     * Methode pour ajouter des personnels dans la liste 
     */
    public CompositePersonnel addPersonnel(Interface_annuaire personnel)
    {
        listPersonnels.add(personnel);
        return this;
    }
    /* 
     * Methode pour supprimer des personnels de la liste 
     */

    public CompositePersonnel removePersonnel(Interface_annuaire personnel)
    {
        listPersonnels.remove(personnel);
        return this;
    }
    /* 
     * Cette methode renvoie un iterateur sur ListPersonnels
     */
    public Iterator<Interface_annuaire> iterator() {
		return listPersonnels.iterator();
	}
    /*
     * Retourne l'identifiant de personnel.
     */
    public final int getId() {
        return id;
    }
    /*
	 * Serialiser l'objet CompositePersonnel vers le chemin path
	 * @param path le chemin vers lequel on veut serializer
	 */
	public void serializer_composite(final String path) {

	    ObjectOutputStream obj = null;
	    try {
	      final FileOutputStream fichier = new FileOutputStream(path);
	      obj = new ObjectOutputStream(fichier);
	      obj.writeChars("Descriptif CompositePersonnel :");
	      obj.writeObject(this);		     
	      obj.flush();
          obj.close();
	    } catch (final java.io.IOException e) {
	      e.printStackTrace();
	    }
	    finally {
	      try {
	        if (obj != null) {
	          obj.flush();
	          obj.close();
	        }
	      } catch (final IOException ex) {
	        ex.printStackTrace();
	      }
	    }
	    System.out.print("DONE !");
	}
	/*
	 * Deserializer vers le chemin voulu "path"
	 * @param path le chemin depuis lequel on veut deserializer l'objet CompositePersonnel.
	 */
    public static CompositePersonnel deserializer_composite(final String path) {
        ObjectInputStream obj = null;
        CompositePersonnel p = null;
        try {
            FileInputStream fichier = new FileInputStream(path);
            obj = new ObjectInputStream(fichier);
            p = (CompositePersonnel) obj.readObject();
        } catch (IOException e) {
            System.err.println("La deserialization a échoué");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            if (obj != null) {
                obj.close();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return p;
    }
    /**
     * vider la liste des personnels.
     */
    public void reset() {
        listPersonnels.clear();
    }
}
