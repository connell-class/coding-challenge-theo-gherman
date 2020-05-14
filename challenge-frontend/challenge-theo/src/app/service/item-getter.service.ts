import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { GroceryListItem } from '../models/grocery-list-item';

@Injectable({
  providedIn: 'root'
})
export class ItemGetterService {

  constructor(private http: HttpClient) {}


  /**
   * Getting all lists in the database
   */
  public getLists(): Promise<GroceryListItem[]> {
    return this.http
      .get<GroceryListItem[]>(environment.base_url + 'grocery-lists/items')
      .toPromise();
  }


  /**
   * Getting items by id
   * @param int
   */
  public getListById(int: number): Promise<GroceryListItem> {
    return this.http
      .get<GroceryListItem>(environment.base_url + 'grocery-lists/items/' + int)
      .toPromise();
  }

  /**
   * Creating new item in the database
   */
  public createList(item: GroceryListItem): Promise<GroceryListItem> {
    return this.http
      .post<GroceryListItem>(environment.base_url + 'grocery-lists/items', item)
      .toPromise();
  }

  /**
   * Updating existing item in the database
   */
  public updateList(item: GroceryListItem): Promise<GroceryListItem> {
    return this.http
      .put<GroceryListItem>(environment.base_url + 'grocery-lists/items/' + item.itemsId, item)
      .toPromise();
  }


  /**
   * deleting item by id
   * @param int
   */
  public deleteListById(int: number): Promise<GroceryListItem> {
    return this.http
      .delete<GroceryListItem>(environment.base_url + 'grocery-lists/items/' + int)
      .toPromise();
  }

}
