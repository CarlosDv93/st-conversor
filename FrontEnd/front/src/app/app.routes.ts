import { Routes } from '@angular/router'
import { HomeComponent } from './home/home.component';
import { VideoComponent } from './video/video.component';

export const ROUTES: Routes = [
    {path: '', component: HomeComponent},
    {path: 'assistir' , component: VideoComponent}
]