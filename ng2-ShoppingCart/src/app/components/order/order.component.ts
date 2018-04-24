import { Order } from '../../models/Order';
import { OrderService } from './../../services/order.service';
import { SERVICE_URL } from './../../services/service-data';
import { Component } from '@angular/core';
import { ProductService } from '../../services/product.service';
import { Subscription } from 'rxjs/Subscription';

@Component({
  selector: 'orders',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.scss'],
})
export class OrderComponent {

  public orders:Order[];

  serviceUrl = SERVICE_URL;

  constructor(private orderService:OrderService) {}


  ngOnInit() {
    this.orderService.getOrders().subscribe(orders =>{
      this.orders = orders;
    });
  }

  deleteOrder(id) {
    this.orderService.deleteOrder(id).subscribe(orders =>{
      this.orders = this.orders.filter(order=> order.id!=id);
    });
  }
  
}
