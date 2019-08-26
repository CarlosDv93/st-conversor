import * as bitmovin from 'bitmovin-player/modules/bitmovinplayer-core';
import { Component, OnInit, AfterViewChecked } from '@angular/core';
import { Player } from 'bitmovin-player';


@Component({
  selector: 'app-video',
  templateUrl: './video.component.html',
  styleUrls: ['./video.component.css']
})
export class VideoComponent implements AfterViewChecked {

  ngAfterViewChecked() {
    setTimeout(() => {
      const container = document.getElementById('my-player');
      const playerConfig = {
        key: '1fce53f5-31d8-4242-bd74-dbcd51898f66',
        //ui: false,
        location: {
          ui: 'bitmovin-player/bitmovinplayer-ui.js',
          ui_css: 'bitmovin-player/bitmovinplayer-ui.css'
        }
      };
      const source = {
        title: 'Getting Started with the Bitmovin Player',
        description: 'Now you are ready to embed the Bitmovin Player into your own website :)',
        dash: 'https://st-bucket-carlosdv93.s3-sa-east-1.amazonaws.com/output/1e6ac3ab-a29c-43fa-847c-2f4f36e53e49/sample.mkv1566580475252/sample.mkv_manifest.mpd',
        hls: 'https://st-bucket-carlosdv93.s3-sa-east-1.amazonaws.com/output/1e6ac3ab-a29c-43fa-847c-2f4f36e53e49/sample.mkv1566580475252/video/1024_1500000/fmp4/seg_0.m4s',
        progressive: 'https://st-bucket-carlosdv93.s3-sa-east-1.amazonaws.com/output/1e6ac3ab-a29c-43fa-847c-2f4f36e53e49/sample.mkv1566580475252/video/1024_1500000/fmp4/seg_0.m4s'
        //dash: 'https://bitmovin-a.akamaihd.net/content/MI201109210084_1/mpds/f08e80da-bf1d-4e3d-8899-f0f6155f6efa.mpd',
        //hls: 'https://bitmovin-a.akamaihd.net/content/MI201109210084_1/m3u8s/f08e80da-bf1d-4e3d-8899-f0f6155f6efa.m3u8',
        //progressive: 'https://bitmovin-a.akamaihd.net/content/MI201109210084_1/MI201109210084_mpeg-4_hd_high_1080p25_10mbits.mp4',
        //poster: 'https://bitmovin-a.akamaihd.net/content/MI201109210084_1/poster.jpg'
      };
      const player = new Player(container, playerConfig); // const player = new bitmovin.player.Player(container, playerConfig);
      player.load(source).then(
        play => {
          console.log('Successfully created Bitmovin Player instance')
        },
        reason => {
          console.log('Error while creating Bitmovin Player instance')
        }
      );
    }, 3000);
  }
}