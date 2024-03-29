package com.example.device;

import com.example.device.widget.VideoPlayer;
import com.example.device.widget.VideoRecorder;

import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;//import android.support.v7.app.AppCompatActivity;
import android.view.Window;

/**
 * Created by ouyangshen on 2016/11/4.
 */
public class VideoActivity extends AppCompatActivity implements VideoRecorder.OnRecordFinishListener {
	private static final String TAG = "VideoActivity";
	private VideoRecorder vr_movie;
	private VideoPlayer vp_movie;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_video);

		vr_movie = (VideoRecorder) findViewById(R.id.vr_movie);
		vr_movie.setOnRecordFinishListener(this);
		vp_movie = (VideoPlayer) findViewById(R.id.vp_movie);
	}

	@Override
	public void onRecordFinish() {
		mHandler.postDelayed(mPreplay, 1000);
	}
	
	private Handler mHandler = new Handler();
	private Runnable mPreplay = new Runnable() {
		@Override
		public void run() {
			vp_movie.init(vr_movie.getRecordFilePath());
		}
	};
	
}
