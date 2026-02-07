import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { authService } from '../auth.service';

@Component({
  selector: 'app-admin-login',
  imports: [FormsModule],
  templateUrl: './admin-login.component.html',
  styleUrl: './admin-login.component.css'
})
export class AdminLoginComponent {
  constructor(private router: Router, private auth: authService) { }
  username: string = ""
  password: string = ""
  inValidLogin = false

  onSubmit() { }

  checkLogin() {
    if (this.auth.adminAuthenticate(this.username, this.password)) {
      this.router.navigate(['admin-dash'])
      this.inValidLogin = false
    } else {
      this.inValidLogin = true
      alert("Wrong Credentials!")
      this.router.navigate(['home-page'])
    }
  }
}
