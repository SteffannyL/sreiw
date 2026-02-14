import { Component } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { UsuarioService } from '../../services/usuario';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class Login {

  loginForm: FormGroup;
  loginError = false;
  loading = false;

  constructor(
    private fb: FormBuilder,
    private usuarioService: UsuarioService,
    private router: Router
  ) {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]]
    });
  }
  submit() {
    if (this.loginForm.invalid) return;

    const datos = {
      correo: this.loginForm.value.email,
      contrasena: this.loginForm.value.password
    };

    this.usuarioService.login(datos).subscribe({
      next: (resp) => {
        console.log('Login OK', resp);
        this.router.navigate(['/admin/users']);
      },
      error: (err) => {
        console.error(err);
        this.loginError = true;
      }
    });
  }
}
