import { Component, HostListener, Renderer2, ElementRef } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent {
  isMobile = false;
  menuOpen = false;
  isScrolled = false;
  hideNavbar = false;
  lastScrollTop = 0;
  isScrollingDown = false;
  currentScrollTop = 0;

  constructor(private renderer: Renderer2, private el: ElementRef) {
    this.checkScreenSize();
  }

  @HostListener('window:resize')
  checkScreenSize() {
    const width = window.innerWidth;
    if (width <= 700) {
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

  @HostListener('window:scroll')
  onWindowScroll() {
    this.currentScrollTop = window.scrollY;
    const navbar = this.el.nativeElement.querySelector('mat-toolbar');

    if (this.currentScrollTop > this.lastScrollTop && this.currentScrollTop > 30) {
      // Scrolling down
      this.isScrollingDown = true;
      this.renderer.removeClass(navbar, 'navbar-transparent');
      this.renderer.addClass(navbar, 'navbar-opaque');
      this.renderer.addClass(navbar, 'navbar-hidden');
    } else if (this.currentScrollTop < this.lastScrollTop && this.isScrollingDown) {
      // Scrolling up
      this.isScrollingDown = false;
      this.renderer.removeClass(navbar, 'navbar-hidden');
      this.renderer.addClass(navbar, 'navbar-opaque');
    } else if (this.currentScrollTop <= 0) {
      // At the top of the page
      this.renderer.removeClass(navbar, 'navbar-opaque');
      this.renderer.addClass(navbar, 'navbar-transparent');
    }

    this.lastScrollTop = this.currentScrollTop <= 0 ? 0 : this.currentScrollTop; // For Mobile or negative scrolling
  }
}
