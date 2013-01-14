package com.example.what.is.the.order;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class GoodJobScreen extends Activity
{

	//User's name
	TextView playerNameText, scoreText;
	
	//username
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
      playerNameText = (TextView) findViewById(R.id.textViewUsername); 
      playerNameText.setText("Game is over, Good job " + username + ", Thank you for playing.");
      
      //sets text view to display over all score 
      scoreText = (TextView) findViewById(R.id.textViewScore); 
      scoreText.setText("Your score is " + score);
      
  }
  
 
}
