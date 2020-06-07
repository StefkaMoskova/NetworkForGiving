import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from "../services/authentication.service";
import {Login} from "../models/Login";
import {Token} from "../models/Token";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  public username: string;
  public password: string;

  constructor(private authenticationService: AuthenticationService,
              private router: Router) {
  }

  ngOnInit(): void {
  }

  public login() {
    const user: Login = {
      username: this.username,
      password: this.password
    }

    const loginResponse = this.authenticationService.login(user);
    loginResponse.subscribe((response: Token) => {
      if (response && response.token) {
        this.router.navigate(['/home-page']);
      }
    })
  }
}
