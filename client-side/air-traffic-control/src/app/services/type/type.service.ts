import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Type } from '@angular/compiler';

@Injectable({
  providedIn: 'root'
})
export class TypeService {

  url = `${environment.context}/type`;

  constructor(private http: HttpClient) { }

  /**
   * Take a new Type object and submit it via a POST request
   *
   * @param newType
   */
  save(newType: Type) {
      return this.http.post(`${this.url}`, newType);
  }

  /**
   * Take a param and an identifier such as an id to make a GET request to retrieve a single Type.
   *
   * @param identifier
   * @param param
   */
  get(identifier: string, param: string): any {
    return this.http.get(`${this.url}/${identifier}/${param}`);
  }

  /**
   * Make a GET request to retirve all Type
   */
  getAll() {
    return this.http.get(`${this.url}`);
  }

  /**
   *  Take a param and an identifier such as an id to make a DELETE request to remove a single Type
   *
   * @param identifier
   * @param param
   */
  delete(identifier: string, param: string) {
    return this.http.delete(`${this.url}/${identifier}/${param}`);
  }

}
