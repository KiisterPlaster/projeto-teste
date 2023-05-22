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
    ) { }

  ngOnInit(): void {
    this.createForm();
  }

  createForm() {
  }

  onKeepSigned() {

  }

  onSubmit() {
    this.authService.fazerLogin(this.usuarioLogin);
  }

}
