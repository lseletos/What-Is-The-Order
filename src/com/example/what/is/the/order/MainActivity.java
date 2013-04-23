package com.example.what.is.the.order;

import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;


public class MainActivity extends Activity 
{
	 //Is linear button selected
	 boolean linearIsSelected = false;
	
	 //Is relative button selected
	 boolean relativeIsSelected = true;
	 
	 //Change text views for Linear and Relative:
	 TextView textViewAVideoShows, textViewMiddleStep, textViewWhatOccurred;

	 //Basic & Advanced Play:
	 RadioButton radioButtonBasicPlay, radioButtonAdvancedPlay;
	 	
	//Basic Play Options (Before/After ; Earlier/Later)
	 RadioButton radioButtonBeforeAfter, radioButtonEarlierLater;
	 
	//Entered UserName:
	 private EditText userNameInput; 
	 Button buttonGo;
	 public static String username = "Default"; 
	 
	//Linear & Relative Time:
	 Button buttonLinearTime, buttonRelativeTime;
	 
	//Actions:
	 RadioButton radioButtonSandwich,radioButtonBannana,radioButtonCoat,radioButtonBubbles,
	 radioButtonBalloon,radioButtonBlock,radioButtonDottoDot,radioButtonDrinking,radioButtonPaper,
	 radioButtonSocks;
	 
	//Repeat Game:
	 RadioButton radioButtonRepeatYes,radioButtonRepeatNo;
	 
	//Reward Screen:
	 RadioButton radioButtonRewardYes,radioButtonRewardNo;
	 
	//Practice:
	 RadioButton radioButtonPracticeYes,radioButtonPracticeNo;
	 
	//Text:
	 RadioButton radioButtonTextYes,radioButtonTextNo;
	 
	//Rounds per Game:
	 RadioButton radioButtonNum1,radioButtonNum2,radioButtonNum3,radioButtonNum4,radioButtonNum5,
	 radioButtonNum6,radioButtonNum7,radioButtonNum8;
	 
	//Video:
	 RadioButton radioButtonVideoYes,radioButtonVideoNo;
	 
	//Play Game:	
	 Button buttonPlayGame;

	//Game Menu Buttons:
	 Button buttonGameInstructions,buttonGameInfo;
	 
	 //Rounds per game variable
	 static int roundsPerGame = 0;
	 
	 //View Report Button
	 Button buttonViewReport;
	 
