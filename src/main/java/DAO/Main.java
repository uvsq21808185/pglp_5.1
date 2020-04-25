package DAO;

import java.time.LocalDate;
import java.util.ArrayList;

import Serialization.Personnel;

public class main {

	public static void main(String[] args) {
		
		// Creation d'un dao personnel en utilisant la fabrique
		DAO<Personnel> dao = DAOFactory.getDAOPersonnel(null);
		// Creation d'un objet Personnel
		 ArrayList<String> num = new ArrayList<String>();
	        
	        num.add("07.54.30.20.22");
	        num.add("06.54.00.04.23");
	        Personnel p = new Personnel.Personnel_Builder("ZAOUAM", "Sirageddine")
	        		.date(LocalDate.of(2000, 06, 04)).tel(num).build();
	        
	        ArrayList<String> num2 = new ArrayList<String>();
	        
	        num.add("01.00.56.34.21");
	        num.add("09.09.54.34.10");
	        Personnel p2 = new Personnel.Personnel_Builder("MESSAOUDI", "Amin")
	        		.date(LocalDate.of(2002, 07, 05)).tel(num2).build();
	        // serialisation de l'objet Personnel_1
	        p.serializer_personnel("Personnel_1.ser");
	        // serialisation de l'objet Personnel_2
	        p2.serializer_personnel("Personnel_2.ser");
	        
	        // Ajout de l'objet Personnel1 et Personnel2 dans le dao
	        dao.ajouter(p);
	        dao.ajouter(p2);
	        
	        // Creation d'un dao personnel
	        DAOPersonnel dao_p = new DAOPersonnel();
	        // Ajout de deux objets personnels dans le dao 
	        dao_p.ajouter(p);
	        dao_p.ajouter(p2);
	        // Tester la serialisation du dao
	        dao_p.serializer_daopersonnel("DaoPersonnel.ser");
	        System.out.println("DONE !");
	}

}
