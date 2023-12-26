import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.scss']
})
export class AccountComponent implements OnInit {
  loginForm = new FormGroup({
    email: new FormControl(''),
    password: new FormControl(''),
  });

  constructor(private router: Router) {}

  ngOnInit(): void {}

  onSubmit(): void {
    console.warn(this.loginForm.value);
  }

  createAccount(): void {
    this.router.navigate(['/register']);
  }
}
