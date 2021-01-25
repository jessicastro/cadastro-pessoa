import { NgModule } from "@angular/core";
import { PessoaComponent  } from "./pessoa/pessoa.component";

@NgModule({
    declarations: [PessoaComponent],
    exports: [ PessoaComponent ]
})
export class CadastrosModule{

}