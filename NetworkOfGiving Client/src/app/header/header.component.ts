import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {AuthenticationService} from "../services/authentication.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public logoutModalOpened = false;

  constructor(private router: Router, private authenticationService: AuthenticationService) {
  }

  ngOnInit(): void {
  }

  public get isAuthenticated(): boolean {
    return this.authenticationService.isAuthenticated();
  }

  public get username(): string {
    return this.authenticationService.getUsername();
  }

  public logout(): void {
    this.logoutModalOpened = true;
  }

  public closeLogoutModal() {
    this.logoutModalOpened = false;
  }

  public logoutConfirmed() {
    this.authenticationService.logout();
    this.closeLogoutModal();
  }
}
