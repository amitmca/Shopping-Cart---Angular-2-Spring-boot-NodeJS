import { Order } from './../models/Order';
import { SERVICE_URL } from './service-data';
import { Injectable } from '@angular/core';
import { PRODUCTS } from '../models/product-data';
import { Product } from '../models/Product'; 
import { Observable, Subject } from 'rxjs';
import { Http, Response , Headers,RequestOptions} from '@angular/http';

@Injectable()
export class OrderService {

    constructor(private http: Http) {

    }

    getOrders() : Observable<Order[]>{
        return this.http.get(SERVICE_URL+'/orders')
            .map((res:Response) => <Order[]>res.json());
    }

    getOrder(id) {
        return this.http.get(SERVICE_URL+'/order/'+id)
            .map((res:Response) => res.json());
    }

    saveOrders(cart,totalCost,totalQuantity){
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        let order = {
            cart:cart,
            totalCost:totalCost,
            totalQuantity:totalQuantity
        }
        return this.http.post(SERVICE_URL+'/saveOrder', order, options)
            .map(resp => resp.json())
            .catch(err =>{
                console.log(err);
                return Observable.throw(err);
            });
    }

    deleteOrder(id){
        return this.http.get(SERVICE_URL+'/deleteOrder?orderId='+id)
            .map(resp => resp)
            .catch(err =>{
                console.log(err);
                return Observable.throw(err);
            });
    }

}