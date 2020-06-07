import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {CharityService} from "../services/charity.service";
import {Charity} from "../models/Charity";
import {AuthenticationService} from "../services/authentication.service";

@Component({
  selector: 'app-charity-page',
  templateUrl: './charity-page.component.html',
  styleUrls: ['./charity-page.component.css']
})

export class CharityPageComponent implements OnInit {

  public id: number;
  public charity: Charity;

  public donateModalOpened = false;
  public donationAmount: number;

  public volunteerModalOpened = false;
  public volunteerName: string;


  constructor(private route: ActivatedRoute, private router: Router,
              private charityService: CharityService, private authenticationService: AuthenticationService) {
  }

  public get isAuthenticated(): boolean {
    return this.authenticationService.isAuthenticated();
  }

  ngOnInit() {
    this.charity = new Charity();

    this.id = this.route.snapshot.params['id'];

    this.charityService.getCharity(this.id)
      .subscribe(data => {
        console.log(data)
        this.charity = data;
      }, error => console.log(error));
  }

  public closeDonateModal() {
    this.donateModalOpened = false;
  }

  public closeVolunteerModal() {
    this.volunteerModalOpened = false;
  }

  public donate() {
    this.donateModalOpened = true;
  }

  public volunteer() {
    this.volunteerModalOpened = true;
  }

  public sum(x, y): number {
    return (x * 1 + y * 1);
  }

  public edit() {
    this.charity.amountCollected = this.sum(this.charity.amountCollected, this.donationAmount);
    this.charityService.updateCharity(this.charity.id, this.charity).subscribe(x => {
      console.log(x);
      this.closeDonateModal();
    });
  }

  public volunteerConfirmed() {

  }
}
