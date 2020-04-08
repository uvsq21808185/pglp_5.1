import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class SerialiserCompositePersonnel {

	public static void main(String[] args) {
		CompositePersonnel c1 = new CompositePersonnel();
    	ArrayList<String> numero = new ArrayList<String>();
    	numero.add("06.23.43.55.40");
    	numero.add("07.54.43.22.10");
    	numero.add("01.50.00.22.99");
    	
    	
        Personnel p = new Personnel.Personnel_Builder("Stevan", "Elie")
        .tel(numero).date(LocalDate.of(2000, 05, 04)).build();        
        c1.addPersonnel(p);

        ObjectOutputStream obj = null;
	    try {
	      final FileOutputStream fichier = new FileOutputStream("CompositePersonnel.txt");
	      obj = new ObjectOutputStream(fichier);
	      obj.writeChars("Descriptif Composite :");
	      obj.writeObject(c1);		     
	      obj.flush();
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

}
