package com.wunderman.meuford;

import com.wunderman.meuford.util.SystemApplication;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class ForgotPasswordActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		SystemApplication.setActivity(this);
		setContentView(R.layout.activity_forgot_password);
	}
}
