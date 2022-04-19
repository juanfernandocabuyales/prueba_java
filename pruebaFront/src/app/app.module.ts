import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { PrimengModule } from './modulos/primeng.module';

import { TarjetasComponent } from './pages/tarjetas/tarjetas.component';
import { TransaccionesComponent } from './pages/transacciones/transacciones.component';

@NgModule({
  declarations: [
    AppComponent,
    TarjetasComponent,
    TransaccionesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    PrimengModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
