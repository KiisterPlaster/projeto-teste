import { AuthService } from './../service/auth.service';
import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthNotGuard implements CanActivate{
    constructor(
      private authService: AuthService,
      private router: Router) { }
    canActivate(){
      if (this.authService.loginUsuario) {
        return true;
      }
      this.router.navigate(['']);
      return false;
    }
}
