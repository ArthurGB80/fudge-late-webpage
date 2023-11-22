import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { MatToolbarModule } from '@angular/material/toolbar';
import { CarouselComponent } from './components/carousel/carousel.component';
import { ConfirmationDialogComponent } from './components/confirmation-dialog/confirmation-dialog.component';
import { ErrorDialogComponent } from './components/error-dialog/error-dialog.component';
import { HeaderComponent } from './components/header/header.component';
import { CategoryPipe } from './pipes/category.pipe';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MatMenuModule } from '@angular/material/menu';

@NgModule({
  declarations: [
    ConfirmationDialogComponent,
    ErrorDialogComponent,
    CategoryPipe,
    HeaderComponent,
    CarouselComponent,
  ],
  imports: [CommonModule, MatToolbarModule, MatIconModule, NgbModule, MatMenuModule],
  exports: [HeaderComponent,CarouselComponent],
})
export class SharedModule {}
