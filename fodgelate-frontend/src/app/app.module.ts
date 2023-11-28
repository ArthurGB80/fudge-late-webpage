import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { MatCardModule } from '@angular/material/card';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterModule } from '@angular/router';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AboutComponent } from './modules/about/about.component';
import { AccountComponent } from './modules/account/account.component';
import { AppRoutingModule } from './app.routes';
import { AppComponent } from './app.component';
import { CartComponent } from './modules/cart/cart.component';
import { CheckoutComponent } from './modules/checkout/checkout.component';
import { ContactComponent } from './modules/contact/contact.component';
import { HomeComponent } from './modules/home/home.component';
import { InfoComponent } from './modules/info/info.component';
import { ProductListComponent } from './modules/products/components/product-list/product-list.component';
import { ProductsModule } from './modules/products/products.module';
import { SharedModule } from './shared/shared.module';

@NgModule({
  declarations: [
    AppComponent,
    CartComponent,
    CheckoutComponent,
    HomeComponent,
    ContactComponent,
    AboutComponent,
    InfoComponent,
    AccountComponent,
    ProductListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatCardModule,
    ProductsModule,
    SharedModule,
    NgbModule,
    RouterModule,
    
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}