package com.challenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.dao.DaoContract;
import com.challenge.model.GroceryItems;

@Service
public class GroceryItemsService {
	
	private DaoContract<GroceryItems, Integer> dao;

	@Autowired
	public void setUserService(DaoContract<GroceryItems, Integer> gi) {
		dao = gi;
	}
	
	public List<GroceryItems> getAll() {
	    return dao.findAll();
	  }

	  public GroceryItems save(GroceryItems t) {
	    dao.save(t);
	    return t;
	  }

	  public GroceryItems getById(int id) {
	    return dao.findById(id);
	  }

	  public GroceryItems update(GroceryItems newGroceryItems) {
		  GroceryItems oldGroceryItems = dao.findById(newGroceryItems.getItemsId());
	    oldGroceryItems = dao.update(newGroceryItems);
	    return dao.findById(oldGroceryItems.getItemsId());
	  }

	  public boolean deleteById(int id) {
	    dao.delete(dao.findById(id));
	    return true;
	  }


}
