import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Size } from 'src/app/beans/Size/size';

@Injectable({
  providedIn: 'root'
})
export class SizeService {

  url = `${environment.context}/size`;

  constructor(private http: HttpClient) { }

  /**
   * Take a new Size object and submit it via a POST request
   *
   * @param newSize
   */
  save(newSize: Size) {
      return this.http.post(`${this.url}`, newSize);
  }

  /**
   * Take a param and an identifier such as an id to make a GET request to retrieve a single Size.
   *
   * @param identifier
   * @param param
   */
  get(identifier: string, param: string): any {
    return this.http.get(`${this.url}/${identifier}/${param}`);
  }

  /**
   * Make a GET request to retirve all Size
   */
  getAll() {
    return this.http.get(`${this.url}`);
  }

  /**
   *  Take a param and an identifier such as an id to make a DELETE request to remove a single Size
   *
   * @param identifier
   * @param param
   */
  delete(identifier: string, param: string) {
    return this.http.delete(`${this.url}/${identifier}/${param}`);
  }

}
