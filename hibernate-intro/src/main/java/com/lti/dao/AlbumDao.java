package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Song;
import com.lti.entity.Transaction;

public class AlbumDao extends GenericDao {

public List<Song> fetchSong(int id){
		
		EntityManagerFactory emf=null;
		EntityManager em=null;
		
		try {
			emf=Persistence.createEntityManagerFactory("oracleTest");
			em=emf.createEntityManager();
			//Getting all the records from the table and generalizing the reception
			
			String ql= "select s from Song s where s.album.id= :idd  ";
			
			
			
			Query q =  em.createQuery(ql);
			
			q.setParameter("idd",id);
			
			
			List<Song> list = q.getResultList();
			return list;
		}
		
		finally {	
			em.close();
			emf.close();
		}
	
    }
}
