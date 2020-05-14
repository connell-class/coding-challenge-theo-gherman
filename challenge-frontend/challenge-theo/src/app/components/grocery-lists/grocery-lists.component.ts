import { Component, OnInit } from '@angular/core';
import { ListGetterService } from '../../service/list-getter.service';
import { GroceryList } from '../../models/grocery-list';

@Component({
  selector: 'app-grocery-lists',
  templateUrl: './grocery-lists.component.html',
  styleUrls: ['./grocery-lists.component.css']
})
export class GroceryListsComponent implements OnInit {

  lists: GroceryList[];
  list: GroceryList;
  selectedList: GroceryList;

  constructor(
    private listGetter: ListGetterService,
  ) { }

  ngOnInit(): void {
    this.getAllLists();
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

  onSelect(list) {
    this.selectedList = list;
    console.log(list);
  }

}
