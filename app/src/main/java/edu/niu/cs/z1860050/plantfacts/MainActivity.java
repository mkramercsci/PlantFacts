package edu.niu.cs.z1860050.plantfacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

//plant facts source: https://garden.minuteguidedmeditation.com/what-are-different-types-of-succulents/

public class MainActivity extends AppCompatActivity
{
  private Spinner plantSpin;
  private ImageView plantIV;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //connect the imageview
    plantIV = findViewById(R.id.plantImageView);

    //set up the spinner to the item on screen
    plantSpin = findViewById(R.id.plantSpinner);

    //attach the adapter to the spinner
    ArrayAdapter<String> javaAdapter = new ArrayAdapter<>(this,
        R.layout.spinner_view, SpinnerData.valueArray);

    //connect the adapter and spinner
    plantSpin.setAdapter(javaAdapter);

    //set up the listener
    plantSpin.setOnItemSelectedListener(spinnerListener);

  }//end onCreate

  //build the listener which detects the user's spinner selection
  private AdapterView.OnItemSelectedListener spinnerListener = new AdapterView.OnItemSelectedListener()
  {
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
    {
      String selection;

      //get the selection from the spinner
      selection = adapterView.getItemAtPosition(position).toString();

      //pass the selection into the photo changer method
      changePhoto(selection);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView)
    { }
  };//end OnItemSelectedListener

  //method to change the photo
  private void changePhoto (String choice)
  {
    Drawable myDrawable;

    //detect the choice made by the user, and adjust the image view accordingly
    //all photos are 1000px 72dpi
    if (choice.equals("Aloe Vera"))
    {
      myDrawable = getResources().getDrawable(R.drawable.aloe);
      plantIV.setImageDrawable(myDrawable);
    }
    else if (choice.equals("Burro's Tail"))
    {
      myDrawable = getResources().getDrawable(R.drawable.burros);
      plantIV.setImageDrawable(myDrawable);
    }
    else if (choice.equals("Jade"))
    {
      myDrawable = getResources().getDrawable(R.drawable.jade);
      plantIV.setImageDrawable(myDrawable);
    }
    else if (choice.equals("Snake Plant"))
    {
      myDrawable = getResources().getDrawable(R.drawable.snake);
      plantIV.setImageDrawable(myDrawable);
    }
    else if (choice.equals("Zebra Plant"))
    {
      myDrawable = getResources().getDrawable(R.drawable.zebra);
      plantIV.setImageDrawable(myDrawable);
    }
  }//end changePhoto

  //method which runs after the facts button is clicked
  public void getFacts (View view)
  {
    //create the intent to go to the name activity
    Intent intent = new Intent(MainActivity.this,
        FactsActivity.class);

    String choice;
    choice = plantSpin.getSelectedItem().toString();

    intent.putExtra("plant", choice);

    startActivity(intent);
  }//end getFacts
}//end MainActivity