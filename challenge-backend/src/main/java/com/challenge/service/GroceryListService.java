package com.challenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.dao.DaoContract;
import com.challenge.model.GroceryList;

@Service
public class GroceryListService {

	private DaoContract<GroceryList, Integer> dao;

	@Autowired
	public void setUserService(DaoContract<GroceryList, Integer> gl) {
		dao = gl;
	}
	

	  public List<GroceryList> getAll() {
	    return dao.findAll();
	  }

	  public GroceryList save(GroceryList t) {
	    dao.save(t);
	    return t;
	  }

	  public GroceryList getById(int id) {
	    return dao.findById(id);
	  }

	  public GroceryList update(GroceryList newGroceryList) {
		  GroceryList oldGroceryList = dao.findById(newGroceryList.getListId());
	    oldGroceryList = dao.update(newGroceryList);
	    return dao.findById(oldGroceryList.getListId());
	  }

	  public boolean deleteById(int id) {
	    dao.delete(dao.findById(id));
	    return true;
	  }

}
