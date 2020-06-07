import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {HomePageComponent} from "./home-page/home-page.component";
import {CharityPageComponent} from "./charity-page/charity-page.component";
import {CreateCharityPageComponent} from "./create-charity-page/create-charity-page.component";
import {EditCharityPageComponent} from "./edit-charity-page/edit-charity-page.component";

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'home-page', component: HomePageComponent},
  {path: 'charity-page', component: CharityPageComponent},
  {path: 'charity-page/:id', component: CharityPageComponent},
  {path: 'create-charity-page', component: CreateCharityPageComponent},
  {path: 'edit-charity-page', component: EditCharityPageComponent},
  {path: 'edit-charity-page/:id', component: EditCharityPageComponent},
  {path: '', component: HomePageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {onSameUrlNavigation: 'reload'})],
  exports: [RouterModule]
})

export class AppRoutingModule {
}
