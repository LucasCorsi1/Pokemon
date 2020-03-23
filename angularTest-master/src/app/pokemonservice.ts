import { Injectable } from '@angular/core'
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http'


export interface pokemon {
    id: number;
    name: string;
    level:number;
    power:number;
}

@Injectable()
export class PokemonService {
    constructor(private http: HttpClient) { }

    PostPokemon(Pokemon: pokemon, id:number): Observable<pokemon> {
        return this.http.post<pokemon>('http://localhost:8080/pokemon/'+id, Pokemon)
    }

    getAllpokemon(): Observable<pokemon[]> {
        return this.http.get<pokemon[]>('http://localhost:8080/pokemon/')
    }

}