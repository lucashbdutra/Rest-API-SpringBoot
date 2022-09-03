import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {path: "", pathMatch: 'full', redirectTo: 'home'}, //!Aqui estou redirecionando para o routing do "courses"
  {
    path: 'home',
    loadChildren: () => import('./components/components.module') .then(m => m.ComponentsModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
