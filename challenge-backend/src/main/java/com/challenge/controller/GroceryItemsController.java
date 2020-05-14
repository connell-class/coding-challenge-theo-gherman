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

import com.challenge.model.GroceryItems;
import com.challenge.service.GroceryItemsService;

@Controller
@CrossOrigin
public class GroceryItemsController {
	
	 @Autowired
	  private GroceryItemsService gis;
	 
	 @RequestMapping(method = RequestMethod.GET, value = "/grocery-lists/items")
	  public ResponseEntity<List<GroceryItems>> findAll() {
	    return new ResponseEntity<List<GroceryItems>>(gis.getAll(), HttpStatus.OK);
	  }
	  
	  @RequestMapping(method = RequestMethod.GET, value = "/grocery-lists/items{id}")
	  public ResponseEntity<GroceryItems> getById(@PathVariable("id") int id) {
	    return new ResponseEntity<GroceryItems>(gis.getById(id), HttpStatus.OK);
	  }
	  
	  @RequestMapping(method = RequestMethod.POST, value = "/grocery-lists/items")
	  public ResponseEntity<GroceryItems> save(@RequestBody GroceryItems g) {
	    g = gis.save(g);
	    return new ResponseEntity<GroceryItems>(gis.getById(g.getItemsId()), HttpStatus.CREATED);
	  }
	  
	  @RequestMapping(method = RequestMethod.PUT, value = "/grocery-lists/items/{itemId}")
	  public ResponseEntity<GroceryItems> update(@RequestBody GroceryItems g, @PathVariable("itemId") int id) {
		  GroceryItems t = gis.getById(id);
	    if (t.getItemsId() == g.getItemsId()) {
	      gis.update(g);
	      return new ResponseEntity<GroceryItems>(gis.getById(id), HttpStatus.ACCEPTED);
	    } else {
	      return new ResponseEntity<GroceryItems>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  @RequestMapping(method = RequestMethod.DELETE, value = "/grocery-lists/items{itemId}")
	  public ResponseEntity<HttpStatus> delete(@PathVariable("itemId") int id) {
	    if (gis.deleteById(id)) {
	      return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	    } else {
		    return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}
