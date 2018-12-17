package com.example.sistem03user.youtubeapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener, YouTubePlayer.PlaybackEventListener {

    YouTubePlayerView youTubePlayerView;

    String claveyoutube= "AIzaSyD9GZLfzFIdowg9dIJyb6jfgac3P6mRp1U";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        youTubePlayerView= findViewById(R.id.youtube_view);
        youTubePlayerView.initialize(claveyoutube, this);


    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean fueRestaurado) {

        if(!fueRestaurado)
        {
            String idvideo="";
           // youTubePlayer.cueVideo("t0qvmN03KE");
            youTubePlayer.cueVideo("RHcUU085kZc");
            //youTubePlayer.cueVideo("KyryaqFotGQ&t=6s");

        }




    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

        if(youTubeInitializationResult.isUserRecoverableError())
        {
            youTubeInitializationResult.getErrorDialog(this,1).show();
        }else
        {
            String  error="Error al  iniciar Youtube"+youTubeInitializationResult.toString() ;

            Toast.makeText(getApplicationContext(), error,Toast.LENGTH_LONG).show();
        }

    }

   // @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       // super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==1)
            getYoutubePlayerProvider().initialize(claveyoutube, this);
        {

        }

    }

        protected YouTubePlayer.Provider getYoutubePlayerProvider()
        {
            return youTubePlayerView;
        }


    @Override
    public void onPlaying() {

    }

    @Override
    public void onPaused() {

    }

    @Override
    public void onStopped() {

    }

    @Override
    public void onBuffering(boolean b) {

    }

    @Override
    public void onSeekTo(int i) {

    }
}
