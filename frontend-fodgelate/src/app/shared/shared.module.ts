import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ConfirmationDialogComponent } from './components/confirmation-dialog/confirmation-dialog.component';
import { ErrorDialogComponent } from './components/error-dialog/error-dialog.component';
import { CategoryPipe } from './pipes/category.pipe';



@NgModule({
  declarations: [
    ConfirmationDialogComponent,
    ErrorDialogComponent,
    CategoryPipe
  ],
  imports: [
    CommonModule
  ]
})
export class SharedModule { }
