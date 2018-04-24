import { SERVICE_URL } from './service-data';
import { Injectable } from '@angular/core';
import { PRODUCTS } from '../models/product-data';
import { Product } from '../models/Product'; 
import { Observable, Subject } from 'rxjs';
import { Http, Response } from '@angular/http';

@Injectable()
export class ProductService {

    constructor(private http: Http) {

    }

    getProducts() : Observable<Product[]>{
        // return Promise.resolve(PRODUCTS)
        return this.http.get(SERVICE_URL+'/productList')
            .map((res:Response) => <Product[]>res.json());
    }

    getProduct(id) {
        return this.http.get(SERVICE_URL+'/product/'+id)
            .map((res:Response) => res.json());
    }

}