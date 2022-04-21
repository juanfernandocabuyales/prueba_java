import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';


import { Transaccion } from 'src/app/models/clases';
import { TransaccionService } from '../../services/transaccion.service';
import { RespuestaConsultarTransacciones } from '../../models/clases';
import { Constantes } from 'src/app/models/constantes';
import { SwalUtils } from 'src/app/utils/swalUtils';

@Component({
  selector: 'app-transacciones',
  templateUrl: './transacciones.component.html',
  styleUrls: ['./transacciones.component.css']
})
export class TransaccionesComponent implements OnInit {

  transaccionList: Transaccion[] = [];

  constructor(private transaccionService: TransaccionService,private router: Router) { }

  ngOnInit(): void {
    this.cargarInformacion();
  }

  cargarInformacion(): void {
    this.transaccionService.consultarTarjetas().subscribe(( resp: RespuestaConsultarTransacciones ) => {
      if(resp.codigoRespuesta === Constantes.CODIGO_RESPUESTA_CERO ){
        this.transaccionList = resp.transaccionesList;
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
    this.router.navigate(['']);
  }

}
