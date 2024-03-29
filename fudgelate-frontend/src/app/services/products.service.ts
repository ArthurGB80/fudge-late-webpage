import { Injectable } from '@angular/core';
import { of } from 'rxjs';
import { Observable } from 'rxjs/internal/Observable';
import { Product } from 'src/app/model/product';

@Injectable({
  providedIn: 'root',
})
export class ProductsService {
  private products: Product[] = [
    {
      _id: 1,
      name: 'Product 1',
      price: 100,
      imageUrl: 'https://raw.githubusercontent.com/ArthurGB80/fudgelate-frontend4/main/docs/assets/img/products/product1.png',
      description: 'Várias casquinhas de brownie de chocolate em formato de tiras e dentro da lata mais famosa de todas, com um rótulo com as artes de Äline Besourö desenvolvidas para o livro “A História do Mal”.',
      category: 'Category for Product 1',
      inventoryCount: 10,
      rating: 4.5,
      expiryDate: '2023-12-31',
      weight: 10
    },
    {
      _id: 2,
      name: 'Product 2',
      price: 200,
      imageUrl: 'https://raw.githubusercontent.com/ArthurGB80/fudgelate-frontend4/main/docs/assets/img/products/product2.png',
      description: 'Várias casquinhas de brownie de chocolate em formato de tiras e dentro da lata mais famosa de todas, com um rótulo com as artes de Äline Besourö desenvolvidas para o livro “A História do Mal”.',
      category: 'Category for Product 2',
      inventoryCount: 20,
      rating: 5.5,
      expiryDate: '2023-12-31',
      weight: 20
    },
    {
      _id: 3,
      name: 'Product 3',
      price: 300,
      imageUrl: 'https://raw.githubusercontent.com/ArthurGB80/fudgelate-frontend4/main/docs/assets/img/products/product3.png',
      description: 'Várias casquinhas de brownie de chocolate em formato de tiras e dentro da lata mais famosa de todas, com um rótulo com as artes de Äline Besourö desenvolvidas para o livro “A História do Mal”.',
      category: 'Category for Product 3',
      inventoryCount: 30,
      rating: 6.5,
      expiryDate: '2023-12-31',
      weight: 30
    },
    {
      _id: 4,
      name: 'Product 4',
      price: 400,
      imageUrl: 'https://raw.githubusercontent.com/ArthurGB80/fudgelate-frontend4/main/docs/assets/img/products/product4.png',
      description: 'Várias casquinhas de brownie de chocolate em formato de tiras e dentro da lata mais famosa de todas, com um rótulo com as artes de Äline Besourö desenvolvidas para o livro “A História do Mal”.',
      category: 'Category for Product 5',
      inventoryCount: 50,
      rating: 7.5,
      expiryDate: '2023-12-31',
      weight: 40
    },
  ];

  constructor() {}

  getProduct(id: number): Product | undefined {
    return this.products.find((product) => product._id === id);
  }

  getProducts(): Observable<Product[]> {
    return of(this.products);
  }
}
