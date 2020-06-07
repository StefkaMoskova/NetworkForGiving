import {Component, OnInit} from '@angular/core';
import {CharityService} from "../services/charity.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Charity} from "../models/Charity";
import {HttpResponse} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {UploadFileService} from "../services/fileUpload.service";

@Component({
  selector: 'app-edit-charity-page',
  templateUrl: './edit-charity-page.component.html',
  styleUrls: ['./edit-charity-page.component.css']
})

export class EditCharityPageComponent implements OnInit {
  public id: number;
  public title: string;
  public image: string;
  public description: string;
  public amountRequired: number;
  public amountCollected: number;
  public volunteersRequired: number;

  public charity: Charity;

  public charityFilePath: string;
  public getFiles: FileList;
  public currentFileUpload: File;

  apiBaseUrl = environment.apiBaseUrl;

  constructor(private route: ActivatedRoute, private charityService: CharityService, private router: Router,
              private uploadService: UploadFileService) {
  }

  ngOnInit(): void {
    this.charity = new Charity();

    this.id = this.route.snapshot.params['id'];

    this.charityService.getCharity(this.id).subscribe(data => {
      console.log(data);

      this.charity = data;
      this.title = this.charity.title;
      this.image = this.charity.image;
      this.description = this.charity.description;
      this.amountRequired = this.charity.amountRequired;
      this.amountCollected = this.charity.amountCollected;
      this.volunteersRequired = this.charity.volunteersRequired;
    }, error => console.log(error));
  }

  public edit() {
    this.charityService.updateCharity(this.charity.id, this.charity).subscribe(x => {
        console.log(x);
        this.router.navigate(['/home-page']);
      }
    );
  }
}


