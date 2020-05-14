import { Component, OnInit } from '@angular/core';
import { ListGetterService } from '../../service/list-getter.service';
import { GroceryList } from '../../models/grocery-list';
import { GroceryListItem } from '../../models/grocery-list-item';
import { ItemGetterService } from '../../service/item-getter.service';


@Component({
  selector: 'app-grocery-lists',
  templateUrl: './grocery-lists.component.html',
  styleUrls: ['./grocery-lists.component.css']
})
export class GroceryListsComponent implements OnInit {

  lists: GroceryList[];
  list: GroceryList;
  item: GroceryListItem;
  items: GroceryListItem[];
  selectedList: GroceryList;

  constructor(
    private listGetter: ListGetterService,
    private itemGetter: ItemGetterService,
  ) { }

  ngOnInit(): void {
    this.getAllLists();
    this.getAllItems();
  }

  getAllLists() {
    this.listGetter.getLists().then((data) => {
      console.log(data);
      this.lists = data;
    });
  }

  getListById(id) {
    this.listGetter.getListById(id).then((data) => {
      console.log(data);
      this.list = data;
    });
  }

  getAllItems() {
    this.itemGetter.getLists().then((data) => {
      console.log(data);
      this.items = data;
    });
  }

  onSelect(list) {
    this.selectedList = list;
    console.log(list);
  }

}
