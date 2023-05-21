import { AuthService } from './auth.service';
import { Usuario } from './usuario';
import { FormGroup } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  title = 'frontend';

  loginForm: FormGroup;

  usuario: Usuario = new Usuario();

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
    this.createForm();
  }

  createForm() {
  }

  onKeepSigned() {

  }

  onSubmit() {
    this.authService.fazerLogin(this.usuario);
  }

}
