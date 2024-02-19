import { Component, OnInit } from '@angular/core';
import { CartItem } from 'src/app/model/cart-item.model';
import { Product } from '../../../model/product';
import { CartService } from '../../../services/cart.service';
import { ProductsService } from '../../../services/products.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss'],
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];

  constructor(
    private productsService: ProductsService,
    private cartService: CartService
  ) {}

  ngOnInit(): void {
    this.productsService.getProducts().subscribe((products) => {
      this.products = products;
    });
  }

  buyProduct(product: Product): void {
    const cartItem = new CartItem();
    cartItem.id = product._id;
    cartItem.name = product.name;
    cartItem.price = product.price;
    cartItem.quantity = 1;

    this.cartService.addToCart(product, cartItem.quantity);
  }
}
