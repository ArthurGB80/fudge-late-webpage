import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './modules/home/home.component';
import { ProductListComponent } from './modules/products/components/product-list/product-list.component';
import { ProductSearchComponent } from './modules/products/containers/product-search/product-search.component';
import { CartComponent } from './modules/cart/cart.component';
import { ContactComponent } from './modules/contact/contact.component';
import { AboutComponent } from './modules/about/about.component';
import { InfoComponent } from './modules/info/info.component';
import { AccountComponent } from './modules/account/account.component';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'products', component: ProductListComponent },
  { path: 'search', component: ProductSearchComponent },
  { path: 'cart', component: CartComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'about', component: AboutComponent },
  { path: 'info', component: InfoComponent },
  { path: 'account', component: AccountComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }