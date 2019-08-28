import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { VideoComponent } from './video/video.component';
import { RouterModule } from '@angular/router';
import { ROUTES } from './app.routes';
import { UploadService } from './services/upload.service';
import { HttpClientModule } from '@angular/common/http';
import { DashjsPlayerModule } from 'angular-dashjs-player';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    VideoComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(ROUTES),
    HttpClientModule,
    DashjsPlayerModule
  ],
  providers: [
    UploadService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
