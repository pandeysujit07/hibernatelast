package com.lti.test;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.entity.Album;
import com.lti.entity.Song;

public class SongTest {

	@Test
	public void albumAddTest()
	{
		GenericDao dao = new GenericDao();
		Album a = new Album();
		 a.setDuration(3);
		 a.setTitle("local");
		 a.setSinger("sonu nigam");
		 dao.insertOrUpdate(a);
	}
	
	@Test
	public void songAddTest() {
		
		GenericDao dao = new GenericDao();
		Song s = new Song();
		Album al=(Album) dao.fetchById(Album.class, 191);
		s.setCopyright("speedrecords");
		s.setName("yuhi chala");
		s.setAlbum(al);
		dao.insertOrUpdate(s);
		
	}
	
	
}
