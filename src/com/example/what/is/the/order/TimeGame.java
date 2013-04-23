package com.example.what.is.the.order;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;



public class TimeGame extends Activity
{ 
//	//Dynamic display text
//	 TextView displayText;
	 
	 Random random;
	 
	//check which image is clicked & set to a default string
	 String	selectedImage = "default";
	 String selectedImagePlacement = "default";
	 
	 //images
	 String stringImageOne = "ImageOne";
	 String stringImageTwo = "ImageTwo";
	 String stringImageThree = "ImageThree";
	 
	 //placement zones
	 String stringImageZoneOne = "ZoneOne";
	 String stringImageZoneTwo = "ZoneTwo";
	 String stringImageZoneThree = "ZoneThree";
		
	 
	 //round score
	 int roundScore = 0;
	 
	 //total game score
	 static int totalGameScore;
	 
	 //Main screen rounds per game
	 int mainRoundsPerGame = MainActivity.roundsPerGame;
	 
	 //current game round
	 int currentGameRound = 1;
	 
	 //Game images
	 ImageView imageOne, imageTwo, imageThree;
	 
	 
	 //Game image paths
	 String image1, image2, image3;
	 
	 //Game placement zones
	 ImageView placementImageOne, placementImageTwo, placementImageOneThree;

	 //check if the image’s correct corresponding place is being clicked on & set its default to false
	 boolean isClicked_ImagePlacementIcons = false;
	 
	 //created an array of images to be randomized 
	// public String[] myImages = new String[3];
	 
	 //Check if past moves are correct in order to move on to next move
	 boolean moveOneCorrect = false;
	 boolean moveTwoCorrect = false;
	 boolean moveThreeCorrect = false;
	 boolean roundIsWon =false;
	 
	 //Check to see if all rounds are completed and the game is over
	 boolean gameOver = false;
	 boolean gameOverCalculationsDone = false;
	 
	 //Display image
	 boolean goodJobTextShowing = false;
	 
	 //Display text for winning
	 String goodJobText = "Good Job";
			
	//Total Rounds played, used for view report
	static int totalRoundsPlayed = 0;
	 
  /** Called when the activity is first created. */
	
  @Override
  public void onCreate(Bundle savedInstanceState) 
  {

      super.onCreate(savedInstanceState);
      setContentView(R.layout.time_game);
       
   	  //Connecting image variables to xml file images
      imageOne = (ImageView)findViewById(R.id.imageSelectableOne);
      imageTwo = (ImageView)findViewById(R.id.imageSelectableTwo);
      imageThree = (ImageView)findViewById(R.id.imageSelectableThree);
      
   	  //Connecting image placement variables to xml file image placement buttons
      placementImageOne = (ImageView)findViewById(R.id.imageViewPlaceholder1);
      placementImageTwo = (ImageView)findViewById(R.id.imageViewPlaceholder2);
      placementImageOneThree = (ImageView)findViewById(R.id.imageViewPlaceholder3);

      //Setting up listener for images being clicked         
      imageOne.setOnClickListener(imageOneListener); 
      imageTwo.setOnClickListener(imageTwoListener); 
      imageThree.setOnClickListener(imageThreeListener); 

      //Setting up listener for image zones being clicked         
      placementImageOne.setOnClickListener(placementImageOneListener); 
      placementImageTwo.setOnClickListener(placementImageTwoListener); 
      placementImageOneThree.setOnClickListener(placementImageThreeListener); 
      
//      displayText = (TextView) findViewById(R.id.textViewDisplayText);
      
	  	if (gameOverCalculationsDone == true)
	  	{
	    	//Redirect player to Good Job screen   
	    	Intent intent = new Intent(this, GoodJobScreen.class);
	      startActivity(intent);
	  	}
	  	
     
  }
  
  //Game Image One button listener
  private OnClickListener imageOneListener = new OnClickListener()  
  {  
      public void onClick(View v)  
      {         
      	//reassigns the value of selectedImage 
      	selectedImage = stringImageOne;   

      }  
        
  };  
  
