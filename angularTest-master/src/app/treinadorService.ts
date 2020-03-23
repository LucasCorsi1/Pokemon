import { Injectable } from '@angular/core'
import { Observable } from 'rxjs';
import { Pokemon } from './pokemon';
import { HttpClient, HttpHeaders } from '@angular/common/http';

export interface treinador {
    name: string,
    id: number,
    pokemons: Pokemon[]
}

@Injectable()
export class treinadorService {
    constructor(private http: HttpClient) { }

    getAllTreinador(): Observable<treinador[]> {
        return this.http.get<treinador[]>('http://localhost:8080/train/')
    }

    getTreinador(id: number): Observable<treinador> {
        return this.http.get<treinador>('http://localhost:8080/train/' + id)
    }

    PostTreinador(treinador: treinador): Observable<treinador> {
        return this.http.post<treinador>('http://localhost:8080/train/', treinador)
    }

    updateTreinador(id: number, treinador: treinador): Observable<void> {
        return this.http.put<void>('http://localhost:8080/train/atualiza/'+id,treinador)
    }

    deleteTreinador(id: number) {
        return this.http.delete('http://localhost:8080/train/delete/' + id)
    }
}