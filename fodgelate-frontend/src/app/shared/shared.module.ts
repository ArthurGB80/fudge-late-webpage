import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { MatToolbarModule } from '@angular/material/toolbar';
import { HeaderComponent } from './components/header/header.component';
import { IconButtonsComponent } from './components/header/icon-buttons/icon-buttons.component';
import { LogoComponent } from './components/header/logo/logo.component';
import { MobileMenuComponent } from './components/header/mobile-menu/mobile-menu.component';
import { NavigationMenuComponent } from './components/header/navigation-menu/navigation-menu.component';
import { CarouselComponent } from './components/carousel/carousel.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [
    IconButtonsComponent,
    MobileMenuComponent,
    HeaderComponent,
    NavigationMenuComponent,
    CarouselComponent,
    LogoComponent
  ],
  exports: [
    MatIconModule,
    CarouselComponent,
    LogoComponent
  ],
  imports: [
    CommonModule,
    MatIconModule,
    MatMenuModule,
    MatToolbarModule,
    NgbModule,
  ],
})
export class SharedModule {}