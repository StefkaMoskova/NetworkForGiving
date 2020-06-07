import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {AuthenticationService} from "../services/authentication.service";
import {Charity} from "../models/Charity";
import {CharityService} from "../services/charity.service";
import {Observable} from "rxjs";

@Component({
  selector: 'app-list-charities',
  templateUrl: './list-charities.component.html',
  styleUrls: ['./list-charities.component.css']
})
export class ListCharitiesComponent implements OnInit {

  constructor(private router: Router, private authenticationService: AuthenticationService,
              private charityService: CharityService) {
  }

  charities: Observable<Charity[]>;

  public searchText: string;
  public deleteModalOpened = false;


  ngOnInit(): void {
    this.charities = this.charityService.getAll();
  }

  public get isAuthenticated(): boolean {
    return this.authenticationService.isAuthenticated();
  }

  public get username(): string {
    return this.authenticationService.getUsername();
  }

  public closeDeleteModal() {
    this.deleteModalOpened = false;
  }

  reloadData() {
    this.charities = this.charityService.getAll();
  }

  deleteCharity(id: number) {
    this.charityService.deleteCharity(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  charityDetails(id: number) {
    this.router.navigate(['/charity-page', id]);
  }

  updateCharity(id: number, charity: Charity) {
    this.router.navigate(['/edit-charity-page', id]);
  }
}
