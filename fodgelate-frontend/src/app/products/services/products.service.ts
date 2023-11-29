import { Injectable } from '@angular/core';
import { Product } from '../model/product';


@Injectable({
  providedIn: 'root',
})
export class ProductsService {
  private products: Product[] = [
    {
      _id: 1,
      name: 'Product 1',
      price: 100,
      imageUrl: '/assets/img/products/product1.png',
      description: 'Description for Product 1',
      category: 'Category for Product 1',
      inventoryCount: 10,
      rating: 4.5,
    },
    {
      _id: 2,
      name: 'Product 2',
      price: 200,
      imageUrl: '/assets/img/products/product2.png',
      description: 'Description for Product 2',
      category: 'Category for Product 2',
      inventoryCount: 20,
      rating: 5.5,
    },
    {
      _id: 3,
      name: 'Product 3',
      price: 300,
      imageUrl: '/assets/img/products/product3.png',
      description: 'Description for Product 3',
      category: 'Category for Product 3',
      inventoryCount: 30,
      rating: 6.5,
    },
    {
      _id: 4,
      name: 'Product 4',
      price: 400,
      imageUrl: '/assets/img/products/product4.png',
      description: 'Description for Product 5',
      category: 'Category for Product 5',
      inventoryCount: 50,
      rating: 7.5,
    },
  ];

  constructor() {}

  getProduct(id: number): Product | undefined {
    return this.products.find((product) => product._id === id);
  }

  getProducts(): Product[] {
    return this.products;
  }
}
