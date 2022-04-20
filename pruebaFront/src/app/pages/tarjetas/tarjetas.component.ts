import { Component, OnInit } from '@angular/core';
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

  tarjetasSeleccionadas: Tarjeta[] = [];

  loading: boolean = true;

  constructor(private tarjetaService: TarjetaService) { 
  }

  ngOnInit(): void {
    this.cargarInformacion();
  }

  cargarInformacion(): void {
    this.tarjetaService.consultarTarjetas().subscribe(( resp:RespuestaConsultarTarjetas ) => {
      this.loading = false;
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

}
