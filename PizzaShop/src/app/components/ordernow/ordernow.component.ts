import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import {ActivatedRoute } from '@angular/router';
import {CartService} from '../../products/cart/cart.service';

@Component({
  selector: 'app-ordernow',
  templateUrl: './ordernow.component.html',
  styleUrls: ['./ordernow.component.css']
})
export class OrdernowComponent implements OnInit {


  constructor(private cartService: CartService, private route: ActivatedRoute ) { }

  ngOnInit(): void {
  }
}

