import { Component, Input, OnInit } from '@angular/core';
import {CartService} from '../../products/cart/cart.service';
import { PlaceorderService } from './placeorder/placeorder.service';
@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  products = this.cartService.getItems();
  constructor(private cartService: CartService, private placeOrder: PlaceorderService) { }

  

  ngOnInit(): void {
  }
  placeOrderMethod(products) {
    this.placeOrder.checkout(products)
    .subscribe((data) => {
      console.log(data);
    });
    alert("Order Placed Successfully");
    products = [];
  }
}