  //Game Image Two button listener
  private OnClickListener imageTwoListener = new OnClickListener()  
  {  
      public void onClick(View v)  
      {  
      	//reassigns the value of selectedImage 
      	selectedImage = stringImageTwo;

      }
  }; 
  
  //Game Image Three button listener
  private OnClickListener imageThreeListener = new OnClickListener()  
  {  
      public void onClick(View v)  
      {  
      	//reassigns the value of selectedImage 
      	selectedImage = stringImageThree;
 
      }
  };


  //Check if the selected image is being placed on the corresponding placement tile
  private OnClickListener placementImageOneListener = new OnClickListener()  
  {  
      public void onClick(View v)  
      {  
      	selectedImagePlacement = stringImageZoneOne;
      	isClicked_ImagePlacementIcons = true;
      	firstGameMoveValidation();
      }
  };
  
  private OnClickListener  placementImageTwoListener = new OnClickListener()  
  {  
      public void onClick(View v)  
      {  
      	selectedImagePlacement = stringImageZoneTwo;
      	isClicked_ImagePlacementIcons = true;
      	secondGameMoveValidation();
      }
  };
  
  private OnClickListener placementImageThreeListener = new OnClickListener()  
  {  
      public void onClick(View v)  
      {  
      	selectedImagePlacement = stringImageZoneThree;
      	isClicked_ImagePlacementIcons = true;
      	thirdGameMoveValidation();
        gameIsWon();
      }
  };



//Game’s Selection validation method

void firstGameMoveValidation()
{
	//When Image placement zone is clicked then continue
	if(isClicked_ImagePlacementIcons == true)
	{
		//First Move Validation
		if (selectedImagePlacement ==  stringImageZoneOne && selectedImage == stringImageTwo)
		{
			moveOneCorrect = true;
			
//      //sets text view to update the top text display 
//      displayText.setText("Correct! Make your second move.");

    	roundIsWon = false;
    	
    	//replace/move image to placeholder spot
    	imageTwo.offsetTopAndBottom(-226);
    	imageTwo.offsetLeftAndRight(-374);

		}
		//First Move Error Checking
		else
		{
			moveOneCorrect = false;
			
//      //sets text view to update the top text display 
//      displayText.setText("Incorrect! Try again!");
      
    	roundIsWon = false;
    	
		}
	}
}

void secondGameMoveValidation()
{
	//When Image placement zone is clicked then continue
	if(isClicked_ImagePlacementIcons == true)
	{     
  	
		//Only move on if move one is correct
		if (moveOneCorrect == true)
		{
			//Second Move Validation
			if ( selectedImagePlacement == stringImageZoneTwo && selectedImage == stringImageThree)
			{
				moveTwoCorrect = true;
				
//	      //sets text view to update the top text display 
//	      displayText.setText("Correct! Make your third move.");
	      
	    	roundIsWon = false;
	    	
	    	//replace/move image to placeholder spot
	    	imageThree.offsetTopAndBottom(-226);
	    	imageThree.offsetLeftAndRight(-383);
			}
			//First Move Error Checking
			else
			{
				moveTwoCorrect = false;
	    	
//	      //sets text view to update the top text display 
//	      displayText.setText("Incorrect! Try again!");
	    	
	    	roundIsWon = false;
			}
		}
	}
}
	
void thirdGameMoveValidation()
{
		//When Image placement zone is clicked then continue
		if(isClicked_ImagePlacementIcons == true)
		{
			//Only move on if move one & move two is correct
			if (moveTwoCorrect == true && moveTwoCorrect == true)
			{
				//Third Move Validation
				if (selectedImagePlacement == stringImageZoneThree && selectedImage == stringImageOne)
				{
					moveThreeCorrect = true;
					
		    	//replace/move image to placeholder spot
		    	imageOne.offsetTopAndBottom(-226);
		    	imageOne.offsetLeftAndRight(760);
		    	
					//sets text view to update the top text display 
		     // displayText.setText("Correct!");
		    	
		    	roundIsWon = true;		    

				}
				//First Move Error Checking
				else 
				{
					moveThreeCorrect = false;
		    	roundIsWon = false;
		    	
//		      //sets text view to update the top text display 
//		      displayText.setText("Incorrect! Try again!");
				}
			}
		}
}


//Game won method
void gameIsWon()
{
	//increment what round the player is on
	if(roundIsWon == true)
	{
		if (currentGameRound < mainRoundsPerGame)
		{
			
			//replace/move image to placeholder spot
			imageOne.offsetTopAndBottom(240);
			imageOne.offsetLeftAndRight(364);
			imageTwo.offsetTopAndBottom(240);
			imageTwo.offsetLeftAndRight(380);
			imageThree.offsetTopAndBottom(240);
			imageThree.offsetLeftAndRight(-760);
			
			currentGameRound++;
			
			//Show good job text
			goodJobTextShowing = true;
			
//      //sets text view to update the top text display 
//      displayText.setText("You are on round " + currentGameRound + 
//	  			" out of " + mainRoundsPerGame + " rounds.");
	  	
	  	//Tally of total rounds played
	  	totalRoundsPlayed += currentGameRound;
			
		}
		else
		{
			//when all of the previously selected rounds are completed then the game is over 
			gameOver = true;
		}
	}
		
	if (gameOver == true)
	{

			if (moveOneCorrect == true && moveTwoCorrect == true && moveThreeCorrect == true)
			{
				//Increment score
				roundScore++;
				
				//Total score of all rounds
		  	totalGameScore += roundScore;
				
	      //sets text view to update the top text display 
//	      displayText.setText("You Won the Game!!! Score: " + roundScore);
		  	
		  	gameOverCalculationsDone = true;
//	      
//		  	Toast.makeText(getBaseContext(), "Your total score is: " + totalGameScore,   
//		    Toast.LENGTH_SHORT).show();   
		  	
     	 Intent intent = new Intent(TimeGame.this, RewardVideo.class);
     	 startActivity(intent);

			}
			else
			{
//	      //sets text view to update the top text display 
//	      displayText.setText( "You are on round " + currentGameRound + 
//		  			" out of " + mainRoundsPerGame + " rounds.");

			}
	}
	}

void displayGoodJobText()
{
	if (goodJobTextShowing == true)
	{
		//display a note, what round is in session
		Toast.makeText(getBaseContext(), goodJobText,   
	  Toast.LENGTH_SHORT).show(); 
		
	}
	

}


public void resetGame()
{
	
	//Reset all variables to default for new round
	 //round score
	 roundScore = 0;
	 
	 //check if the image’s correct corresponding place is being clicked on & set its default to false
	 isClicked_ImagePlacementIcons = false;
	 
	 //Check if past moves are correct in order to move on to next move
	 moveOneCorrect = false;
	 moveTwoCorrect = false;
	 moveThreeCorrect = false;
	 roundIsWon =false;
	 
	 //Check to see if all rounds are completed and the game is over
	 gameOver = false;
	 gameOverCalculationsDone = false;
	 
	 //Display image
	 goodJobTextShowing = false;

}

	
/** Called when the user clicks the Game Info button */
public void replayVideo(View view) 
{
	 Intent intent = new Intent(TimeGame.this, BlockVideo.class);
	 startActivity(intent);
}


//public void randomImages()
//{
//			
//			for(int i=0; i > 3 ; i++) 
//			{
//					int randIndex = random.nextInt(i);
//					String temp = myImages[i];
//					myImages[i] = myImages[randIndex];
//					myImages[randIndex] = temp;
//			}
//			
//			image1 = myImages[0];
//			image2 = myImages[1];
//			image3 = myImages[2];
//	
//}

}