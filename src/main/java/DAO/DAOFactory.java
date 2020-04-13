package DAO;
import Serialization.Personnel;

/*
 * Une Fabrique pour les DAOs
 */

public class DAOFactory{
	
	private DAOFactory() {
	}

	/* Retourne un objet Personnel interagissant avec la BDD
	 * @return DAO
	 */
	public static DAO<Personnel> getPersonnelDAO(){
		return new PersonnelDAO();
		}
	
	/* Retourne un objet CompositePersonnel interagissant avec la BDD
	 * @return DAO
	 */
	/**
	 public static DAO<CompositePersonnel> getCompositePersonnelDAO() {
	      
	            return new CompositePersonnelDAO();
	      
	    }
	    */
	
}