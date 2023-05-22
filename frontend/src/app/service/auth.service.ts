import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { UsuarioLogin } from './../model/usuarioLogin';
import { Usuario } from './../model/usuario';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { EventEmitter } from '@angular/core';
import { environment } from 'src/environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private usuarioAutenticado: boolean = false;

  mostrarMenuEmitter = new EventEmitter<boolean>();

  constructor(
      private http: HttpClient,
      private router: Router) { }

  fazerLogin(usuario: Usuario) {
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

  entrar(usuarioLogin: UsuarioLogin): Observable<UsuarioLogin>
  {
    return this.http.post<UsuarioLogin>('https://localhost:8081/server/usuarios/logar', usuarioLogin)
  }

  usuarioEstaAutenticado() {
    return this.usuarioAutenticado;
  }

  // logado()
  // {
  //   let ok: boolean = false
  //   if (environment.token != '')
  //   {
  //     ok = true
  //   }
  //   return ok
  // }

}
