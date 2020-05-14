package com.challenge.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "grocery_items")
public class GroceryItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "items_id")
	private int itemsId;
	
	@ManyToOne
	@JoinColumn(name = "items_list", referencedColumnName = "list_id", nullable = false)
	private GroceryList itemsList;
	
	@Column(name = "items_category",  nullable = false)
	private String itemsCategory;
	
	@Column(name = "items_name", unique = true, nullable = false, length = 255)
	private String itemsName;

	public int getItemsId() {
		return itemsId;
	}

	public void setItemsId(int itemsId) {
		this.itemsId = itemsId;
	}

	public GroceryList getItemsList() {
		return itemsList;
	}

	public void setItemsList(GroceryList itemsList) {
		this.itemsList = itemsList;
	}

	public String getItemsCategory() {
		return itemsCategory;
	}

	public void setItemsCategory(String itemsCategory) {
		this.itemsCategory = itemsCategory;
	}

	public String getItemsName() {
		return itemsName;
	}

	public void setItemsName(String itemsName) {
		this.itemsName = itemsName;
	}

	@Override
	public String toString() {
		return "GroceryItems [itemsId=" + itemsId + ", itemsList=" + itemsList + ", itemsCategory=" + itemsCategory
				+ ", itemsName=" + itemsName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemsCategory == null) ? 0 : itemsCategory.hashCode());
		result = prime * result + itemsId;
		result = prime * result + ((itemsList == null) ? 0 : itemsList.hashCode());
		result = prime * result + ((itemsName == null) ? 0 : itemsName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroceryItems other = (GroceryItems) obj;
		if (itemsCategory == null) {
			if (other.itemsCategory != null)
				return false;
		} else if (!itemsCategory.equals(other.itemsCategory))
			return false;
		if (itemsId != other.itemsId)
			return false;
		if (itemsList == null) {
			if (other.itemsList != null)
				return false;
		} else if (!itemsList.equals(other.itemsList))
			return false;
		if (itemsName == null) {
			if (other.itemsName != null)
				return false;
		} else if (!itemsName.equals(other.itemsName))
			return false;
		return true;
	}

	public GroceryItems(int itemsId, GroceryList itemsList, String itemsCategory, String itemsName) {
		super();
		this.itemsId = itemsId;
		this.itemsList = itemsList;
		this.itemsCategory = itemsCategory;
		this.itemsName = itemsName;
	}

	public GroceryItems() {
		super();
	}

	
}
