import { Routes } from '@angular/router';
import { Login } from './auth/login/login';
import { Register } from './auth/register/register';
import { Users } from './admin/users/users';
import { UserForm } from './admin/user-form/user-form';
import { Events } from './admin/events/events';
import { EventForm } from './admin/event-form/event-form';

export const routes: Routes = [
  { path: 'login', component: Login },
  { path: 'register', component: Register },


  { path: 'admin/users', component: Users },
  { path: 'admin/users/new', component: UserForm },
  { path: 'admin/users/edit/:id', component: UserForm },
  { path: 'admin/events', component: Events },
{ path: 'admin/events/new', component: EventForm },
{ path: 'admin/events/edit/:id', component: EventForm },
  { path: '', redirectTo: 'login', pathMatch: 'full' }
];
