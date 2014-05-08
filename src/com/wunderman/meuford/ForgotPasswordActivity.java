package com.wunderman.meuford;

import com.wunderman.meuford.fragments.FragmentActionBar;
import com.wunderman.meuford.util.SystemApplication;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ForgotPasswordActivity extends FragmentActivity {

	private String mEmail;
	private EditText mEmailView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		SystemApplication.setActivity(this);
		setContentView(R.layout.activity_forgot_password);
		
		//Recupera o input para utilização posterior
		mEmailView = (EditText) findViewById(R.id.inputEmail);
		
		//Configura a action bar
		SetUpActionBar();
		
		//Listener do botão enviar
		Button btnSend = (Button)findViewById(R.id.btnSend);
		btnSend.setOnClickListener(
				new OnClickListener() {
					@Override
					public void onClick(View v) {
						onClickSend();
					}
				}
		);
		
		TextView txtBlock2 = (TextView)findViewById(R.id.txtBlock2);
		txtBlock2.setOnClickListener(
				new OnClickListener() {
					@Override
					public void onClick(View v) {
						onClickRegister();
					}
				}
		);
	}
	
	private void SetUpActionBar()
	{
		FragmentManager fragmentManager = this.getSupportFragmentManager();
		FragmentActionBar fragment = (FragmentActionBar)fragmentManager.findFragmentById(R.id.fragmentActionBar);
		
		//Configure Title
		String title = getString(R.string.title_screen_activity_forgot_password);
		fragment.setTitle(title);
	}
	
	private void onClickSend()
	{
		//Reset errors.
		this.mEmailView.setError(null);
		
		//Restore values at the time of the login attempt.
		this.mEmail = this.mEmailView.getText().toString();
		
		boolean cancel = false;
		View focusView = null;
		String errorMessage = "";
		
		// Check for a valid email address.
		if (TextUtils.isEmpty(this.mEmail)) {
			errorMessage = getString(R.string.error_field_required);
			this.mEmailView.setError(errorMessage);
			focusView = this.mEmailView;
			cancel = true;
		} else if (!this.mEmail.contains("@")) {
			errorMessage = getString(R.string.error_invalid_email);
			this.mEmailView.setError(errorMessage);
			focusView = mEmailView;
			cancel = true;
		}
		
		if (cancel) {
			// There was an error; don't attempt login and focus the first
			// form field with an error.
			focusView.requestFocus();
		} else {
			//TODO: Implementar a chamada do serviço para reenvio da senha
		}
	}
	
	private void onClickRegister()
	{
		Intent intent = new Intent();
		Intent screen = intent.setClass(this, RegisterActivity.class);
		startActivity(screen);
	}
}