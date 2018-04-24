import { Router } from '@angular/router';
import { OrderService } from './../../services/order.service';
import { SERVICE_URL } from './../../services/service-data';
import { Component } from '@angular/core';
import { ProductService } from '../../services/product.service';
import { Subscription } from 'rxjs/Subscription';
import { CartAction } from 'app/store/actions/cart.actions';

@Component({
  selector: 'cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss'],
})
export class CartComponent {

  public cart = [];
  public totalPrice: number;
  public totalQuantity: number;
  public cartSubscription: Subscription;

  serviceUrl = SERVICE_URL;

  constructor(private productService: ProductService, private cartStore: CartAction, private orderService: OrderService, private router: Router) { }

  removeProduct(product) {
    this.cartStore.removeFromCart(product)
  }

  checkout() {
    if(this.totalQuantity!=0){
      this.orderService.saveOrders(this.cart, this.totalPrice, this.totalQuantity)
      .subscribe(data => {
        console.log(data);
        this.clearCart();
        this.router.navigateByUrl('/orders');
      }, err => {
        alert("Cannot Save Orders due to some");
      });
    }else{
      alert("Nothing to checkout");
    }
  }

  clearCart() {
    this.cart.forEach(product => {
      this.cartStore.removeFromCart(product)
    });
    this.totalPrice = 0;
    this.totalQuantity = 0;
  }

  getTotalPrice() {
    let totalCost: Array<number> = []
    let quantity: Array<number> = []
    let intPrice: number
    let intQuantity: number
    this.cart.forEach((item, i) => {
      intPrice = parseInt(item.price)
      intQuantity = parseInt(item.quantity)
      totalCost.push(intPrice)
      quantity.push(intQuantity)
    })

    this.totalPrice = totalCost.reduce((acc, item) => {
      return acc += item
    }, 0)
    this.totalQuantity = quantity.reduce((acc, item) => {
      return acc += item
    }, 0)
  }

  ngOnInit() {
    this.cartSubscription = this.cartStore.getState().subscribe(res => {
      this.cart = res.products
      this.getTotalPrice()
    })
  }

  ngOnDestroy() {
    this.cartSubscription.unsubscribe()
  }

}
