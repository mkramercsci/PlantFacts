package edu.niu.cs.z1860050.plantfacts;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

public class FactsActivity extends AppCompatActivity
{
  TextView factsTV, descriptionTV;
  ImageView factsIV;

  String aloe, burros, jade, snake, zebra;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_facts);

    //connect to the items on screen
    factsTV = findViewById(R.id.factsTitleTextView);
    factsIV = findViewById(R.id.factsImageView);
    descriptionTV = findViewById(R.id.descriptionTextView);

    //retrieve the spinner choice from the intent
    Intent intent = getIntent();
    String choice = intent.getStringExtra("plant");

    //connect to the strings.xml facts paragraphs
    aloe = (String) getResources().getText(R.string.aloe_string);
    burros = (String) getResources().getText(R.string.burros_string);
    jade = (String) getResources().getText(R.string.jade_string);
    snake = (String) getResources().getText(R.string.snake_string);
    zebra = (String) getResources().getText(R.string.zebra_string);

    //set the title, photo, and description based on the choice
    factsTV.setText(choice);
    changePhoto(choice);
    displayFacts(choice);

  }

  //check the user's choice and display the facts
  public void displayFacts(String choice)
  {
    String description = "something went wrong";

    //check the user's choice from MainActivity
    switch(choice)
    {
      case "Aloe Vera":
        description = aloe;
        break;
      case "Burro's Tail":
        description = burros;
        break;
      case "Jade":
        description = jade;
        break;
      case "Snake Plant":
        description = snake;
        break;
      case "Zebra Plant":
        description = zebra;
        break;
    }//end of switch

    //set the description
    descriptionTV.setText(description);

  }//end of displayFacts

  //a duplicate of the method from MainActivity
  //change the photo based on the user's choice
  @SuppressLint("UseCompatLoadingForDrawables")
  private void changePhoto (String choice)
  {
    Drawable myDrawable;

    //detect the choice made by the user, and adjust the image view accordingly
    //all photos are 1000px 72dpi
    if (choice.equals("Aloe Vera"))
    {
      myDrawable = getResources().getDrawable(R.drawable.aloe);
      factsIV.setImageDrawable(myDrawable);
    }
    else if (choice.equals("Burro's Tail"))
    {
      myDrawable = getResources().getDrawable(R.drawable.burros);
      factsIV.setImageDrawable(myDrawable);
    }
    else if (choice.equals("Jade"))
    {
      myDrawable = getResources().getDrawable(R.drawable.jade);
      factsIV.setImageDrawable(myDrawable);
    }
    else if (choice.equals("Snake Plant"))
    {
      myDrawable = getResources().getDrawable(R.drawable.snake);
      factsIV.setImageDrawable(myDrawable);
    }
    else if (choice.equals("Zebra Plant"))
    {
      myDrawable = getResources().getDrawable(R.drawable.zebra);
      factsIV.setImageDrawable(myDrawable);
    }
  }//end changePhoto

  //return to the MainActivity
  public void goBack( View view )
  {
    finish();
  }
}