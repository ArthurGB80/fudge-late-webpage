import { Component, HostListener, OnInit } from '@angular/core';

@Component({
  selector: 'app-mobile-menu',
  templateUrl: './mobile-menu.component.html',
  styleUrls: ['./mobile-menu.component.scss']
})
export class MobileMenuComponent implements OnInit {
  isMobile: boolean = false;

  constructor() {
    this.isMobile = window.innerWidth <= 900;
  }

  ngOnInit() {}

  @HostListener('window:resize', ['$event'])
  onResize(event: Event) {
    this.isMobile = (event.target as Window).innerWidth <= 900;
  }

}
