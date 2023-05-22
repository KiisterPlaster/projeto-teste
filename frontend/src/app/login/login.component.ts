import { UsuarioLogin } from './../model/usuarioLogin';
import { AuthService } from './../service/auth.service';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Token } from '@angular/compiler';

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
    private formBilder: FormBuilder,
    private router: Router,
    private authService: AuthService,
    ) { }

  ngOnInit(): void {
    this.loginForm = this.formBilder.group({
      email: ['', [Validators.required, Validators.email]],
      senha: ['', [Validators.required]]
    });
  }

  onSubmit() {
    var dadosLogin = this.loginForm.getRawValue() as UsuarioLogin;
    this.authService.LoginUsuario(dadosLogin).subscribe(token => {
      var nossoToken = Token;
    },
    erro => {
      //
    }
    )
  }

}
