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
    if (this.authService.logado) {
      return true;
    }
    this.router.navigate(['']);
    return false;
  }

  // canActivate(
  //     route: ActivatedRouteSnapshot,
  //     state: RouterStateSnapshot): boolean | Observable<boolean> {

  //       if (this.authService.usuarioEstaAutenticado()) {
  //         return true;
  //       }

  //       this.router.navigate(['/home']);

  //       return false;
  // }
}
