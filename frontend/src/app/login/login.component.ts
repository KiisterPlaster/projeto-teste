import { UsuarioLogin } from './../model/usuarioLogin';
import { AuthService } from './../service/auth.service';
import { Router } from '@angular/router';
import {  FormControl, FormGroup } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

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
    private router: Router,
    private authService: AuthService
    ) { }

  ngOnInit(): void {
    this.loginForm = new FormGroup({
      email: new FormControl(''),
      senha: new FormControl('')
    });
  }

  // onSubmit() {
  //  this.authService.loginUsuario(this.usuarioLogin).subscribe((resp: UsuarioLogin) => {
  //   this.usuarioLogin = resp

  //   this.router.navigate(['/home'])

  //  })
  // }

  onSubmit() {
    var dadosLogin = this.loginForm.getRawValue() as UsuarioLogin;
    this.authService.loginUsuario(dadosLogin).subscribe(resp => {
      this.router.navigate([''])
    },
    erro => {
      //
    }
    )
  }

}
