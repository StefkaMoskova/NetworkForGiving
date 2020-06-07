import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {ClarityModule} from '@clr/angular';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FormsModule} from "@angular/forms";
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {HomePageComponent} from './home-page/home-page.component';
import {AuthenticationService} from "./services/authentication.service";
import {HttpClientModule} from "@angular/common/http";
import {CharityPageComponent} from './charity-page/charity-page.component';
import {CreateCharityPageComponent} from './create-charity-page/create-charity-page.component';
import {CharityService} from "./services/charity.service";
import {HeaderComponent} from './header/header.component';
import {ListCharitiesComponent} from './list-charities/list-charities.component';
import {EditCharityPageComponent} from './edit-charity-page/edit-charity-page.component';
import {FooterComponent} from './footer/footer.component';
import {Ng2SearchPipeModule} from 'ng2-search-filter';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomePageComponent,
    CharityPageComponent,
    CreateCharityPageComponent,
    HeaderComponent,
    ListCharitiesComponent,
    EditCharityPageComponent,
    FooterComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ClarityModule,
    HttpClientModule,
    BrowserAnimationsModule,
    FormsModule,
    Ng2SearchPipeModule
  ],
  providers: [AuthenticationService, CharityService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
