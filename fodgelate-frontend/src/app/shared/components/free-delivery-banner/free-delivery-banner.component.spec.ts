import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FreeDeliveryBannerComponent } from './free-delivery-banner.component';

describe('FreeDeliveryBannerComponent', () => {
  let component: FreeDeliveryBannerComponent;
  let fixture: ComponentFixture<FreeDeliveryBannerComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FreeDeliveryBannerComponent]
    });
    fixture = TestBed.createComponent(FreeDeliveryBannerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
