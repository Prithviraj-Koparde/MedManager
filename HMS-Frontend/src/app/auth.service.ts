import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class authService {

  constructor() { }

  docAuthenticate(username: string, password: string) {
    if (username == "prithvi" && password == "1234") {
      sessionStorage.setItem('username', username)
      return true
    } else {
      return false
    }
  }

  adminAuthenticate(username: string, password: string) {
    if (username == "admin" && password == "1234") {
      sessionStorage.setItem('username', username)
      return true
    } else {
      return false
    }
  }

  isUserLoggedIn(){
    console.log("User logged in successfully!")
    let user = sessionStorage.getItem('username')

    return !(user==null)
  }

  logOut(){
    console.log("User logged out")
    sessionStorage.removeItem('username')
  }
}
