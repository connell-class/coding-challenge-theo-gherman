import { Component, OnInit } from '@angular/core';
import { ListGetterService } from '../../service/list-getter.service';
import { ItemGetterService } from '../../service/item-getter.service';
import { GroceryList } from '../../models/grocery-list';
import { GroceryListItem } from '../../models/grocery-list-item';

@Component({
  selector: 'app-grocery-list',
  templateUrl: './grocery-list.component.html',
  styleUrls: ['./grocery-list.component.css']
})
export class GroceryListComponent implements OnInit {
  lists: GroceryList[];
  list: GroceryList;
  items: GroceryListItem[];
  item: GroceryListItem;

  constructor(
    private listGetter: ListGetterService,
    private itemGetter: ItemGetterService,
  ) { }

  ngOnInit(): void {
    this.getAllItems();
  }

  getAllItems() {
    this.itemGetter.getLists().then((data) => {
      console.log(data);
      this.items = data;
    });
  }

  getItemsById(id) {
    this.itemGetter.getListById(id).then((data) => {
      console.log(data);
      this.item = data;
    });
  }

}
