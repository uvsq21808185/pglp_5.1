package DAO;
import Serialization.Personnel;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException {
		
		DAO<Personnel> personnelDAO = DAOFactory.getPersonnelDAO();
		 
		personnelDAO.create(new Personnel.Personnel_Builder("ZAOUAM","Siragedine").build());
		
		@SuppressWarnings("unused")
		Personnel p = personnelDAO.find("ALI");
		System.out.println("OK");		
		// TODO Auto-generated method stub

	}

}
