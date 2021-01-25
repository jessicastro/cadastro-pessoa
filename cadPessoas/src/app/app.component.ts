import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {  

 dadosPessoa: Object[] = [];

 constructor(http:HttpClient) {
   
  http
    .get<Object[]>('http://localhost:8080/consultaPessoaCpf')
    .subscribe(dadosPessoa => {
      console.log(dadosPessoa)
      this.dadosPessoa = dadosPessoa
    });

 }

}
