package com.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.challenge.model.GroceryList;
import com.challenge.service.GroceryListService;

@Controller
@CrossOrigin
public class GroceryListController {
	
	 @Autowired
	  private GroceryListService gls;

	 
	  @RequestMapping(method = RequestMethod.GET, value = "/grocery-lists")
	  public ResponseEntity<List<GroceryList>> findAll() {
	    return new ResponseEntity<List<GroceryList>>(gls.getAll(), HttpStatus.OK);
	  }
	  
	  @RequestMapping(method = RequestMethod.GET, value = "/grocery-lists/{id}")
	  public ResponseEntity<GroceryList> getById(@PathVariable("id") int id) {
	    return new ResponseEntity<GroceryList>(gls.getById(id), HttpStatus.OK);
	  }
	  
	  @RequestMapping(method = RequestMethod.POST, value = "/grocery-lists")
	  public ResponseEntity<GroceryList> save(@RequestBody GroceryList g) {
	    g = gls.save(g);
	    return new ResponseEntity<GroceryList>(gls.getById(g.getListId()), HttpStatus.CREATED);
	  }
	  
	  @RequestMapping(method = RequestMethod.PUT, value = "/grocery-lists/{id}")
	  public ResponseEntity<GroceryList> update(@RequestBody GroceryList g, @PathVariable("id") int id) {
		  GroceryList t = gls.getById(id);
	    if (t.getListId() == g.getListId()) {
	      gls.update(g);
	      return new ResponseEntity<GroceryList>(gls.getById(id), HttpStatus.ACCEPTED);
	    } else {
	      return new ResponseEntity<GroceryList>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  @RequestMapping(method = RequestMethod.DELETE, value = "/grocery-lists/{id}")
	  public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id) {
	    if (gls.deleteById(id)) {
	      return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	    } else {
		    return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  
	  
	  
	  
	  
}
