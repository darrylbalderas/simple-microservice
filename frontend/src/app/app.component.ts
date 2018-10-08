import { Component, OnInit } from '@angular/core';
import { Http, Response} from '@angular/http';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs'; //Observable from rxjs library
import {Book} from './models/Book'
import { BookService } from './service/book-service';

@Component({
  selector: 'app-root',
  template: `
  <div class="hero is-info is-fullheight">
    <div class=hero-head> 
      <div class="container has-text-centered">
        <h1 class="title"> Book Catalog </h1>
      </div>
    </div>
    <div class="hero-body">
        <div class="container"> 
        <div class="columns" *ngFor="let book of books"> 
          <div class="column">
            <div class="card">
              <header class="card-header">
                  <p class="card-header-title">
                  {{book.title}}
                  </p>
              </header>
              <div class="card-content">
                  <div class="content">
                    Created by {{book.author}}
                  </div>
              </div>
              <div class="card-content">
                  <div class="content">
                    Book id: {{book.id}}
                  </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
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

