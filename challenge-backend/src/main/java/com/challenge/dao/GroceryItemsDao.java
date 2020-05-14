package com.challenge.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.challenge.model.GroceryItems;

@Repository
@Transactional
public class GroceryItemsDao implements DaoContract<GroceryItems, Integer> {
	
	private SessionFactory ses;

	  @Autowired
	  public void setSesFact(SessionFactory sse) {
	    ses = sse;
	  }

	@Override
	public GroceryItems findById(Integer id) {
		return ses.openSession().get(GroceryItems.class, id);
	}

	@Override
	public void save(GroceryItems t) {
		ses.openSession().save(t);
	}

	@Override
	public boolean delete(GroceryItems t) {
		ses.getCurrentSession().delete(t);
	    if (findById(t.getItemsId()) == null) {
	      return true;
	    }
	    return false;
	}

	@Override
	public GroceryItems update(GroceryItems t) {
		ses.getCurrentSession().update(t);
	    return findById(t.getItemsId());
	}

	@Override
	public List<GroceryItems> findAll() {
		return ses.openSession().createQuery("from GroceryItems", GroceryItems.class).getResultList();
	}

}
