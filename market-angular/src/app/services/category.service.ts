import { Category } from './../model/category';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private readonly API: string = "api/v1/categories"

  constructor(private http: HttpClient) { }

  list(){
    return this.http.get<Category[]>(this.API);
  }

  save(category: Partial<Category>){
    return this.http.post<Category>(this.API, category);
  }

  delete(id: string){
    return this.http.delete<Category>(`${this.API}/${id}`);
  }
}
