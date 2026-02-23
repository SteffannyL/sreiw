import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { UsuarioService } from '../../services/usuario';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './register.html',
  styleUrl: './register.css'
})
export class Register {

  nombres = '';
  apellidos = '';
  correo = '';
  contrasena = '';

  constructor(private usuarioService: UsuarioService) {}

  submit() {
    const datos = {
      nombres: this.nombres,
      apellidos: this.apellidos,
      correo: this.correo,
      contrasena: this.contrasena
    };

    this.usuarioService.registrarUsuario(datos).subscribe({
      next: (resp: any) => {
        alert('Usuario registrado correctamente');
      },
      error: (err: any) => {
        console.error(err);
        alert('Error al registrar usuario');
      }
    });
  }
}
