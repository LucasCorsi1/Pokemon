import { Component, OnInit } from '@angular/core';
import { Treinador } from '../treinador';
import { treinadorService, treinador } from '../treinadorService';
import { PokemonService, pokemon } from '../pokemonservice';

@Component({
  selector: 'app-treinador',
  templateUrl: './treinador.component.html',
  styleUrls: ['./treinador.component.css']
})
export class TreinadorComponent implements OnInit {

  treinador: Treinador[];
  selectedTreinador: Treinador;
  isHidden = false;

  constructor(private treinaservice: treinadorService, private pokemonservice: PokemonService) { }

  ngOnInit() {
    this.getTreinadores();
  }

  onSelect(treinador: Treinador): void {
    this.selectedTreinador = treinador;
    this.isHidden = true;
  }

  hidennList(): void {
    
  }

  add(name: string): void {
    this.treinaservice.PostTreinador({ name } as treinador).subscribe();
    this.getTreinadores();
  }

  getTreinadores(): void {
    this.treinaservice.getAllTreinador().subscribe(treinador => this.treinador = treinador);
  }

  save(name: string): void {
    this.treinaservice.updateTreinador(this.selectedTreinador.id, { name } as treinador).subscribe();
    this.getTreinadores();
  }

  delete(treinador: treinador): void {
    this.treinador = this.treinador.filter(h => h !== treinador);
    this.treinaservice.deleteTreinador(this.selectedTreinador.id).subscribe();
    this.getTreinadores();
  }
  addPokemon(name: string) {
    this.pokemonservice.PostPokemon({ name } as pokemon, this.selectedTreinador.id).subscribe();
    this.getTreinadores();
  }
}