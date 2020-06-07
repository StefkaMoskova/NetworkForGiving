import {Component, OnInit} from '@angular/core';
import {Register} from "../models/Register";
import {AuthenticationService} from "../services/authentication.service";
import {Router} from "@angular/router";
import {User} from "../models/User";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {
  public username: string;
  public password: string;
  public name: string;
  public age: number;
  public gender: string;
  public location: string;

  constructor(private authenticationService: AuthenticationService,
              private router: Router) {
  }

  ngOnInit(): void {
  }

  public register() {
    const user: Register = {
      username: this.username,
      password: this.password,
      name: this.name,
      age: this.age,
      gender: this.gender,
      location: this.location
    }

    const registerResponse = this.authenticationService.register(user);

    registerResponse.subscribe((response: User) => {
      if (response && response.id) {
        this.router.navigate(['/login']);
      }
    })
  }

}
