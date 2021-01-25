import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http'

import { PhotosModule } from './photos/photos.module';
import { CadastrosModule } from './cadastros/cadastros.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    PhotosModule, 
    HttpClientModule,
    CadastrosModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }