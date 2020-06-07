import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {CharityService} from "../services/charity.service";
import {Observable} from "rxjs";
import {Charity} from "../models/Charity";

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})

export class HomePageComponent implements OnInit {
  charities: Observable<Charity[]>;

  constructor(private charityService: CharityService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.charities = this.charityService.getAll();
  }
}
