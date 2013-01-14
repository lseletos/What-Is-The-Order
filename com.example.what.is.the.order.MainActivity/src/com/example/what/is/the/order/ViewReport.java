package com.example.what.is.the.order;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

	
	
public class ViewReport extends Activity
	{
	
		//User's name
		TextView playerNameText, scoreText, totalRoundsText;
		
		//Total rounds played from TimeGame.java
		int totalRoundsPlayed = TimeGame.totalRoundsPlayed;
		
		//Username
		String username = MainActivity.username;
		
		//Overall score
		int score = TimeGame.totalGameScore;

	  /** Called when the activity is first created. */
	  @Override
	  public void onCreate(Bundle savedInstanceState) 
	  {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.view_report);
	      
	      //sets text view to display inputted username
	      playerNameText = (TextView) findViewById(R.id.textViewPlayerName); 
	      playerNameText.setText("Hello " + username + ", Thank you for playing.");
	      
	      //sets text view to display over all score 
	      scoreText = (TextView) findViewById(R.id.textViewOverAllScore); 
	      scoreText.setText("Your score is " + score);
	      
	      //Total rounds played
	      totalRoundsText = (TextView) findViewById(R.id.textViewRoundsPlayed); 
	      totalRoundsText.setText("Total rounds played: " + totalRoundsPlayed);
	      
	  }


	}


