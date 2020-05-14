import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GroceryListComponent } from './components/grocery-list/grocery-list.component';
import { GroceryListsComponent } from './components/grocery-lists/grocery-lists.component';


const routes: Routes = [
  { path: 'lists', component: GroceryListComponent },
  { path: 'items', component: GroceryListsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
