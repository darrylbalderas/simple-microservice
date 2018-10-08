import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Book } from '../models/Book';
import { Service } from './service-util';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  url: string = Service.SERVER_URL_PREFIX + 'books';

  constructor(private http: HttpClient) {}

  getBookList() {
    return this.http.get<Book[]>(this.url);
  }
}