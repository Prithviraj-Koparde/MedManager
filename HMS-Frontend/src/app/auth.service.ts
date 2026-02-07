import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class authService {

  constructor() { }

  docAuthenticate(username: string, password: string) {
    if (username == "prithvi" && password == "1234") {
      sessionStorage.setItem(username, password)
      return true
    } else {
      return false
    }
  }

  adminAuthenticate(username: string, password: string) {
    if (username == "admin" && password == "1234") {
      sessionStorage.setItem(username, password)
      return true
    } else {
      return false
    }
  }
}
