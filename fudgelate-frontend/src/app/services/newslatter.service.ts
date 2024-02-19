import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NewsletterService {
  private apiUrl = 'http://localhost:8080/newsletter'; // Replace 

  constructor(private http: HttpClient) { }

  subscribe(email: string): Observable<any> {
    return this.http.post(this.apiUrl, { email: email });
  }
}