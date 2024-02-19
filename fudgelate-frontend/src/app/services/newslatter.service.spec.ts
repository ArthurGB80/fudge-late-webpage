import { TestBed } from '@angular/core/testing';

import { NewslatterService } from './newslatter.service';

describe('NewslatterService', () => {
  let service: NewslatterService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NewslatterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
