import {Injectable} from "@angular/core";
import {HttpClient, HttpEvent, HttpHeaders, HttpRequest} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Charity} from "../models/Charity";

@Injectable()
export class CharityService {
  constructor(private httpClient: HttpClient) {
  }

  apiBaseUrl = environment.apiBaseUrl;

  getCharity(id: number): Observable<Charity> {
    return this.httpClient.get<Charity>(`${this.apiBaseUrl}/charity/${id}`);
  }

  updateCharity(id: number, charity: Charity): Observable<Charity> {
    return this.httpClient.put<Charity>(`${this.apiBaseUrl}/charity/${id}`, charity);
  }

  deleteCharity(id: number): Observable<Charity> {
    let headers = new HttpHeaders();

    const token = localStorage.getItem("token");
    headers = headers.append("Authorization", `Bearer ${token}`);
    return this.httpClient.delete<Charity>(`${this.apiBaseUrl}/charity/${id}`, {headers});
  }

  getAll(): Observable<Charity[]> {
    return this.httpClient.get<Charity[]>(`${this.apiBaseUrl}/charity`);
  }
}
