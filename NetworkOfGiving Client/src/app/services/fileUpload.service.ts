import {Injectable} from '@angular/core';
import {HttpClient, HttpRequest, HttpEvent} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UploadFileService {

  constructor(private httpClient: HttpClient) {
  }

  pushFile(file: File): Observable<HttpEvent<{}>> {
    let formdata: FormData = new FormData();

    // add a field with the given name and value
    formdata.append('file', file);

    const httpRequest = new HttpRequest('POST', 'http://localhost:8080/fileUpload', formdata, {
      reportProgress: true,
      responseType: 'text'
    });

    return this.httpClient.request(httpRequest);
  }
}
