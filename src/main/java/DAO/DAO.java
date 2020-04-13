package DAO;

import java.sql.Connection;

public abstract class DAO<T>{
	
	public  Connection connect ;
	/**
	 * Permet de récupérer un objet via son nom
	 * @param nom
	 * @return
	 */
	public abstract T find(String nom);
	
	/**
	 * Permet de créer une entrée dans la base de données
	 * par rapport à un objet
	 * @param obj
	 * @throws ClassNotFoundException 
	 */
	public abstract T create(T obj) throws ClassNotFoundException;
	
	/**
	 * Permet de mettre à jour les données d'une entrée dans la base 
	 * @param obj
	 * @throws ClassNotFoundException 
	 */
	public abstract T update(T obj) throws ClassNotFoundException;
	
	/**
	 * Permet la suppression d'une entrée de la base
	 * @param obj
	 */
	public abstract void delete(T obj);
}