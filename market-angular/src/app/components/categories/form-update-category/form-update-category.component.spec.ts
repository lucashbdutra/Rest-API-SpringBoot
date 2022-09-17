import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormUpdateCategoryComponent } from './form-update-category.component';

describe('FormUpdateCategoryComponent', () => {
  let component: FormUpdateCategoryComponent;
  let fixture: ComponentFixture<FormUpdateCategoryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormUpdateCategoryComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormUpdateCategoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
