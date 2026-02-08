import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, GuardResult, MaybeAsync, Router, RouterStateSnapshot } from '@angular/router';
import { authService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class AdminAuthGuardService implements CanActivate {

  constructor(private authService: authService, private router: Router) { }

  canActivate() {

    if (this.authService.isUserLoggedIn()) {

      return true

    } else {

      this.router.navigate(['admin-login'])
      return false
      
    }
  }
}
