import { Component, OnInit } from '@angular/core';
import { Http, Response} from '@angular/http';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs'; //Observable from rxjs library
import {Book} from './models/Book'
import { BookService } from './service/book-service';

@Component({
  selector: 'app-root',
  template: `
   <ng-container *ngFor="let book of books">
   {{book.id}}
   {{book.title}}
   {{book.Author}}
   </ng-container>
  `,
  styles: ['./app.component.css']
})
export class AppComponent implements OnInit{
  books: Book[];

  constructor(private bookservice: BookService) {
    
  }

  ngOnInit() {
    this.getBookList();
  }

  getBookList() {
    this.bookservice.getBookList().subscribe(
      res => {
        this.books = res;
      },
      error => {
        console.log(error);
      }
    )
  }
}

