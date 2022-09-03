import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';

import { AppMaterialModule } from './../shared/app-material/app-material.module';
import { SharedModule } from './../shared/shared.module';
import { FormCategoryComponent } from './categories/form-category/form-category.component';
import { ListCategoriesComponent } from './categories/list-categories/list-categories.component';
import { ComponentsRoutingModule } from './components-routing.module';
import { IntroComponent } from './intro/intro.component';
import { ListProductsComponent } from './products/list-products/list-products.component';



@NgModule({
  declarations: [
    IntroComponent,
    ListCategoriesComponent,
    ListProductsComponent,
    IntroComponent,
    FormCategoryComponent
  ],
  imports: [
    CommonModule,
    ComponentsRoutingModule,
    AppMaterialModule,
    SharedModule,
    ReactiveFormsModule
  ],
})
export class ComponentsModule { }
