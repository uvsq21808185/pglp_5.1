package DAO;

import java.sql.Connection;

public abstract class DAO<T>{
	
	public  Connection connect ;
	/**
	 * Permet de r�cup�rer un objet via son nom
	 * @param nom
	 * @return
	 */
	public abstract T find(String nom);
	
	/**
	 * Permet de cr�er une entr�e dans la base de donn�es
	 * par rapport � un objet
	 * @param obj
	 * @throws ClassNotFoundException 
	 */
	public abstract T create(T obj) throws ClassNotFoundException;
	
	/**
	 * Permet de mettre � jour les donn�es d'une entr�e dans la base 
	 * @param obj
	 * @throws ClassNotFoundException 
	 */
	public abstract T update(T obj) throws ClassNotFoundException;
	
	/**
	 * Permet la suppression d'une entr�e de la base
	 * @param obj
	 */
	public abstract void delete(T obj);
}