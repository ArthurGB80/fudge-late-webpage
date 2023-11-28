import { Component, OnInit } from '@angular/core';
import { Product } from '../../../../core/model/product';
import { ProductsService } from '../../../../core/services/products.service';


@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss'],
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];

  constructor(private productsService: ProductsService) {}

  ngOnInit(): void {
    this.products = this.productsService.getProducts();
  }
}
