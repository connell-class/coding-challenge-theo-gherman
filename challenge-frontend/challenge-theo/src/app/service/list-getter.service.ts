import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { GroceryList } from '../models/grocery-list';

@Injectable({
  providedIn: 'root'
})
export class ListGetterService {

  constructor(private http: HttpClient) {}

  /**
   * Getting all lists in the database
   */
  public getLists(): Promise<GroceryList[]> {
    return this.http
      .get<GroceryList[]>(environment.base_url + 'grocery-lists')
      .toPromise();
  }


  /**
   * Getting list by id
   * @param int
   */
  public getListById(int: number): Promise<GroceryList> {
    return this.http
      .get<GroceryList>(environment.base_url + 'grocery-lists/' + int)
      .toPromise();
  }

  /**
   * Creating new list in the database
   */
  public createList(list: GroceryList): Promise<GroceryList> {
    return this.http
      .post<GroceryList>(environment.base_url + 'grocery-lists', list)
      .toPromise();
  }

  /**
   * Updating existing list in the database
   */
  public updateList(list: GroceryList): Promise<GroceryList> {
    return this.http
      .put<GroceryList>(environment.base_url + 'grocery-lists/' + list.listId, list)
      .toPromise();
  }


  /**
   * deleting list by id
   * @param int
   */
  public deleteListById(int: number): Promise<GroceryList> {
    return this.http
      .delete<GroceryList>(environment.base_url + 'grocery-lists/' + int)
      .toPromise();
  }

}
