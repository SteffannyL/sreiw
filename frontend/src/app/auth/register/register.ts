import { Component } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { UsuarioService } from '../../services/usuario';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './register.html',
  styleUrl: './register.css'
})
export class Register {

  nombre = '';
  email = '';
  password = '';

  constructor(private usuarioService: UsuarioService) {}

  submit() {
    const datos = {
      nombre: this.nombre,
      email: this.email,
      password: this.password
    };

    this.usuarioService.registrarUsuario(datos).subscribe({
      next: (resp: string) => {
        alert(resp);
      },
      error: (err: any) => {
        console.error(err);
        alert('Error al registrar usuario');
      }
    });
  }
}
