package Serialization;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class SerializerPersonnel {

	public static void main(String[] args) {
		  final Personnel personnel = new Personnel.
				  Personnel_Builder("ZAOUAM","Siragedine").date(LocalDate.now()).build();
		  
		    ObjectOutputStream obj = null;
		    try {
		      final FileOutputStream fichier = new FileOutputStream("Personnels.txt");
		      obj = new ObjectOutputStream(fichier);
		      obj.writeChars("Descriptif personnel :");
		      obj.writeObject(personnel);		     
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
