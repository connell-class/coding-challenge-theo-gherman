package com.challenge.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.challenge.model.GroceryItems;
import com.challenge.model.GroceryList;

@Repository
@Transactional
public class GroceryListDao implements DaoContract<GroceryList, Integer> {

	private SessionFactory ses;

	@Autowired
	public void setSesFact(SessionFactory sse) {
		ses = sse;
	}

	@Override
	public GroceryList findById(Integer id) {
		return ses.openSession().get(GroceryList.class, id);
	}

	@Override
	public void save(GroceryList t) {
		ses.openSession().save(t);
	}

	@Override
	public boolean delete(GroceryList t) {
		ses.getCurrentSession().delete(t);
	    if (findById(t.getListId()) == null) {
	      return true;
	    }
	    return false;
	}

	@Override
	public GroceryList update(GroceryList t) {
		ses.getCurrentSession().update(t);
	    return findById(t.getListId());
	}

	@Override
	public List<GroceryList> findAll() {
		return ses.openSession().createQuery("from GroceryList", GroceryList.class).getResultList();
	}

}
