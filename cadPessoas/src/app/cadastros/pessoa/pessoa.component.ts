import { Component, Input } from '@angular/core';

@Component({
    selector: 'ap-pessoa',
    templateUrl: 'pessoa.component.html'
})
export class PessoaComponent{
    @Input() dados ='';   
    @Input() title = 'Lista (JSON) - PESSOA PRESENTE NO CADASTRO';   
}