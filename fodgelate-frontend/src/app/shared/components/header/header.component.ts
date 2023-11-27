import { Component, HostListener } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent {
  isMobile = false;
  menuOpen = false;

  constructor() {
    this.checkScreenSize();
  }

  @HostListener('window:resize')
  checkScreenSize() {
    const width = window.innerWidth;
    if (width <= 600) {
      this.isMobile = true;
    } else {
      this.isMobile = false;
    }
  }

  openMenu() {
    this.menuOpen = !this.menuOpen;
  }

  onProdutosClick(): void {
    console.log('Produtos button clicked');
  }
}
