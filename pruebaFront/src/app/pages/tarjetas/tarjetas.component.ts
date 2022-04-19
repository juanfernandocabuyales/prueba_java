import { Component, OnInit } from '@angular/core';
import { Tarjeta } from '../../models/interfaces';

@Component({
  selector: 'app-tarjetas',
  templateUrl: './tarjetas.component.html',
  styleUrls: ['./tarjetas.component.css']
})
export class TarjetasComponent implements OnInit {

  tarjetasList: Tarjeta[] = [];

  tarjetasSeleccionadas: Tarjeta[] = [];

  constructor() { }

  ngOnInit(): void {
  }

}
