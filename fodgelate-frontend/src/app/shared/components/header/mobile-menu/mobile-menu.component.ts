import { Component, HostListener, OnInit } from '@angular/core';

@Component({
  selector: 'app-mobile-menu',
  templateUrl: './mobile-menu.component.html',
  styleUrls: ['./mobile-menu.component.scss']
})
export class MobileMenuComponent implements OnInit {
  isMobile: boolean = false;

  constructor() {
    this.checkScreenSize();
  }

  ngOnInit() {}

  @HostListener('window:resize')
  checkScreenSize() {
    const width = window.innerWidth;
    if (width <= 600) {
      this.isMobile = true;
    } else {
      this.isMobile = false;
    }
  }

  onProdutosClick(): void {
    console.log('Produtos button clicked');
  }
}
