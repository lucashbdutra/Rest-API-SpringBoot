import { ListProductsComponent } from './products/list-products/list-products.component';
import { ListCategoriesComponent } from './categories/list-categories/list-categories.component';
import { IntroComponent } from './intro/intro.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormCategoryComponent } from './categories/form-category/form-category.component';

const routes: Routes = [
  {path:"", component: IntroComponent},
  {path:"categories", component: ListCategoriesComponent},
  {path:"products", component: ListProductsComponent},
  {path:"categories/new", component: FormCategoryComponent}

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ComponentsRoutingModule { }
