import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-free-delivery-banner',
  templateUrl: './free-delivery-banner.component.html',
  styleUrls: ['./free-delivery-banner.component.scss']
})
export class FreeDeliveryBannerComponent {
  @Input() position: 'top' | 'belowHeader' = 'top';
}
