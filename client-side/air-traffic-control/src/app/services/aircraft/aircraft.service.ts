import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Aircraft } from 'src/app/beans/Aircraft/aircraft';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AircraftService {

  url = `${environment.context}/aircraft`;
  httpOptions = {
    headers: new HttpHeaders(
      {
        Accept: 'application/json',
        'Content-Type': 'application/json'
      }
    )
  };

  constructor(private http: HttpClient) { }

  /**
   * Take a new Aircraft object and submit it via a POST request
   *
   * @param newAC
   */
  save(newAC: Aircraft) {
      return this.http.post(`${this.url}`, newAC);
  }

  /**
   * Take a param and an identifier such as an id to make a GET request to retrieve a single Aircraft.
   *
   * @param identifier
   * @param param
   */
  get(identifier: string, param: string): any {
    return this.http.get(`${this.url}/${identifier}/${param}`);
  }

  /**
   * Make a GET request to retirve all Aircraft
   */
  getAll(): Observable<object> {
    return this.http.get(`${this.url}`);
  }

  /**
   *  Take a param and an identifier such as an id to make a DELETE request to remove a single Aircraft
   *
   * @param identifier
   * @param param
   */
  delete(identifier: string, param: string) {
    return this.http.delete(`${this.url}/${identifier}/${param}`);
  }

}
