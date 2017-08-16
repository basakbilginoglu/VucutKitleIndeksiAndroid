package vucutkitleindeksi.com.tr.vucutkutleindeksi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    ProgressBar androidProgressBar;
    int progressStatusCounter = 0;
    TextView textView;
    Handler progressHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        androidProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        textView = (TextView) findViewById(R.id.textView);
        //Start progressing
        new Thread(new Runnable() {
            public void run() {
                while (progressStatusCounter < 100) {
                    progressStatusCounter += 2;
                    progressHandler.post(new Runnable() {
                        public void run() {
                            androidProgressBar.setProgress(progressStatusCounter);
                            //Status update in textview
                            textView.setText("Status: " + progressStatusCounter + "/" + androidProgressBar.getMax());

                        }
                    });
                    try {
                        Thread.sleep(300);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }



                }
                Intent i=new Intent(SplashScreen.this,LoginActivity.class);
                startActivity(i);
            }
        }).start();
    }
}