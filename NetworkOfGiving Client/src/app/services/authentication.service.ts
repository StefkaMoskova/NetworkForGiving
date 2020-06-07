import {Injectable} from "@angular/core";
import {Login} from "../models/Login";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Token} from "../models/Token";
import {JwtHelperService} from "@auth0/angular-jwt";
import {Register} from "../models/Register";

@Injectable()
export class AuthenticationService {
  constructor(private httpClient: HttpClient) {
  }

  apiBaseUrl = environment.apiBaseUrl;
  jwtHelper = new JwtHelperService();

  public login(user: Login) {
    const loginResponse = this.httpClient.post(`${this.apiBaseUrl}/authentication/login`, user);
    loginResponse.subscribe((response: Token) => {
      localStorage.setItem('token', response.token);
    });

    return loginResponse;
  }

  public logout(): void {
    localStorage.removeItem('token');
  }

  public isAuthenticated(): boolean {
    const token = localStorage.getItem('token');
    return !!token && !this.jwtHelper.isTokenExpired(token);
  }

  public register(user: Register) {
    return this.httpClient.post(`${this.apiBaseUrl}/authentication/register`, user);
  }

  public getUsername() {
    if (this.isAuthenticated()) {
      const token = localStorage.getItem('token');
      const payload = this.jwtHelper.decodeToken(token);
      return payload.username;
    }

    return '';
  }
}
