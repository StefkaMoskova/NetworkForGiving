import {Component, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute, NavigationEnd, Router} from "@angular/router";
import {CharityService} from "../services/charity.service";
import {Charity} from "../models/Charity";
import {HttpClient, HttpEventType, HttpRequest, HttpResponse} from "@angular/common/http";
import {UploadFileService} from "../services/fileUpload.service";
import {environment} from "../../environments/environment";

@Component({
  selector: 'app-create-charity-page',
  templateUrl: './create-charity-page.component.html',
  styleUrls: ['./create-charity-page.component.css']
})

export class CreateCharityPageComponent implements OnInit {
  public id: number;
  public title: string;
  public image: string;
  public description: string;
  public amountRequired: number;
  public amountCollected: number;
  public volunteersRequired: number;

  @ViewChild('fileInput') fileInput;

  public charityFilePath: string;
  public getFiles: FileList;
  public currentFileUpload: File;
  progress: { percentage: number } = {percentage: 0}

  apiBaseUrl = environment.apiBaseUrl;

  constructor(private charityService: CharityService, private router: Router, private route: ActivatedRoute,
              private httpClient: HttpClient, private uploadService: UploadFileService) {
    this.router.routeReuseStrategy.shouldReuseRoute = function() {
      return false;
    };

    this.router.events.subscribe((evt) => {
      if (evt instanceof NavigationEnd) {
        this.router.navigated = false;
        window.scrollTo(0, 0);
      }
    });
  }

  ngOnInit() {
  }

  public create() {
    let charity: Charity = new Charity();

    charity.title = this.title;
    charity.image = this.charityFilePath;
    charity.description = this.description;
    charity.amountRequired = this.amountRequired;
    charity.amountCollected = this.amountCollected;
    charity.volunteersRequired = this.volunteersRequired;

    const createResponse = new HttpRequest('POST', 'http://localhost:8080/charity/', charity);

    this.httpClient.request(createResponse).subscribe(x => {
      console.log(createResponse);
      this.router.navigate(['/home-page']);
    })
  }

  getFile(event) {
    let file = event.target.files.item(0);

    if (file.type.match('image.*')) {
      this.getFiles = event.target.files;
    }
  }

  fileUpload() {
    this.progress.percentage = 0;
    this.currentFileUpload = this.getFiles.item(0);
    this.uploadService.pushFile(this.currentFileUpload).subscribe(event => {
      console.log(event);
      if (event.type === HttpEventType.UploadProgress) {
        this.progress.percentage = Math.round(100 * event.loaded / event.total);
      } else if (event instanceof HttpResponse) {
        this.charityFilePath = new String(event.body).valueOf();
        this.charityFilePath = this.apiBaseUrl + "/" + this.charityFilePath;
      }
    })

    this.getFiles = undefined;
  }
}
