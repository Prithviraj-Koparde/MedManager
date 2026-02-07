import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { authService } from '../auth.service';

@Component({
  selector: 'app-doc-login',
  imports: [FormsModule,],
  templateUrl: './doc-login.component.html',
  styleUrl: './doc-login.component.css'
})
export class DocLoginComponent {
  constructor(private router: Router, private docAuth: authService) { }

  username: string = ""
  password: string = ""
  inValidLogin = false


  onSubmit() {
  }

  checkLogin() {
    if (this.docAuth.docAuthenticate(this.username, this.password)) {
      this.router.navigate(['doc-dash'])
      this.inValidLogin = false
    } else {
      this.inValidLogin = true
      alert("Wrong Credentials!")
      this.router.navigate(['home-page'])
    }
  }
}
