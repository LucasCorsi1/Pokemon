import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { TreinadorComponent } from './treinador/treinador.component';
import { FormsModule } from '@angular/forms'; // <-- NgModel lives here
import { treinadorService } from './treinadorService';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { PokemonService } from './pokemonservice';


@NgModule({
  declarations: [
    AppComponent,
    TreinadorComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [ treinadorService , PokemonService],
  bootstrap: [AppComponent]
})
export class AppModule { }
