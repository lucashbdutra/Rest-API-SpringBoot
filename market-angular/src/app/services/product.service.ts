import { Product } from './../model/product';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) { }

  private readonly API: string = 'api/v1/products';

  list(){
    return this.http.get<Product[]>(this.API);
  }

}
