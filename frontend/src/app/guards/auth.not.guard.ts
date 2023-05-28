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
      if (this.authService.logado) {
        return true;
      }
      this.router.navigate(['login']);
      return false;
    }
}
