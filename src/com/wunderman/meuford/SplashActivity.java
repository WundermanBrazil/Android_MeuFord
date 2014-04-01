package com.wunderman.meuford;

import com.wunderman.meuford.util.SystemApplication;
import com.wunderman.meuford.util.SystemUiHider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class SplashActivity extends Activity implements Runnable {
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.activity_splash);

		SystemApplication.validateLocale();
		SystemApplication.setActivity(this);
				
		Handler h = new Handler();
		h.postDelayed(this, 3000);
	}
	
	public void run(){
    	startActivity(new Intent().setClass(this, ForgotPasswordActivity.class));
		finish();
	}
    
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}
		
    @Override
	public void onStop() {
		super.onStop();
	}
}
