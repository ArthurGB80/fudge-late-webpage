import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { RouterModule } from '@angular/router';
import { ProductListComponent } from './components/product-list/product-list.component';
import { ProductDetailComponent } from './containers/product-detail/product-detail.component';

@NgModule({
  declarations: [ProductListComponent, ProductDetailComponent],
  imports: [CommonModule, RouterModule, MatCardModule],
  exports: [ProductListComponent, ProductDetailComponent],
  providers: [],
  bootstrap: [],
})
export class ProductsModule {}
