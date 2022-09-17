import { FormUpdateCategoryComponent } from '../form-update-category/form-update-category.component';
import { Router, ActivatedRoute } from '@angular/router';
import { Category } from './../../../model/category';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { CategoryService } from 'src/app/services/category.service';
import { MatDialog } from '@angular/material/dialog';
import { FormCategoryComponent } from '../form-category/form-category.component';

@Component({
  selector: 'app-list-categories',
  templateUrl: './list-categories.component.html',
  styleUrls: ['./list-categories.component.scss']
})
export class ListCategoriesComponent implements OnInit {

  $categories: Observable<Category[]>;

  displayedColumns = ["id","name", "actions"];

  constructor(
    private service: CategoryService,
    private router: Router,
    private route: ActivatedRoute,
    private dialog: MatDialog,
    ) {
    this.$categories = this.service.list()
  }

  ngOnInit(): void {
  }

  load(){
    this.$categories = this.service.list();
  }

  onAdd(){
    this.dialog.open(FormCategoryComponent)
    .afterClosed()
    .subscribe(() => this.load());
  }

  onDelete(id: string){
    this.service.delete(id).subscribe(()=> this.load());
  }

  onUpdate(){
    this.dialog.open(FormUpdateCategoryComponent)
    .afterClosed()
    .subscribe(() => this.load());
  }

}
