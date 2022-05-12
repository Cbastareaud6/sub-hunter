package com.cathybastareaud.sub_hunter;

import android.app.Activity;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends Activity {

  int numberPixelHorizontal;
  int numberPixelVertical;
  int blockSize;
  int gridWidth = 40;
  int gridHeight;
  float horizontalTouch = -100;
  float verticalTouch = -100;
  int subHorizontalPosition;
  int subVerticalPosition;
  boolean hit;
  int shotsTaken;
  int distanceFromSub;
  boolean debugging;


  /*
    Android runs this cde just before the player sees the app
    This makes it a good place to add the code or the one time setup phase.
    */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Display display = getWindowManager().getDefaultDisplay();
    Point size = new Point();
    display.getSize(size);
    numberPixelHorizontal = size.x;
    numberPixelVertical= size.y;
    blockSize = numberPixelHorizontal / gridWidth;
    gridHeight = numberPixelVertical / blockSize;

    Log.d("debugging", "in onCreate");
   newGame();
   draw();

    /*
    This code wil execute when a new game needs to be started
    It wil happen when the app is first started and after the player wins the game.
    * */

  }

  public void newGame() {
    Log.d("debugging", "in newGame");

  }

  void draw() {
    Log.d("debugging", "in draw");
    printDebuggingText();
    }



  void takeShot() {
    Log.d("debugging", "in takeShot");
    draw();

  }
    void boom () {
    }

    void printDebuggingText() {
      Log.d("NumberHorizontalPixel" + "" , String.valueOf(+numberPixelHorizontal));
      Log.d("NumberVerticalPixel" + "" , String.valueOf(+numberPixelVertical));

      Log.d("blockSize" + "" , String.valueOf(+blockSize));
      Log.d("gridWidth" + "" , String.valueOf(+gridWidth));
      Log.d("gridHeight" + "" , String.valueOf(+ gridHeight));

      Log.d("HorizontalTouch" + "" , String.valueOf(+ horizontalTouch));
      Log.d("verticalTouch" + "" , String.valueOf(+ verticalTouch));
      Log.d("subHorizontalPosition" + "" , String.valueOf(+ subHorizontalPosition));
      Log.d("subVerticalPosition" + "" , String.valueOf(+ subVerticalPosition));




    }


  @Override
  public boolean onTouchEvent(MotionEvent event) {
    Log.d("debugging", "in onTouchEvent");
    takeShot();

    return true;
  }
}