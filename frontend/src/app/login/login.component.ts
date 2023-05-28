import { UsuarioLogin } from './../model/usuarioLogin';
import { AuthService } from './../service/auth.service';
import { Router } from '@angular/router';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
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
    this.loginForm = new FormGroup({
      email: new FormControl(''),
      senha: new FormControl('')
    });
  }

  onSubmit() {
    var dadosLogin = this.loginForm.getRawValue() as UsuarioLogin;
    console.log(dadosLogin)
    this.authService.loginUsuario(dadosLogin).subscribe(token => {
      var nossoToken = Token;
    },
    erro => {
      //
    }
    )
  }

}
