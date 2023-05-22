import { HttpClient } from '@angular/common/http';
import { UsuarioLogin } from './../model/usuarioLogin';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { EventEmitter } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private readonly baseURL = environment['endPoint'];

  private usuarioAutenticado: boolean = false;

  mostrarMenuEmitter = new EventEmitter<boolean>();

  constructor(
      private http: HttpClient,
      private router: Router) { }

  LoginUsuario(objeto:any) {
    return this.http.post<any>(`${this.baseURL}/CriarTokenIndentity`, objeto);
  }

  fazerLogin(usuario: UsuarioLogin) {
    if (usuario.email === 'usuario@email.com' &&
      usuario.senha === '123456') {

        this.usuarioAutenticado = true;

        this.mostrarMenuEmitter.emit(true);

        this.router.navigateByUrl("/home")
      } else {
        this.usuarioAutenticado = false;

        this.mostrarMenuEmitter.emit(false);
      }
  }



  usuarioEstaAutenticado() {
    return this.usuarioAutenticado;
  }

}
