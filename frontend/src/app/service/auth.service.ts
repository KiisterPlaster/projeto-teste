import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { tap } from 'rxjs/operators';
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

  loginUsuario(usuarioLogin:UsuarioLogin): Observable<UsuarioLogin> {
    return this.http.post<any>(`${this.baseURL}`, usuarioLogin);

  }

  deslogar() {
    localStorage.clear();
    this.router.navigate(['login']);
}
get obterUsuarioLogado(): UsuarioLogin {
  return localStorage.getItem('usuario')
    ? JSON.parse(atob(localStorage.getItem('usuario')))
    : null;
}
get obterIdUsuarioLogado(): string {
  return localStorage.getItem('usuario')
    ? (JSON.parse(atob(localStorage.getItem('usuario'))) as UsuarioLogin).id
    : null;
}
get obterTokenUsuario(): string {
  return localStorage.getItem('token')
    ? JSON.parse(atob(localStorage.getItem('token')))
    : null;
}
get logado(): boolean {
  return localStorage.getItem('token') ? true : false;
}

  // fazerLogin(usuario: UsuarioLogin) {
  //   if (usuario.email === 'usuario@email.com' &&
  //     usuario.senha === '123456') {

  //       this.usuarioAutenticado = true;

  //       this.mostrarMenuEmitter.emit(true);

  //       this.router.navigateByUrl("/home")
  //     } else {
  //       this.usuarioAutenticado = false;

  //       this.mostrarMenuEmitter.emit(false);
  //     }
  // }



  // usuarioEstaAutenticado() {
  //   return this.usuarioAutenticado;
  // }

}
