import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import {CartService} from '../../../products/cart/cart.service';
import {catchError, retry } from 'rxjs/operators';
import { Order } from 'src/app/models/order';
@Injectable({
  providedIn: 'root'
})
export class PlaceorderService {
  baseUrl = 'http://localhost:9095/orderpage/';
  constructor(private http: HttpClient, private cartService: CartService) { }

  httpOptions = {
    headers: new HttpHeaders ({
      'Content-Type' : 'application/json',
    }),
  };

  checkout(products): Observable<Order> {
    let user = localStorage.getItem('token');
    let shippingAddress = localStorage.getItem('token2');
    let orderDate = new Date();
    let isPending = true;
    let order = new Order(user, shippingAddress, orderDate, isPending, products);
    console.log(order);
    return this.http.post<Order>(`${this.baseUrl}orders`, JSON.stringify(order), this.httpOptions)
    .pipe(retry(1), catchError(this.errorHandler));
  }

  errorHandler(error:any) {
    let errorMessage = '';
    if(error.error instanceof ErrorEvent) {
      errorMessage = error.error.message;
    }else{
      errorMessage = `Error Status: ${error.status}\nMessage: ${error.message}`
    }
    console.log(errorMessage);
    alert("Failed to place order, please try again.")
    return throwError(errorMessage);
  }


}
