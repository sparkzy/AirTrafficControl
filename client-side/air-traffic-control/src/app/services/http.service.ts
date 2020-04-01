import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  private url = environment.context; // ex: aircraft

  constructor(private http: HttpClient) { }

  /**
   * Getter $url
   * @return {string}
   */
  public get $url(): string {
    return this.url;
  }

  /**
   * Setter $url
   * @param {string} value
   */
  public set $url(value: string) {
    this.url = environment.context + value;
  }

  /**
   * Take a param and an identifier such as an id to retrieve a single object.
   *
   * @param requestObj
   * @param requestParam
   */
  get(identifier: string, param: string): any {
    return this.http.get(`${this.url}/${identifier}/${param}`)
      .subscribe(
        (succ: any) => {
          console.log(succ);
        },
        (err) => {
          alert(`Failed to retrieve an object for url ${this.url}/${param}.`);
        }
      );
  }

  getAll(): Observable<any> {
    this.http.get(`${this.url}`)
      .subscribe(
        (succ: any) => {
          console.log(succ);
        }
      );
    return this.http.get(`${this.url}`);
  }

  /**
   * Take an object and use its class name in lower case to reached the related controller.
   * Send that object to the server to have it saved in the database.
   *
   * @param obj
   */
  post(obj: any) {
    return this.http.post(`${environment.context}/${obj.constructor.name.toLowerCase()}`, obj)
      .subscribe(
        (succ: any) => {

        },
        (err) => {
          alert(`Failed to create a ${obj.constructor.name.toLowerCase()}.`);
        }
      );
  }

  /**
   * Take a param as an identifier such as an id to delete a single object.
   *
   * @param param
   */
  delete(identifier: string, param: string) {
    return this.http.delete(`${this.url}/${identifier}/${param}`)
      .subscribe(
        (succ: any) => {

        },
        (err) => {
          alert(`Failed to delete object with identifier ${param} related to url ${this.url}`);
        }
      );
  }
}
