package com.wunderman.meuford.fragments;

import com.wunderman.meuford.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentActionBar extends Fragment {
	
	private View view;
	private TextView text;
		
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		this.view = inflater.inflate(R.layout.fragment_action_bar, container, false);
		return this.view;
	}	
	
	public void setTitle(String title)
	{
		this.text = (TextView)this.view.findViewById(R.id.ActionBarText);
		this.text.setText(title);
	}
	
	public void setButton(int itemResource)
	{
		setButton(itemResource, 0, "");
	}
	
	public void setButton(int itemResource, int resource)
	{
		setButton(itemResource, resource, "");
	}
	
	public void setButton(int itemResource, int resource, String text)
	{
		Button button = (Button)this.view.findViewById(itemResource);
		
		if (button != null)
		{
			if (resource > 0)
			{
				button.setBackgroundResource(resource);
			}
			
			if (text != "")
			{
				button.setText(text);
			}
			
			button.setVisibility(View.VISIBLE);
		}
	}

	public Button getButton(int itemResource)
	{
		return (Button)this.view.findViewById(itemResource);
	} 
}