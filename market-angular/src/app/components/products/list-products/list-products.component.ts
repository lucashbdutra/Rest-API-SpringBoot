import { Product } from './../../../model/product';
import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-list-products',
  templateUrl: './list-products.component.html',
  styleUrls: ['./list-products.component.scss']
})
export class ListProductsComponent implements OnInit {

  products$: Observable<Product[]>;

  constructor(private service: ProductService) {
    this.products$ = service.list();
   }

  ngOnInit(): void {
  }

  displayedColumns = ["id","name", "price", "category", "actions"];
}

