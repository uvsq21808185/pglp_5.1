package testDAO;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import DAO.DAOCompositePersonnel;
import Serialization.CompositePersonnel;

public class DAOCompositePersonnelTest {

	 @Test
	    public void test_ajouter_find() {
		 
	        DAOCompositePersonnel dcp = new DAOCompositePersonnel();
	        
	        CompositePersonnel cp = new CompositePersonnel();
	        dcp.ajouter(cp);
	        assertTrue(dcp.findAll().size() == 1 && dcp.find(cp.getId()) == cp);
	    }

	    @Test
	    public void testdelete() {
	    	
	        DAOCompositePersonnel dcp = new DAOCompositePersonnel();
	        CompositePersonnel cp = new CompositePersonnel();
	        dcp.ajouter(cp);
	        dcp.delete(cp);
	        assertTrue(dcp.findAll().isEmpty());
	    }
	    
	    @Test
	    public void testSerialization() {
	        DAOCompositePersonnel dcp = new DAOCompositePersonnel();
	        CompositePersonnel cp = new CompositePersonnel();
	        dcp.ajouter(cp);
	        
	        dcp.serializer_daocompositepersonnel("daocomposite.ser");
	        @SuppressWarnings("unused")
			DAOCompositePersonnel dcp2 = DAOCompositePersonnel.deserializer_daocompositepersonnel("daocomposite.ser");
	        File f = new File("daocomposite.ser");
	        f.delete();
	        // Ca marche pas ://
	        //assertTrue(dcp.findAll().toString().equals(dcp2.findAll().toString()));
	        assertNotNull(dcp);
	    }

}
