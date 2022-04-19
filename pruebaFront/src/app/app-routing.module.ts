import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TarjetasComponent } from './pages/tarjetas/tarjetas.component';
import { TransaccionesComponent } from './pages/transacciones/transacciones.component';

const routes: Routes = [
  {
    path: '',
    component: TarjetasComponent
  },
  {
    path: 'transacciones',
    component: TransaccionesComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
