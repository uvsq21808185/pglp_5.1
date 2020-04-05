import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public final class Personnel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final String nom;
	
	private final String prenom;
	
	private final ArrayList<String> tel;
	
	private final java.time.LocalDate Date;
	
	 
	private Personnel(Personnel_Builder builder)
	{
		this.nom=builder.nom;
		this.prenom=builder.prenom;
		this.tel= builder.tel;
		this.Date= builder.date;
		
	
	}
	
	public void tostring() {
		
		System.out.println("****************");
		System.out.print(prenom + " " + nom + ", Née le : " + Date + ", numéro de teléphone : ");
		for (String i : tel) {
			System.out.print(i + "  ");
		}
		System.out.println("\n");
		System.out.println("****************");
	}
	 
	
	public static class Personnel_Builder {
		
		private final String nom;
		
		private final String prenom;
		
		private  java.time.LocalDate date;
		
		private  ArrayList<String> tel;
		
		public Personnel_Builder(final String nomP, final String prenomP) {
			this.nom = nomP;
			this.prenom = prenomP;
		
		}
		
		public Personnel_Builder tel (ArrayList<String> tel) {
			this.tel=tel;
			return this;
		}
		
		public Personnel_Builder date (java.time.LocalDate date) {
			this.date=date;
			return this;
		}
		
		public Personnel build() {
			return new Personnel(this);
		}
	}
	
	}