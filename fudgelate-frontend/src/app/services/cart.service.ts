import { Injectable } from '@angular/core';
import { CartItem } from 'src/app/model/cart-item.model';
import { Product } from 'src/app/model/product';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  cartItems: CartItem[] = [];
  subtotal = 0;


  addToCart(product: Product, quantity: number): void {
    const item = new CartItem();
    item.id = product._id;
    item.name = product.name;
    item.price = product.price;
    item.quantity = quantity;
    item.imageUrl = product.imageUrl;

    // set other properties as needed...

    this.cartItems.push(item);
    this.calculateSubtotal();
  }

  removeOneFromCart(item: CartItem): void {
    const index = this.cartItems.findIndex(cartItem => cartItem.id === item.id);

    if (index > -1) {
      this.cartItems = [
        ...this.cartItems.slice(0, index),
        ...this.cartItems.slice(index + 1)
      ];
    }

    // Update the total
    this.calculateSubtotal();
  }
  calculateTotal(): number {
    return this.cartItems.reduce((acc, item) => acc + (item.price * item.quantity), 0);
  }

  calculateSubtotal() {
    this.subtotal = this.cartItems.reduce((total, item) => total + (item.price * item.quantity), 0);
  }
}
