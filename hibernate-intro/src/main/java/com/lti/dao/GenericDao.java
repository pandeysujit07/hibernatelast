package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Customer;

public class GenericDao {
	
	public void insertOrUpdate(Object obj) {			
		EntityManagerFactory emf=null;
		EntityManager em=null;
		
		try {
			emf=Persistence.createEntityManagerFactory("oracleTest");
			em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			et.begin();
			em.merge(obj); 			//Reflection API
			et.commit();
		}
		
		finally {
			em.close();
			emf.close();
		}
}
	
	public Object fetchById(Class classname,Object  id) {
		
			EntityManagerFactory emf=null;
			EntityManager em=null;
			try {
				emf=Persistence.createEntityManagerFactory("oracleTest");
				em=emf.createEntityManager();
				
				Object obj = em.find(classname, id);
				return obj;
			}
			
			finally {
				em.close();
				emf.close();
			}
	}
	
	//public  List<?> fetchAll(Class clazz) {  			 			//fetch all the records in the table . ? can get any kind of list object list, or any other list 
	public  <E> List<E> fetchAll(Class<E> clazz) {			//fetch using generics of a type E No type casting required further 
			EntityManagerFactory emf=null;
			EntityManager em=null;
			
			try {
				emf=Persistence.createEntityManagerFactory("oracleTest");
				em=emf.createEntityManager();
				//Getting all the records from the table and generalizing the reception
				
				Query q =  em.createQuery("select  obj  from "+clazz.getName()+" as obj");
				//List<?> list = q.getResultList();
				List<E> list = q.getResultList();
				return list;
			}
			
			finally {	
				em.close();
				emf.close();
			}
		}
	
}
