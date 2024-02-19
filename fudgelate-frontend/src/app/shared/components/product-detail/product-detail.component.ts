import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CartItem } from 'src/app/model/cart-item.model';
import { Product } from '../../../model/product';
import { CartService } from '../../../services/cart.service';
import { ProductsService } from '../../../services/products.service';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.scss'],
})
export class ProductDetailComponent implements OnInit {
  product: Product | undefined;
  showZoom = false;
  mouseX = 0;
  mouseY = 0;
  backgroundPosition = '0% 0%';

  constructor(
    private route: ActivatedRoute,
    private productsService: ProductsService,
    private cartService: CartService
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      const id = +params['id']; 
      const product = this.productsService.getProduct(id);
      if (product) {
        this.product = product;
      } else {

      }
    });
  }

  onMouseMove(event: MouseEvent) {
    const { offsetX, offsetY, target } = event;
    const { offsetWidth, offsetHeight } = target as HTMLElement;

    const x = (offsetX / offsetWidth) * 100;
    const y = (offsetY / offsetHeight) * 100;

    this.mouseX = offsetX + 150;
    this.mouseY = offsetY - 50;

    this.backgroundPosition = `${x}% ${y}%`;
  }

  buyProduct(): void {
    if (this.product) {
      const cartItem = new CartItem();
      cartItem.id = this.product._id;
      cartItem.name = this.product.name;
      cartItem.price = this.product.price;
      cartItem.quantity = 1;

      this.cartService.addToCart(this.product, cartItem.quantity);
    }
  }
}
