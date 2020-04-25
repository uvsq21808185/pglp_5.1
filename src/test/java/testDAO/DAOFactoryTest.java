package testDAO;

import static org.junit.Assert.*;

import org.junit.Test;

import DAO.DAO;
import DAO.DAOFactory;
import Serialization.CompositePersonnel;
import Serialization.Personnel;


public class DAOFactoryTest {

	 @Test
	    public void testDAOPersonnel() {
	        DAO<Personnel> dao = DAOFactory.getDAOPersonnel(null);
	        assertTrue(dao.findAll().isEmpty());
	    }

	    @Test
	    public void testDAOCompositePersonnel() {
	        DAO<CompositePersonnel> dao = DAOFactory.getDAOCompositePersonnels(null);
	        assertTrue(dao.findAll().isEmpty());
	    }

}
