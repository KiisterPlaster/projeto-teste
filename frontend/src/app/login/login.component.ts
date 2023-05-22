import { AlertasService } from './../service/alertas.service';
import { UsuarioLogin } from './../model/usuarioLogin';
import { AuthService } from './../service/auth.service';
import { Router } from '@angular/router';
import { FormGroup } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment.prod';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  title = 'frontend';

  loginForm: FormGroup;

  usuarioLogin: UsuarioLogin = new UsuarioLogin();

  constructor(
    private authService: AuthService,
    private router: Router,
    private alertas: AlertasService
    ) { }

  ngOnInit(): void {
    this.createForm();
  }

  createForm() {
  }

  onKeepSigned() {

  }

  onSubmit() {
    this.authService.entrar(this.usuarioLogin).subscribe((resp: UsuarioLogin) => {
      this.usuarioLogin = resp

    // environment.token = this.usuarioLogin.token
    environment.email = this.usuarioLogin.email
    environment.id = this.usuarioLogin.id

    console.log(environment.email)
    console.log(environment.id)


    this.router.navigate(['/inicio'])

  }, erro=>{
    if(erro.status >= 400){
      this.alertas.showAlertDanger('Usuário ou senha estão incorretos!')
    }
    });
  }

}
