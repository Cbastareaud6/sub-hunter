package com.cathybastareaud.sub_hunter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Random;

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
  ImageView gameView;
  Bitmap blankBitMap;
  Canvas canvas;
  Paint paint;



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

    blankBitMap= Bitmap.createBitmap(numberPixelHorizontal, numberPixelVertical, Config.ARGB_8888);
    canvas = new Canvas(blankBitMap);
    gameView = new ImageView(this);
    paint = new Paint();
    setContentView(gameView);


    Log.d("debugging", "in onCreate");
   newGame();
   draw();

    /*
    This code wil execute when a new game needs to be started
    It wil happen when the app is first started and after the player wins the game.
    * */

  }

  public void newGame() {
    Random rng = new Random();
    subHorizontalPosition = rng.nextInt(gridWidth);
    subVerticalPosition = rng.nextInt(gridHeight);
    shotsTaken = 0;
    Log.d("debugging", "in newGame");


  }

  void draw() {
    gameView.setImageBitmap(blankBitMap);
    canvas.drawColor(Color.argb(255,255,255,255));
    paint.setColor(Color.argb(255,0,0,0));

    canvas.drawLine(blockSize * 1,0, blockSize * 1 ,numberPixelVertical -1,paint);
    canvas.drawLine(0,blockSize * 1, numberPixelHorizontal -1,blockSize*1, paint);

    paint.setTextSize(blockSize*2);
    paint.setColor(Color.argb(255,0,0,255));
    canvas.drawText("Shots taken: "+ shotsTaken + "Distance: "+distanceFromSub, blockSize, blockSize*1.75f,paint);

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
     paint.setTextSize(blockSize);
     canvas.drawText("number horizontal pixel= " + numberPixelHorizontal, 50, blockSize*3, paint);



    }


  @Override
  public boolean onTouchEvent(MotionEvent event) {
    Log.d("debugging", "in onTouchEvent");
    takeShot();

    return true;
  }
}