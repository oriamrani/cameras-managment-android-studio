package com.example.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.SurfaceView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

//import com.pedro.vlc.VlcListener;
//import com.pedro.vlc.VlcVideoLibrary;

import org.videolan.libvlc.LibVLC;
import org.videolan.libvlc.MediaPlayer;
import org.videolan.libvlc.util.VLCVideoLayout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class DisplayCamera extends AppCompatActivity {

    private VLCManager mVLCManager;
    VideoView videoView;
    SurfaceView surfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_camera);


        String cameraName = getIntent().getExtras().getString("cameraName");
        String ip = getIntent().getExtras().getString("ip");
        int port = getIntent().getExtras().getInt("port");
        String userName = getIntent().getExtras().getString("userName");
        String password = getIntent().getExtras().getString("password");

        String url = "rtsp://" + userName + ":" + password + "@" + ip;
        String url1 = "rtsp://wowzaec2demo.streamlock.net/vod/mp4:BigBuckBunny_115k.mov";

        mVLCManager = new VLCManager(this, (VLCVideoLayout) findViewById(R.id.videoLayout));

        mVLCManager.play(url);

       // vlcVideoLibrary = new VlcVideoLibrary(this, this, surfaceView);
        //vlcVideoLibrary.play(url);


    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mVLCManager != null) {
            mVLCManager.onStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mVLCManager != null) {
            mVLCManager.onDestroy();
        }
    }

    protected void getPlayerState() {
        int playerState = mVLCManager.getPlayerState();
        System.out.println("Player state: " + playerState);
        switch (playerState) {
            case 1:
                int x =2;
                break;
            default:
                break;
        }
    }

    //play rtsp stream
    private void PlayRtspStream(String rtspUrl) {

        try {
            videoView.setVideoURI(Uri.parse(rtspUrl));
            videoView.requestFocus();
            videoView.start();
        } catch (Exception e) {
            int x = 2;
        }

    }




}