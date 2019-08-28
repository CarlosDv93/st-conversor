import { Component, OnInit, ViewChild } from '@angular/core';
import { Player } from 'bitmovin-player';
import { DashjsPlayerComponent } from 'angular-dashjs-player';
import { MediaPlayerClass } from 'dashjs';


@Component({
  selector: 'app-video',
  templateUrl: './video.component.html',
  styleUrls: ['./video.component.css']
})
export class VideoComponent implements OnInit {

  @ViewChild('dashPlayer') dashPlayer: DashjsPlayerComponent;

  public player = {
    urlMpd : "https://st-bucket-carlosdv93.s3-sa-east-1.amazonaws.com/output/1e6ac3ab-a29c-43fa-847c-2f4f36e53e49/sample+(2).mkv1566940166552/sample_(2).mkv_manifest.mpd",
    autoload: false
  }

  ngOnInit() {
    console.log("On INIT");
    console.log(this.player.urlMpd);
    // On init go to second 12
    /*let dashJS: MediaPlayerClass = this.dashPlayer.getPlayer();
    dashJS.seek(12); */
  }

}