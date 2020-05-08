package Serialization;
import java.time.LocalDate;
/*
 * 
 * @author ZAOUAM Sirageddine
 * @version 2.0
 */
public class SerializerPersonnel {

	public static void main(String[] args) {
		  final Personnel personnel = new Personnel.
				  Personnel_Builder("ZAOUAM","Siragedine").date(LocalDate.now()).build();
		  
		 /*
		  * Tester la serialisation de l'objet personnel qu'on vient de creer.
		  */
		personnel.serializer_personnel("PersonnelV2.txt");
	}

}
