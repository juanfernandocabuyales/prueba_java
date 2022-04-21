import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';

import { RespuestaConsultarTarjetas, Tarjeta } from '../../models/clases';
import { TarjetaService } from '../../services/tarjeta.service';
import { Constantes } from '../../models/constantes';
import { SwalUtils } from '../../utils/swalUtils';

@Component({
  selector: 'app-tarjetas',
  templateUrl: './tarjetas.component.html',
  styleUrls: ['./tarjetas.component.css']
})
export class TarjetasComponent implements OnInit {

  tarjetasList: Tarjeta[] = [];

  constructor(private tarjetaService: TarjetaService,private router: Router) { 
  }

  ngOnInit(): void {
    this.cargarInformacion();
  }

  cargarInformacion(): void {
    this.tarjetaService.consultarTarjetas().subscribe(( resp:RespuestaConsultarTarjetas ) => {
      if(resp.codigoRespuesta === Constantes.CODIGO_RESPUESTA_CERO ){
        this.tarjetasList = resp.listTarjetasDto;
      }else{
        SwalUtils.showAlert('Información',resp.mensaje,'warning');
      }
    }, () => {
      SwalUtils.showAlert(
        'Error',
        'Se ha presentado un unconveniente al realizar la operación',
        'error'
      );
    });
  }

  navegarPagina(): void {
    this.router.navigate(['transacciones']);
  }

}
