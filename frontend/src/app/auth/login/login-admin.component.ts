import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { UsuarioService } from '../../core/services/usuario-admin.service';

@Component({
  standalone: true,
  imports: [FormsModule],
  template: `
    <h2>Iniciar sesión</h2>

    <form (ngSubmit)="login()">
      <input
        type="email"
        [(ngModel)]="correo"
        name="correo"
        placeholder="Correo"
        required
      />

      <input
        type="password"
        [(ngModel)]="contrasena"
        name="contrasena"
        placeholder="Contraseña"
        required
      />

      <button type="submit">Entrar</button>
    </form>
  `
})
export class LoginAdminComponent {

  correo = '';
  contrasena = '';

  constructor(
    private usuarioService: UsuarioService,
    private router: Router
  ) {}

  login(): void {
    this.usuarioService.login({
      correo: this.correo,
      contrasena: this.contrasena
    }).subscribe({
      next: usuario => {
        console.log('LOGIN OK', usuario);

        localStorage.setItem('usuario', JSON.stringify(usuario));

        this.router.navigate(['/admin/users']);
      },
      error: () => {
        alert('Usuario o contraseña incorrectos');
      }
    });
  }
}