	 //View report button boolean, used to start activity when button is clicked
	 boolean isClickedViewReportButton = false;
 
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) 
  {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      
      //Basic & Advanced Play:
      radioButtonBasicPlay = (RadioButton)findViewById(R.id.radioButtonBasicPlay);
      radioButtonAdvancedPlay = (RadioButton)findViewById(R.id.radioButtonAdvancedPlay);

      radioButtonBasicPlay.setOnClickListener(radioButtonOnClickListener);
      radioButtonAdvancedPlay.setOnClickListener(radioButtonOnClickListener);

      radioButtonBasicPlay.setChecked(true);
      

	   	//Basic Play Options (Before/After ; Earlier/Later)
	   	radioButtonBeforeAfter = (RadioButton)findViewById(R.id.radioButtonBeforeAfter);
	   	radioButtonEarlierLater = (RadioButton)findViewById(R.id.radioButtonEarlierLater);
	
	    radioButtonBeforeAfter.setOnClickListener(radioButtonOnClickListener);
	    radioButtonEarlierLater.setOnClickListener(radioButtonOnClickListener);
	
	    radioButtonBeforeAfter.setChecked(true);
     
   	 
	   	//Entered UserName: 
	    userNameInput = (EditText)findViewById(R.id.userNameInput);     
	    buttonGo = (Button)this.findViewById(R.id.buttonGo);  
        
        
	    buttonGo.setOnClickListener(buttonGoListener); 
	    
	    //Rounds per game:
	    radioButtonNum1 = (RadioButton)findViewById(R.id.radioButtonNum1);     
	    radioButtonNum2 = (RadioButton)findViewById(R.id.radioButtonNum2);     
	    radioButtonNum3 = (RadioButton)findViewById(R.id.radioButtonNum3);     
	    radioButtonNum4 = (RadioButton)findViewById(R.id.radioButtonNum4);     
	    radioButtonNum5 = (RadioButton)findViewById(R.id.radioButtonNum5);     
	    radioButtonNum6 = (RadioButton)findViewById(R.id.radioButtonNum6);     
	    radioButtonNum7 = (RadioButton)findViewById(R.id.radioButtonNum7);     
	    radioButtonNum8 = (RadioButton)findViewById(R.id.radioButtonNum8);     
     
	    //Radio button for rounds per game  
	    radioButtonNum1.setOnClickListener(radioButtonNum1Listener); 
	    radioButtonNum2.setOnClickListener(radioButtonNum2Listener); 
	    radioButtonNum3.setOnClickListener(radioButtonNum3Listener); 
	    radioButtonNum4.setOnClickListener(radioButtonNum4Listener); 
	    radioButtonNum5.setOnClickListener(radioButtonNum5Listener); 
	    radioButtonNum6.setOnClickListener(radioButtonNum6Listener); 
	    radioButtonNum7.setOnClickListener(radioButtonNum7Listener); 
	    radioButtonNum8.setOnClickListener(radioButtonNum8Listener); 
	    
	    //change text based off of if linear or relative time button is clicked
	    textViewAVideoShows = (TextView) findViewById(R.id.textViewAVideoShows);
	    textViewMiddleStep = (TextView) findViewById(R.id.textViewMiddleStep);
	    textViewWhatOccurred = (TextView) findViewById(R.id.textViewWhatOccurred);
	    
	    
	  	//Linear Time button set up
	    buttonLinearTime = (Button)findViewById(R.id.buttonLinearTime);     
	    buttonLinearTime.setOnClickListener(buttonLinearTimeListener);
	    
	  	//Relative Time button set up
	    buttonRelativeTime = (Button)findViewById(R.id.buttonRelativeTime);     
	    buttonRelativeTime.setOnClickListener(buttonRelativeTimeListener);

	    
  }
  

  //Button for Linear Time: listener
  private OnClickListener buttonLinearTimeListener = new OnClickListener()  
  {  
      public void onClick(View v)  
      {         
      	linearIsSelected = true;
      	relativeIsSelected = false;
      	
        //changing text depending on which game option is selected
      	if(linearIsSelected == true)
      	{ 
          //sets text view to update the top text display 
          textViewAVideoShows.setText("Place Linear directions here...");
          textViewMiddleStep.setText("line 2");
          textViewWhatOccurred.setText("line 3");
      	}
       }
  };   

  //Button for Relative Time: listener
  private OnClickListener buttonRelativeTimeListener = new OnClickListener()  
  {  
      public void onClick(View v)  
      {            
      	linearIsSelected = false;
      	relativeIsSelected = true;
      	
	      //changing text depending on which game option is selected
	  		if(relativeIsSelected == true)
	  		{
	        //sets text view to update the top text display 
	  	    textViewAVideoShows.setText("A video shows an action the action is divided into 3 steps the");
	  	    textViewMiddleStep.setText("middle step is placed on the screen and the player is asked to tell");
	  	    textViewWhatOccurred.setText("what occurred before and after that step");
	  		}
      }
      
  };  
  

  //Radio button for rounds per game option 1: listener
  private OnClickListener radioButtonNum1Listener = new OnClickListener()  
  {  
      public void onClick(View v)  
      {         
           
        if(radioButtonNum1.isChecked())
        {
        	roundsPerGame = 1;
        }       
       
        }
  };  
  
  //Radio button for rounds per game option 2: listener
  private OnClickListener radioButtonNum2Listener = new OnClickListener()  
  {  
      public void onClick(View v)  
      {         
           
        if(radioButtonNum2.isChecked())
        {
        	roundsPerGame = 2;
        }
       
        }
  };  
  //Radio button for rounds per game option 3: listener
  private OnClickListener radioButtonNum3Listener = new OnClickListener()  
  {  
      public void onClick(View v)  
      {         
           
        if(radioButtonNum3.isChecked())
        {
        	roundsPerGame = 3;
        }       
       
        }
  };
  //Radio button for rounds per game option 4: listener
  private OnClickListener radioButtonNum4Listener = new OnClickListener()  
  {  
      public void onClick(View v)  
      {         
           
        if(radioButtonNum4.isChecked())
        {
        	roundsPerGame = 4;
        }       
       
        }
  };
  //Radio button for rounds per game option 5: listener
  private OnClickListener radioButtonNum5Listener = new OnClickListener()  
  {  
      public void onClick(View v)  
      {         
           
        if(radioButtonNum5.isChecked())
        {
        	roundsPerGame = 5;
        }       
       
        }
  };
  //Radio button for rounds per game option 6: listener
  private OnClickListener radioButtonNum6Listener = new OnClickListener()  
  {  
      public void onClick(View v)  
      {         
           
        if(radioButtonNum6.isChecked())
        {
        	roundsPerGame = 6;
        }       
       
        }
  };
  //Radio button for rounds per game option 7: listener
  private OnClickListener radioButtonNum7Listener = new OnClickListener()  
  {  
      public void onClick(View v)  
      {         
           
        if(radioButtonNum7.isChecked())
        {
        	roundsPerGame = 7;
        }       
       
        }
  };
  //Radio button for rounds per game option 8: listener
  private OnClickListener radioButtonNum8Listener = new OnClickListener()  
  {  
      public void onClick(View v)  
      {         
           
        if(radioButtonNum8.isChecked())
        {
        	roundsPerGame = 8;
        }       
       
        }
  };


  //Username input go button listener
  private OnClickListener buttonGoListener = new OnClickListener()  
  {  
      public void onClick(View v)  
      {         
      	// Get player's name
  	    username = userNameInput.getText().toString();   

      	Toast.makeText(getBaseContext(), "Username: " + username,   
        Toast.LENGTH_SHORT).show();              
      }  
        
  };  

  //Radio Button listener
  RadioButton.OnClickListener radioButtonOnClickListener =
   new RadioButton.OnClickListener()
  {
  		public void onClick(View v) 
  		{
      	Toast.makeText(getBaseContext(), "Radio Button Clicked",   
        Toast.LENGTH_SHORT).show();     
  		}
  };
  

  
  
  
  /** Called when the user clicks the Play Game button */
  public void playGame(View view) 
  {
    if (roundsPerGame == 0)
    {
    	//Error! Select how many rounds per game
    	Toast.makeText(getBaseContext(), "Error! Select how many rounds per game you want." + roundsPerGame,   
      Toast.LENGTH_SHORT).show(); 
    }
    else
    {	
    	Intent intent = new Intent(this, BlockVideo.class);
      startActivity(intent);
    }

  }
    
 	 
  /** Called when the user clicks the Instruction button */
  public void getGameInstructions(View view) 
  {
  	Intent intent = new Intent(this, GameInstructions.class);
    startActivity(intent);
  }
  
 	
  /** Called when the user clicks the Game Info button */
  public void getGameInfo(View view) 
  {
  	Intent intent = new Intent(this, GameInfo.class);
    startActivity(intent);
  }
 
 
  /** Called when the user clicks the View Report button */
  public void getViewReport(View view)
  {
  	if (!(username == "Default"))
  	{
	  	Intent intent = new Intent(this, ViewReport.class);
	  	startActivity(intent);
  	}
  	else
  	{
    	//Error! Input user name
    	Toast.makeText(getBaseContext(), "Error! Input your Username.",   
      Toast.LENGTH_SHORT).show();  
  	}
  	}
  
 }
 