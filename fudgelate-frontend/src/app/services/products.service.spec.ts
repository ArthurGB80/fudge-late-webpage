import { TestBed } from '@angular/core/testing';

import { ProductsService } from './products.service';

describe('ProductsService', () => {
  let service: ProductsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProductsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should return all products', () => {
    const products = service.getProducts();
    expect(products.length).toBe(4);
  });

  it('should return a single product', () => {
    const product = service.getProduct(1);
    expect(product).toBeTruthy();
    expect(product?._id).toBe(1);
  });

  it('should return undefined for non-existing product', () => {
    const product = service.getProduct(999);
    expect(product).toBeUndefined();
  });
});
