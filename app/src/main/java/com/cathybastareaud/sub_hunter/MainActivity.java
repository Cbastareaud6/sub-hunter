package com.cathybastareaud.sub_hunter;

import android.app.Activity;
import android.util.Log;
import android.view.MotionEvent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends Activity {


  /*
    Android runs this cde just before the player sees the app
    This makes it a good place to add the code or the one time setup phase.
    */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
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

  }

  void takeShot() {
    Log.d("debugging", "in takeShot");
    draw();

  }
    void boom () {
    }

    void printDebuggingText() {

    }


  @Override
  public boolean onTouchEvent(MotionEvent event) {
    Log.d("debugging", "in onTouchEvent");
    takeShot();

    return true;
  }
}