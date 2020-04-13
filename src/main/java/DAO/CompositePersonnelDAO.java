package DAO;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Serialization.CompositePersonnel;

@SuppressWarnings("serial")
public class CompositePersonnelDAO extends DAO<CompositePersonnel> implements Serializable{

	    
	    public CompositePersonnelDAO() {
	    }
	    
		public  CompositePersonnel find(int id) {
			CompositePersonnel p = null;
			PreparedStatement prepare = null;
		try {
			try {
				connect= ConnectionMySQL.getInstance();
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 prepare = connect.prepareStatement("SELECT * FROM CompositePersonnel WHERE id=?");
			prepare.setLong(1,id);
			ResultSet result=prepare.executeQuery();
			if (result.first()) {
				p = new CompositePersonnel(result.getInt(id));
				}
				}catch  (SQLException e) {
					e.printStackTrace();
				}
			return p;
			
		}
		
		public  CompositePersonnel create (CompositePersonnel obj) throws ClassNotFoundException {
			PreparedStatement prepare = null;
		try {
			connect= ConnectionMySQL.getInstance();		
			prepare = connect.prepareStatement("INSERT INTO Personnel (id) VALUES (?)");
			prepare.setLong(1,obj.getId());
			int result = prepare.executeUpdate();
			assert result ==1;
			
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		return obj;
		}
		

		public  CompositePersonnel update(CompositePersonnel obj) throws ClassNotFoundException {
			@SuppressWarnings("unused")
			PreparedStatement prepare = null;
		try {
			connect= ConnectionMySQL.getInstance();
			prepare = connect.prepareStatement("UPDATE CompositePersonnel SET id ="+
				obj.getId()+" WHERE tel = null ");
				
				obj = this.find(obj.getId());
		    } catch (SQLException e) {
		            e.printStackTrace();
		    }
		    
		    return obj;
		}

		public  void delete( CompositePersonnel p) {
			}

		@Override
		public CompositePersonnel find(String nom) {
			// TODO Auto-generated method stub
			return null;
		}

	}

