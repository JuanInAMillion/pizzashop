import { Component, OnInit } from '@angular/core';
import { products } from './products';
import {ActivatedRoute } from '@angular/router';
import {CartService} from './cart/cart.service';
@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  constructor(private cartService: CartService, private route: ActivatedRoute ) { }
  products = products;
  ngOnInit(): void {
  }

  addToCart(product) {
    this.cartService.addToCart(product);
    window.alert('Your product has been added to your cart');
}

}
