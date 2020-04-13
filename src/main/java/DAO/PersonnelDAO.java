package DAO;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import Serialization.Personnel;

public class PersonnelDAO extends DAO<Personnel> implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2683232389838185347L;
    
    public PersonnelDAO() {
    }
    
	public  Personnel find(String nom) {
		
		Personnel p = new Personnel.
		Personnel_Builder("ZAOUAM","Siragedine").date(LocalDate.now()).build();
		PreparedStatement prepare = null;
	try {
		try {
			connect= ConnectionMySQL.getInstance();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 prepare = connect.prepareStatement("SELECT * FROM Personnel WHERE nom=?");
		prepare.setString(1,nom);
		ResultSet result=prepare.executeQuery();
		if (result.first()) {
			p = new Personnel.Personnel_Builder(result.getString("nom"),result.getString("prenom")).build();	
		}
			}catch  (SQLException e) {
				e.printStackTrace();
			}
		return p;
		
	}
	
	public  Personnel create (Personnel obj) throws ClassNotFoundException {
		PreparedStatement prepare = null;
	try {
		connect= ConnectionMySQL.getInstance();		
		prepare = connect.prepareStatement("INSERT INTO Personnel (nom,prenom) VALUES (?,?)");
		prepare.setString(1,obj.getNom());
		prepare.setString(2,obj.getPrenom());
		int result = prepare.executeUpdate();
		assert result ==1;
		
	}
		catch (SQLException e) {
			e.printStackTrace();
		}
	return obj;
	}
	

	public  Personnel update(Personnel obj) throws ClassNotFoundException {
		@SuppressWarnings("unused")
		PreparedStatement prepare = null;
	try {
		connect= ConnectionMySQL.getInstance();
		prepare = connect.prepareStatement("UPDATE Personnel SET nom ="+
			obj.getNom()+" WHERE tel = "+obj.getTel());
			
			obj = this.find(obj.getNom());
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	    
	    return obj;
	}

	public  void delete(Personnel obj) {

		}

	}
