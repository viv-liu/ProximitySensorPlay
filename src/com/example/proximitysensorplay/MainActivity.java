package com.example.proximitysensorplay;

import android.app.Activity;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends Activity implements SensorEventListener{
	private SensorManager mSensorManager;
	private Sensor mSensor;
	private Button mButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
		mButton = (Button)this.findViewById(R.id.button1);
	}
	
	protected void onResume() {
		super.onResume();
		mSensorManager.registerListener(this, mSensor,
		SensorManager.SENSOR_DELAY_NORMAL);
	}
	
	protected void onPause() {
		super.onPause();
		mSensorManager.unregisterListener(this);
	}
	 
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
	}
	
	public void onSensorChanged(SensorEvent event) {
		if (event.values[0] == 0) {
			mButton.setBackgroundColor(Color.GREEN);
			mButton.setText("Close");
		 //iv.setImageResource(R.drawable.near);
		} else {
			mButton.setBackgroundColor(Color.RED);
			mButton.setText("Far");
		 //iv.setImageResource(R.drawable.far);
		}
	}
}
