package Serialization;
import java.io.Serializable;
import java.util.ArrayList;

public final class Personnel  implements Interface_annuaire, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private final int id;
    
    public int getId() {
        return id;
    }

	private final String nom;
	
	private final String prenom;
	
	private final ArrayList<String> tel;
	
	private final java.time.LocalDate Date;
	
	@SuppressWarnings("unchecked")
	public ArrayList<String> getTel() {
        return (ArrayList<String>) tel.clone();
    }
	 
	private Personnel(Personnel_Builder builder)
	{
		this.id = builder.id;
		this.nom=builder.nom;
		this.prenom=builder.prenom;
		this.tel= builder.tel;
		this.Date= builder.date;
		
	
	}
	
	public void tostring() {
		System.out.print(prenom + " " + nom + ", Née le : " + Date + ", numéro de teléphone : ");
		for (String i : tel) {
			System.out.print(i + "  ");
		}
		System.out.println("\n");
	}
	 
	
	public static class Personnel_Builder {
		
        private final int id;
        private static int next = 1;

		private final String nom;
		
		private final String prenom;
		
		private   java.time.LocalDate date;
		
		private   ArrayList<String> tel;
		
		public Personnel_Builder(final String nomP, final String prenomP) {
			this.nom = nomP;
			this.prenom = prenomP;
			this.id = next++;
		
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
	
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}

	
}