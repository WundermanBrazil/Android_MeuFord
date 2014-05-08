package com.wunderman.meuford;

import com.wunderman.meuford.fragments.FragmentActionBar;
import com.wunderman.meuford.util.SystemApplication;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends FragmentActivity {

	private String mName;
	private String mCPF;
	private String mEmail;
	private String mBirth;
	private String mPassword;
	private String mPasswordConfirm;

	private EditText mNameView;
	private EditText mCPFView;
	private EditText mEmailView;
	private EditText mBirthView;
	private EditText mPasswordView;
	private EditText mPasswordConfirmView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		SystemApplication.setActivity(this);
		setContentView(R.layout.activity_register);
		
		//Configura a action bar
		SetUpActionBar();
		
		//Recupera o input para utilização posterior
		mNameView = (EditText) findViewById(R.id.inputName);
		mCPFView = (EditText) findViewById(R.id.inputCPF);
		mBirthView = (EditText) findViewById(R.id.inputBirth);
		mEmailView = (EditText) findViewById(R.id.inputEmail);
		mPasswordView = (EditText) findViewById(R.id.inputPassword);
		mPasswordConfirmView = (EditText) findViewById(R.id.inputPasswordConfirm);
	}
	
	private void SetUpActionBar()
	{
		FragmentManager fragmentManager = this.getSupportFragmentManager();
		FragmentActionBar fragment = (FragmentActionBar)fragmentManager.findFragmentById(R.id.fragmentActionBar);
		
		//Configura os botões
		String txtButton = getString(R.string.text_right_button_action_bar_activity_register);
		fragment.setButton(R.id.ActionBarButtonRight, R.drawable.btn_blue, txtButton);
		
		Button btnRight = fragment.getButton(R.id.ActionBarButtonRight);
		btnRight.setOnClickListener(
				new OnClickListener() {
					@Override
					public void onClick(View v) {
						onClickRegister();
					}
				}
		);
		
		//Configure Title
		String title = getString(R.string.title_screen_activity_register);
		fragment.setTitle(title);
	}
	
	private void onClickRegister()
	{
		//Reset errors.
		this.mNameView.setError(null);
		this.mCPFView.setError(null);
		this.mBirthView.setError(null);
		this.mEmailView.setError(null);
		this.mPasswordView.setError(null);
		this.mPasswordConfirmView.setError(null);
		
		//Restore values at the time of the login attempt.
		this.mName = this.mNameView.getText().toString();
		this.mCPF = this.mCPFView.getText().toString();
		this.mBirth = this.mBirthView.getText().toString();
		this.mEmail = this.mEmailView.getText().toString();
		this.mPassword = this.mPasswordView.getText().toString();
		this.mPasswordConfirm = this.mPasswordConfirmView.getText().toString();
		
		boolean cancel = false;
		View focusView = null;
		String errorMessage = "";
		
		//Check Name
		if (TextUtils.isEmpty(this.mName)) {
			errorMessage = getString(R.string.error_field_required);
			this.mNameView.setError(errorMessage);
			focusView = this.mNameView;
			cancel = true;
		}
		
		//Check Email
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
			//TODO: Implementar o cadastro de usuário
		}
	}
}