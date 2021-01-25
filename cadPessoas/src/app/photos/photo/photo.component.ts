import { Component, Input } from '@angular/core';

@Component({
    selector: 'ap-photo',
    templateUrl: 'photo.component.html'
})
export class PhotoComponent{
    @Input() url ='https://findicons.com/files/icons/1008/quiet/256/information.png';   
    @Input() description = 'informationIcon';  
}