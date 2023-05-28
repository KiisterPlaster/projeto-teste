import { CanActivate, Router } from '@angular/router';
import { AuthService } from './../service/auth.service';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {



  constructor(private authService: AuthService, private router: Router) {

  }
  canActivate(){
    if (this.authService.loginUsuario) {
      return true;
    }
    this.router.navigate(['login']);
    return false;
  }

}
