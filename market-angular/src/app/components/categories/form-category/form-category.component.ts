import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { CategoryService } from 'src/app/services/category.service';
import { ListCategoriesComponent } from '../list-categories/list-categories.component';

@Component({
  selector: 'app-form-category',
  templateUrl: './form-category.component.html',
  styleUrls: ['./form-category.component.scss']
})
export class FormCategoryComponent implements OnInit {

  constructor(
    private formBuilder: NonNullableFormBuilder,
    private service: CategoryService,
    private dialog: MatDialog,
    private router: Router,
    private route: ActivatedRoute,
    private location: Location
    ) { }

  ngOnInit(): void {
  }

  form = this.formBuilder.group({
    name: ['']
  });

  onSave(){
    this.service.save(this.form.value).subscribe();
    // this.router.navigate(['../list-categories'], {relativeTo:this.route});
    // this.location.go('home/categories');
    this.onCancel();
  }

  onCancel(){
    this.dialog.closeAll();
  }

}
