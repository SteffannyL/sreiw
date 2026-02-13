import { Component } from '@angular/core';
import { ReactiveFormsModule, FormBuilder, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-event-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './event-form.html',
  styleUrl: './event-form.css'
})

export class EventForm {

  eventForm: any;

  constructor(private fb: FormBuilder) {

    this.eventForm = this.fb.group({
      nombre_evento: ['', Validators.required],
      descripcion: [''],
      fecha_inicio: ['', Validators.required],
      fecha_fin: ['', Validators.required],
      lugar: ['', Validators.required],
      aforo: [''],
      id_tipoevento: ['', Validators.required]
    });

  }

  submit() {
    console.log(this.eventForm.value);
    alert('Formulario enviado (solo UI)');
  }
}


