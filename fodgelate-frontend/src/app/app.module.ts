import { NgModule } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterModule } from '@angular/router';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatDividerModule } from '@angular/material/divider';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { AboutComponent } from './about/about.component';
import { AccountComponent } from './account/account.component';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CartComponent } from './cart/cart.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { ContactFormComponent } from './contact/contact.component'; // Corrected here
import { HomeComponent } from './home/home.component';
import { InfoComponent } from './info/info.component';
import { ProductpageComponent } from './productpage/productpage.component';
import { RegisterComponent } from './register/register.component';
import { ProductCardComponent } from './shared/components/product-card/product-card.component';
import { SharedModule } from './shared/shared.module';

@NgModule({
  declarations: [
    AppComponent,
    CartComponent,
    CheckoutComponent,
    HomeComponent,
    ContactFormComponent,
    AboutComponent,
    InfoComponent,
    AccountComponent,
    ProductpageComponent,
    RegisterComponent,
    ProductCardComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatCardModule,
    SharedModule,
    NgbModule,
    RouterModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatIconModule,
    MatDividerModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
