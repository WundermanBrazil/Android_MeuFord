package com.wunderman.meuford.util;

import java.util.Locale;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.j256.ormlite.android.apptools.OpenHelperManager;

public class SystemApplication extends Application {
	public static final String PREFERENCES_NAME = "User Prefs";
	public static final String PREFERENCES_LANGUAGE = "Language";
	
	public static final String LANGUAGE_PORTUGUESE = "pt";
	public static final String LANGUAGE_ENGLISH = "en";
	public static final String[] LANGUAGE_LIST = new String[] { LANGUAGE_PORTUGUESE };
	public static final String LANGUAGE_DEFAULT = LANGUAGE_PORTUGUESE;
	
	private static SystemApplication instance;
	private static Activity activity;
	private static DatabaseHelper databaseHelper;
	
	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
	}

	public static Context getContext() {
		return instance.getApplicationContext();
	}

	public static Activity getActivity() {
		return activity;
	}

	public static void setActivity(Activity activity) {
		SystemApplication.activity = activity;
	}
	
	public static SharedPreferences getSharedPreferences() {
		return getContext().getSharedPreferences(PREFERENCES_NAME, 0);
	}

	public static DatabaseHelper getDatabaseHelper() {
		if (databaseHelper != null) {
			return databaseHelper;
		}

		databaseHelper = OpenHelperManager.getHelper(instance,
				DatabaseHelper.class);

		return databaseHelper;
	}

	public static String getLanguage() {
		return getSharedPreferences().getString(PREFERENCES_LANGUAGE,
				LANGUAGE_DEFAULT);
	}
	
	public static void validateLocale() {
		Locale locale = null;
		String languageDefault = null;

		languageDefault = getLanguage(); 
		
		if (languageDefault != null && languageDefault.equals(""))
			locale = new Locale(getLanguage());
		else
			locale = new Locale("pt");

		Locale.setDefault(locale);
		Configuration config = new Configuration();
		config.locale = locale;

		getContext().getResources().updateConfiguration(config,
				SystemApplication.getContext().getResources().getDisplayMetrics());
	}

	public static boolean isOnline() {
		ConnectivityManager cm = (ConnectivityManager) getContext()
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = cm.getActiveNetworkInfo();

		if (netInfo != null) {
			return netInfo.isConnectedOrConnecting();
		}
		return false;
	}
}
