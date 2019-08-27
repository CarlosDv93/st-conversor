import { Injectable } from "@angular/core";
import { environment } from 'src/environments/environment';
import { HttpClientModule, HttpClient, HttpResponse, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class UploadService {

    private url = environment.url_api;
    public retorno: any;

    private options = {
        headers: new HttpHeaders().set("Content-Type", "multipart/form-data")
    }

    constructor(private httpClientModule: HttpClientModule,
        private http: HttpClient) {

    }



    public uploadVideo(video: any): Observable<Object> {
        this.http.post(`${this.url}/upload`, { file: video }, this.options)
            .subscribe((retorno) => {
                console.log("Retorno Upload: ", retorno);
                return this.retorno = retorno;
            },
                (error) => {
                    console.log("Erro ao fazer upload: ", error);
                    return this.retorno = error;
                })

        return this.retorno;
    }

    public upload(video: any) : Observable<any> {
        let fileUploadForm: FormData = new FormData();
        fileUploadForm.append("file", video);
        this.http
            .post(`${this.url}/upload`, fileUploadForm)
            .subscribe(retorno => {
                //handle response
                console.log("Retorno Upload: ", retorno);
                return this.retorno = retorno;
            }, error => {
                //handle error
                console.log("Erro ao fazer upload: ", error);
                return this.retorno = error;
            });
        return this.retorno;
    }

}