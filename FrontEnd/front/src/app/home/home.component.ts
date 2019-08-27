import { Component, OnInit } from '@angular/core';
import { UploadService } from '../services/upload.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers: [UploadService]
})
export class HomeComponent implements OnInit {

  public videoFile;

  constructor(private uploadService : UploadService) { }

  ngOnInit() {
  }

  public preparaUpload(event: Event) :void {
    console.log("Prepara Upload");
    this.videoFile = (<HTMLInputElement>event.target).files;
    console.log("File: " , this.videoFile[0]);
  }

  public enviar(){
    console.log("Chegamos até o envio");
    console.log("Arquivo sendo enviado ao service: ", this.videoFile[0]);
    this.uploadService.upload(this.videoFile[0])
      .subscribe((retorno) => {
        return retorno;
      })
  }

}
