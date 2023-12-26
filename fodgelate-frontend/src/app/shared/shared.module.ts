import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatMenuModule } from '@angular/material/menu';
import { MatToolbarModule } from '@angular/material/toolbar';
import { RouterModule } from '@angular/router';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CarouselComponent } from './components/carousel/carousel.component';
import { ConfirmationDialogComponent } from './components/confirmation-dialog/confirmation-dialog.component';
import { ErrorDialogComponent } from './components/error-dialog/error-dialog.component';
import { FooterComponentComponent } from './components/footer.component/footer.component.component';
import { FreeDeliveryBannerComponent } from './components/free-delivery-banner/free-delivery-banner.component';
import { HeaderComponent } from './components/header/header.component';
import { IconButtonsComponent } from './components/header/icon-buttons/icon-buttons.component';
import { MobileMenuComponent } from './components/header/mobile-menu/mobile-menu.component';
import { NavigationMenuComponent } from './components/header/navigation-menu/navigation-menu.component';
import { LogoComponent } from './components/logo/logo.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { CategoryPipe } from './pipes/category.pipe';
import { MatCardModule } from '@angular/material/card';
import { ProductDetailComponent } from './components/product-detail/product-detail.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    ConfirmationDialogComponent,
    ErrorDialogComponent,
    CategoryPipe,
    HeaderComponent,
    CarouselComponent,
    LogoComponent,
    NavigationMenuComponent,
    IconButtonsComponent,
    MobileMenuComponent,
    ProductListComponent,
    FreeDeliveryBannerComponent,
    FooterComponentComponent,
    ProductDetailComponent,
      ],
  imports: [
    CommonModule,
    MatToolbarModule,
    MatIconModule,
    NgbModule,
    MatMenuModule,
    RouterModule,
    MatIconModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatCardModule,
    FormsModule,
  ],
  exports: [
    HeaderComponent,
    CarouselComponent,
    ProductListComponent,
    FreeDeliveryBannerComponent,
    FooterComponentComponent,
    LogoComponent,
    NavigationMenuComponent,
    IconButtonsComponent,
    MobileMenuComponent,
    MatIconModule,
    MatToolbarModule,
    ProductDetailComponent,

  ],
})
export class SharedModule {}
