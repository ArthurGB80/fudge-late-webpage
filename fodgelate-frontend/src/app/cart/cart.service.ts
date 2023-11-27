import { Injectable } from '@angular/core';
import { Product } from '../products/model/product';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  cart: Product[] = [];

  constructor() { }

  addToCart(product: Product): void {
    this.cart.push(product);
  }
}
