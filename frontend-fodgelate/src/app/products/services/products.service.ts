import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { filter } from 'rxjs/operators';
import { Product } from '../model/product';

@Injectable({
  providedIn: 'root',
})
export class ProductsService {
  // Mock data
  products: Product[] = [
    {
      _id: 1,
      name: 'Product 1 - Carro',
      description: 'This is product 1',
      price: 100,
      imageUrl: 'url-to-image-1',
      category: 'Category 1',
      inventoryCount: 10,
      rating: 4.5,
    },
    {
      _id: 2,
      name: 'Product 2',
      description: 'This is product 2',
      price: 200,
      imageUrl: 'url-to-image-2',
      category: 'Category 2',
      inventoryCount: 5,
      rating: 3.5,
    },
    // Add more products as needed
  ];

  constructor() {}

  getProducts(): Observable<Product[]> {
    return of(this.products);
  }

  getProduct(id: number): Observable<Product> {
    const product = this.products.find((product) => product._id === id);
    return of(product).pipe(
      filter((p) => p !== undefined)
    ) as Observable<Product>;
  }
}
