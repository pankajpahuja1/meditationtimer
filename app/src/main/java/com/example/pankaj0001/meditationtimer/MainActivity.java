package com.example.pankaj0001.meditationtimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    SeekBar seekBar ;
    TextView timeshow;

    Button go;
    MediaPlayer mp;
    CountDownTimer c;






    public void runn(View view)
    {





        if(seekBar.isEnabled()) {

            seekBar.setEnabled(false);


            seekBar.setVisibility(View.INVISIBLE);
            go.setText("Stop");
             c= new CountDownTimer(seekBar.getProgress()*1000,1000){

                @Override
                public void onTick(long millisUntilFinished) {
                    update(millisUntilFinished/1000);



                }

                @Override
                public void onFinish() {
                    seekBar.setVisibility(View.VISIBLE);
                    seekBar.setEnabled(true);
                    mp.pause();
                    go.setText("Go");
                    timeshow.setText("00:00");

                }
            };
            c.start();
            mp.start();

        }
        else if(!seekBar.isEnabled()) {





            c.cancel();
            seekBar.setVisibility(View.VISIBLE);
            seekBar.setEnabled(true);
         //   System.out.println(seekBar.isEnabled()+"now it should be enaabled again");
            mp.pause();
            go.setText("Go");
            timeshow.setText("00:00");
            seekBar.setProgress(0);


            // mp.stop();

           // c.cancel();
        }


    }












    public void update(long prog)
    {
        long min= (long)prog/60;
        long sec= prog-min*60;

          //  Log.i("ye update chala",""+b++);
      //  timeshow.setText(Integer.toString(min)+":"+Integer.toString(sec));
        timeshow.setText(min+":"+sec);
    }











    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mp= MediaPlayer.create(this,R.raw.wind);
        timeshow = findViewById(R.id.textView);
        timeshow.setText("3:00");


         go = findViewById(R.id.timer);



        seekBar = findViewById(R.id.seekBartimer);


        seekBar.setMax(600);
        seekBar.setProgress(300);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                System.out.println(progress);
                long min= (long)progress/60;
                long sec= progress-min*60;

                //  Log.i("ye update chala",""+b++);
                //  timeshow.setText(Integer.toString(min)+":"+Integer.toString(sec));
                timeshow.setText(min+":"+sec);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });











    }
}