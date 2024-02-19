import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { NewsletterService } from 'src/app/services/newslatter.service';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.component.html',
  styleUrls: ['./footer.component.component.scss']
})
export class FooterComponentComponent {
  subscribeForm = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email])
  });

  constructor(private newsletterService: NewsletterService) { }

  subscribe() {
    if (this.subscribeForm.valid) {
      const email = this.subscribeForm.value.email;
      if (email) {
        this.newsletterService.subscribe(email).subscribe(
          (response: any) => { // Specify the type for the response
            // Handle successful subscription
            console.log('Subscribed successfully', response);
          },
          (error: any) => { // Specify the type for the error
            // Handle error
            console.error('Error subscribing', error);
          }
        );
      } else {
        console.error('Email value is null or undefined');
      }
    }
  }
}