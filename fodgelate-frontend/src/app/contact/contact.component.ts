import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.scss'],
})
export class ContactFormComponent implements OnInit {
  phonePattern = /^\(\d{2}\) \d{5}-\d{4}$/;

  contactForm = new FormGroup({
    name: new FormControl('', Validators.required),
    email: new FormControl('', [Validators.required, Validators.email]),
    phone: new FormControl('', [
      Validators.required,
      Validators.pattern(this.phonePattern),
    ]),
    message: new FormControl('', Validators.required),
  });

  constructor() {}

  ngOnInit(): void {}

  onSubmit(): void {
    console.warn(this.contactForm.value);
  }

  formatInput(event: Event) {
    const input = event.target as HTMLInputElement;
    let value = input.value.replace(/\D/g, '');
    if (value.length > 2) {
      value = `(${value.slice(0, 2)}) ${value.slice(2)}`;
    }
    if (value.length > 9) {
      value = `${value.slice(0, 10)}-${value.slice(9, 13)}`;
    }
    input.value = value;
  }
}
