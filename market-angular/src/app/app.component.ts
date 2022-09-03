import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'market-angular';

  constructor(
    private router: Router,
    private route: ActivatedRoute
     ){}

  onHome(){
    this.router.navigate([""]);
  }

  onCategoryList(){
    this.router.navigate(["home/categories"]);
  }

  onProductList(){
    this.router.navigate(["home/products"]);
  }
}
