import { Component, OnInit } from '@angular/core';
import { CartItem } from '../model/cart-item.model';
import { Product } from '../model/product';
import { CartService } from '../services/cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss'],
})
export class CartComponent implements OnInit {
  cartItems: CartItem[] = [];
  total: number = 0;
  subtotal = 0;
  quantity: number = 1;

  constructor(private cartService: CartService) {}

  ngOnInit(): void {
    this.cartItems = this.cartService.cartItems;
    this.total = this.cartService.calculateTotal();
    this.subtotal = this.cartService.subtotal;
  }

  addToCart(item: CartItem): void {
    const product = new Product();
    product._id = item.id;
    product.name = item.name;
    product.price = item.price;
    product.imageUrl = item.imageUrl;
    // set other properties as needed...

    this.cartService.addToCart(product, item.quantity);
    this.total = this.cartService.calculateTotal();
    this.subtotal = this.cartService.subtotal;
  }

  removeOneFromCart(item: CartItem): void {
    this.cartService.removeOneFromCart(item);
    this.cartItems = this.cartService.cartItems;
    this.total = this.cartService.calculateTotal();
    this.subtotal = this.cartService.subtotal;
  }
}
