import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { CategoryService } from 'src/app/services/category.service';

@Component({
  selector: 'app-form-update-category',
  templateUrl: './form-update-category.component.html',
  styleUrls: ['./form-update-category.component.scss']
})
export class FormUpdateCategoryComponent implements OnInit {

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
    id: [''],
    name: ['']
  });

  onSave(){
    this.service.update(this.form.value).subscribe();

    this.onCancel();
  }

  onCancel(){
    this.dialog.closeAll();
  }
}
