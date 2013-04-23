package com.example.what.is.the.order;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.widget.MediaController;
import android.widget.VideoView;
 
public class RewardVideo extends Activity
{
	
	VideoView video;
	MediaPlayer mediaPlayer;
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {   
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rewardvideo);

      //Create VideoView
        final VideoView videoView = (VideoView)this.findViewById(R.id.videoViewReward);
        //Create MediaController
        MediaController mc = new MediaController(this);
        //Set MediaController to VideoView
        videoView.setMediaController(mc);
        //Set video web path
        videoView.setVideoURI(Uri.parse("http://londo.stetson.edu/cinf301.s2013/lseletos/reward.mp4"));
        //Set requestFocus
        videoView.requestFocus();
        //Play Video
        videoView.start();
        
        Handler handler = new Handler(); 
        handler.postDelayed(new Runnable() { 
             public void run() 
             {    
            	 Intent intent = new Intent(RewardVideo.this, TimeGame.class);
            	 startActivity(intent);
             } 
        }, 8000); 

    }
    
}
	  
	  
	
	  
	  
//	  /** Called when the user clicks the Play Game button */
//	  public void playGame(View view) 
//	  {
// 
//	    	Intent intent = new Intent(this, TimeGame.class);
//	      startActivity(intent);
//	  }