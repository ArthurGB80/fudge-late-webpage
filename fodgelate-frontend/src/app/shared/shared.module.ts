import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { MatToolbarModule } from '@angular/material/toolbar';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CarouselComponent } from './components/carousel/carousel.component';
import { ConfirmationDialogComponent } from './components/confirmation-dialog/confirmation-dialog.component';
import { ErrorDialogComponent } from './components/error-dialog/error-dialog.component';
import { HeaderComponent } from './components/header/header.component';
import { IconButtonsComponent } from './components/header/icon-buttons/icon-buttons.component';
import { LogoComponent } from './components/header/logo/logo.component';
import { MobileMenuComponent } from './components/header/mobile-menu/mobile-menu.component';
import { NavigationMenuComponent } from './components/header/navigation-menu/navigation-menu.component';
import { CategoryPipe } from './pipes/category.pipe';

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
  ],
  imports: [
    CommonModule,
    MatToolbarModule,
    MatIconModule,
    NgbModule,
    MatMenuModule,
  ],
  exports: [HeaderComponent, CarouselComponent],
})
export class SharedModule {}
