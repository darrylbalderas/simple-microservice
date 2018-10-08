import { HttpHeaders } from '@angular/common/http';

export class Service {
  public static SERVER_URL_PREFIX = 'http://localhost:8080/';

  public static getHeaderWithJsonContentType() {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });
    return headers;
  }
}