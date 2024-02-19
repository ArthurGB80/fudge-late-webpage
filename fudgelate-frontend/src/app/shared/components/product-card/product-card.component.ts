import { Component, OnInit } from '@angular/core';
import { CartItem } from 'src/app/model/cart-item.model';
import { Product } from '../../../model/product';
import { CartService } from '../../../services/cart.service';
import { ProductsService } from '../../../services/products.service';

@Component({
  selector: 'app-product-card',
  templateUrl: './product-card.component.html',
  styleUrls: ['./product-card.component.scss'],
})
export class ProductCardComponent implements OnInit {
  product!: Product;

  constructor(
    private productsService: ProductsService,
    private cartService: CartService
  ) {}

  ngOnInit(): void {
    this.productsService.getProducts().subscribe((products) => {
      const randomIndex = Math.floor(Math.random() * products.length);
      this.product = products[randomIndex];
    });
  }
  buyProduct(): void {
    const cartItem = new CartItem();
    cartItem.id = this.product._id;
    cartItem.name = this.product.name;
    cartItem.price = this.product.price;
    cartItem.quantity = 1;

    this.cartService.addToCart(this.product, cartItem.quantity);
  }
}
