package com.mohamed.monitor;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.LineGraphSeries;

public class RPY2 extends AppCompatActivity implements View.OnClickListener {

    ToggleButton startStop;
    static boolean stream;

    static GraphView rollGraph,pitchGraph,yawGraph;
    static LineGraphSeries rS,pS,yS;
    private static double graph2LastXvalue=0;
    private static int XView=10;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rpy2);
        ConstraintLayout background =(ConstraintLayout)findViewById(R.id.RPY);
        background.setBackgroundColor(Color.BLUE);

        buttonInit();
        init();

    }
    void buttonInit(){
        startStop = (ToggleButton)findViewById(R.id.startStop);
        startStop.setOnClickListener(this);

        stream = false;
    }
    void init(){
        rollGraph = (GraphView) findViewById(R.id.rollG);
        rS.setColor(Color.YELLOW);


        pitchGraph = (GraphView)findViewById(R.id.pitchGraph);
        pS.setColor(Color.YELLOW);

        yawGraph = (GraphView)findViewById(R.id.yawGraph);
        yS.setColor(Color.YELLOW);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.startStop:
                if(startStop.isChecked()){
                    if(Bluetooth.connectedThread != null) Bluetooth.connectedThread.write("E");
                }else{
                    if(Bluetooth.connectedThread != null) Bluetooth.connectedThread.write("Q");
                }

                break;
        }

    }
}