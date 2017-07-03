package com.mohamed.monitor;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.LineGraphSeries;

public class Graph extends AppCompatActivity implements View.OnClickListener {
    ToggleButton ss;
    static boolean stream;

    static GraphView rollG;
    static LineGraphSeries rS;
    private static double graph2LastXvalue=0;
    private static int XView=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        buttonInit();
        init();

    }
    void buttonInit(){
        ss = (ToggleButton)findViewById(R.id.startStop);
        ss.setOnClickListener(this);

        stream = false;
    }
    void init(){
        rollG = (GraphView) findViewById(R.id.rollG);
        rS.setColor(Color.YELLOW);




    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.startStop:
                if(ss.isChecked()){
                    if(Bluetooth.connectedThread != null) Bluetooth.connectedThread.write("E");
                }else{
                    if(Bluetooth.connectedThread != null) Bluetooth.connectedThread.write("Q");
                }

                break;
        }

    }
}
