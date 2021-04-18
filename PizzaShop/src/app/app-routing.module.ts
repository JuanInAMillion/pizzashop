import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { AboutComponent } from './components/about/about.component';
import { MenuComponent } from './components/menu/menu.component';
import { OrdernowComponent } from './components/ordernow/ordernow.component';
import { AccountComponent } from './components/account/account.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { LoginComponent } from './components/login/login.component';

const routes: Routes = [
  { //this makes the home page the default path
    path: '',   
    redirectTo: '/home', 
    pathMatch: 'full' },
  { 
    path: 'home', 
    component: HomeComponent
  },
  { 
    path: 'about', 
    component: AboutComponent 
  },
  { 
    path: 'menu', 
    component: MenuComponent
  },
  {
    path: 'ordernow',
    component: OrdernowComponent
  },
  {
    path: 'account',
    component: AccountComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: '**', 
    component: PageNotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
