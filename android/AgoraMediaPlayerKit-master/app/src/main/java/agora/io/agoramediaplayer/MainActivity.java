/*
 * Copyright 2013 Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package agora.io.agoramediaplayer;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.ArrayList;


import tv.danmaku.ijk.media.player.IjkMediaPlayer;


/**
 * Main activity -- entry point from Launcher.
 */
public class MainActivity extends Activity {
    private SurfaceView surfaceView1;
    private SurfaceView surfaceView2;
    private Button start_bofang;
    private Button stop_bofang;

    private Button allVideo;

    private Button audio1;
    private Button audio2;
    private Button audio3;
    private Button audio4;
    private Button audio5;
    private Button audio6;
    private Button audio7;

    private IjkMediaPlayer agoaraMediaPlayer1;
    private IjkMediaPlayer agoraMediaPlayer2;
    private String JUstCan1 = "http://114.236.93.153:8080/download/video/lf_360p.flv";
    private String JUstCan2 = "http://devimages.apple.com.edgekey.net/streaming/examples/bipbop_4x3/gear2/prog_index.m3u8";

    //直播视频

    private String[] audioUrls = new String[]{
            "http://mpge.5nd.com/2019/2019-6-25/92274/1.mp3",
            "http://mpge.5nd.com/2019/2019-6-25/92274/2.mp3p",
            "http://mpge.5nd.com/2019/2019-6-25/92279/1.mp",
            "http://mpge.5nd.com/2019/2019-6-25/92278/1.mp3",
            "http://mpge.5nd.com/2019/2019-6-25/92276/1.mp3",
            "http://mpge.5nd.com/2019/2019-6-25/92275/2.mp3",
            "http://bbcmedia.ic.llnwd.net/stream/bbcmedia_lrnorfolk_mf_p"


    };
    private IjkMediaPlayer[] agoraMediaAudioPlayers = new IjkMediaPlayer[audioUrls.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start_bofang = (Button)findViewById(R.id.start_view);
        stop_bofang = (Button)findViewById(R.id.stop_view);
        surfaceView1 =(SurfaceView)findViewById(R.id.video_test1);
        surfaceView2 =(SurfaceView)findViewById(R.id.video_test2);
        surfaceView1.getHolder().addCallback(callback);
        surfaceView2.getHolder().addCallback(callback);


        audio1= (Button)findViewById(R.id.start_audio_1);
        audio2= (Button)findViewById(R.id.start_audio_2);
        audio3= (Button)findViewById(R.id.start_audio_3);
        audio4= (Button)findViewById(R.id.start_audio_4);
        audio5= (Button)findViewById(R.id.start_audio_5);
        audio6= (Button)findViewById(R.id.start_audio_6);
        audio7= (Button)findViewById(R.id.start_audio_7);
        allVideo = (Button)findViewById(R.id.start_all_video);
        InitPlayer();
        start_bofang.setOnClickListener(onClickListener);
        stop_bofang.setOnClickListener(onClickListener);

        audio1.setOnClickListener(onClickListener);
        audio2.setOnClickListener(onClickListener);
        audio3.setOnClickListener(onClickListener);
        audio4.setOnClickListener(onClickListener);
        audio5.setOnClickListener(onClickListener);
        audio6.setOnClickListener(onClickListener);
        audio7.setOnClickListener(onClickListener);
        allVideo.setOnClickListener(onClickListener);
    }

    private  View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){

                case R.id.start_all_video:
                    if(allVideo.getTag()==null||(boolean)allVideo.getTag()==false){
                        agoaraMediaPlayer1.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "mediacodec", 1);
                        agoaraMediaPlayer1.prepareAsync();
                        agoaraMediaPlayer1.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "mediacodec", 1);
                        agoaraMediaPlayer1.start();
                        agoaraMediaPlayer1.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "mediacodec", 1);
                        allVideo.setTag(true);
                        allVideo.setText("停止所有视频");
                    }
                    break;

                default:
                    break;
            }
        }
    };

    private void InitPlayer(){
        Log.i("TJY","AgoraMediaPlayer init");
        agoaraMediaPlayer1 = new IjkMediaPlayer();
        agoaraMediaPlayer1.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "mediacodec", 1);
        try {
            String path ="http://114.236.93.153:8080/download/video/lf_360p.flv";
            agoaraMediaPlayer1.setDataSource(path);
            agoaraMediaPlayer1.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "mediacodec", 1);
        } catch (IOException e) {
            e.printStackTrace();
        }




        Log.i("TJY","AgoraMediaPlayer over");
    }

    private SurfaceHolder.Callback callback = new SurfaceHolder.Callback() {
        @Override
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            Log.i("TJY","surfaceCreated "+surfaceHolder);
            //AgoraMediaPlayer.setDisplay(surfaceHolder);
            agoaraMediaPlayer1.setDisplay(surfaceHolder);
        }

        @Override
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

        }

        @Override
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

        }
    };

}

