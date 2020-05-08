package Serialization;
import java.time.LocalDate;
import java.util.ArrayList;
/*
 * 
 * @author ZAOUAM Sirageddine
 * @version 2.0
 */
public class SerialiserCompositePersonnel {

	public static void main(String[] args) {
		CompositePersonnel c1 = new CompositePersonnel(1);
    	ArrayList<String> numero = new ArrayList<String>();
    	numero.add("06.23.43.55.40");
    	numero.add("07.54.43.22.10");
    	numero.add("01.50.00.22.99");
    	
    	
        Personnel p = new Personnel.Personnel_Builder("Stevan", "Elie")
        .tel(numero).date(LocalDate.of(2000, 05, 04)).build();        
        c1.addPersonnel(p);
       
        /*
         * Tester la serialisation de composite qu'on vient de creer
         */
        c1.serializer_composite("CompositePersonnelV2.txt");
        }
}
