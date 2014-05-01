package com.example.ch4;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;

public class ContactSettingsActivity extends Activity {

	private static final String PREFS_NAME = "MyContactListPreferences";
	private static final String SORT_BY_CONTACT = "contactname";
	private static final String SORT_BY_CITY = "city";
	private static final String SORT_BY_BIRTHDAY = "birthday";
	private static final String SORT_ORDER_ASCENDING = "ASC";
	private static final String SORT_ORDER_DESCENDING = "DESC";
	private static final String BG_BLUE = "blue";
	private static final String BG_GREY = "grey";
	private static final String BG_YELLOW = "yellow";
	private static final String KEY_SORT_BY = "sortfield";
	private static final String KEY_SORT_ORDER = "sortorder";
	private static final String KEY_BG_COLOR = "background";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_settings);
		
		initSettings();
		initSortByClick();
		initSortOrderClick();
		initBgClick();
		initListButton();
		initMapButton();
		initSettingsButton();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.contact_settings, menu);
		return true;
	}

	private void initSettings() {
		String sortBy = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).getString(KEY_SORT_BY, SORT_BY_CONTACT);
		String sortOrder = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).getString(KEY_SORT_ORDER, SORT_ORDER_ASCENDING);
		String bgColor = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).getString(KEY_BG_COLOR, BG_BLUE);

		RadioButton rbName = (RadioButton) findViewById(R.id.radioName);
		RadioButton rbCity = (RadioButton) findViewById(R.id.radioCity);
		RadioButton rbBirthDay = (RadioButton) findViewById(R.id.radioBirthday);
		if (sortBy.equalsIgnoreCase(SORT_BY_CONTACT)) {
			rbName.setChecked(true);
		}
		else if (sortBy.equalsIgnoreCase(SORT_BY_CITY)) {
			rbCity.setChecked(true);
		}
		else {
			rbBirthDay.setChecked(true);
		}			

		RadioButton rbAscending = (RadioButton) findViewById(R.id.radioAscending);
		RadioButton rbDescending = (RadioButton) findViewById(R.id.radioDescending);
		if (sortOrder.equalsIgnoreCase(SORT_ORDER_ASCENDING)) {
			rbAscending.setChecked(true);
		}
		else {
			rbDescending.setChecked(true);
		}

		RelativeLayout container = (RelativeLayout) findViewById(R.id.settingsContainer);
		RadioButton rbBlue = (RadioButton) findViewById(R.id.radioBlue);
		RadioButton rbGrey = (RadioButton) findViewById(R.id.radioGrey);
		RadioButton rbYellow = (RadioButton) findViewById(R.id.radioYellow);
		if (bgColor.equalsIgnoreCase(BG_BLUE)) {
			rbBlue.setChecked(true);
			container.setBackgroundResource(R.color.background_blue);
		}
		else if (bgColor.equalsIgnoreCase(BG_GREY)) {
			rbGrey.setChecked(true);
			container.setBackgroundResource(R.color.background_grey);
		}
		else {
			rbYellow.setChecked(true);
			container.setBackgroundResource(R.color.background_yellow);
		}	
	}
	
	private void initSortByClick() {
		RadioGroup rgSortBy = (RadioGroup) findViewById(R.id.radioGroup1);
		rgSortBy.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				RadioButton rbName = (RadioButton) findViewById(R.id.radioName);
				RadioButton rbCity = (RadioButton) findViewById(R.id.radioCity);
//				RadioButton rbBirthDay = (RadioButton) findViewById(R.id.radioBirthdate);
				if (rbName.isChecked()) {
					getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit().putString(KEY_SORT_BY, SORT_BY_CONTACT).commit();
				}
				else if (rbCity.isChecked()) {
					getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit().putString(KEY_SORT_BY, SORT_BY_CITY).commit();
				}
				else {
					getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit().putString(KEY_SORT_BY, SORT_BY_BIRTHDAY).commit();
				}			
			}		
		});
	}

	private void initSortOrderClick() {
		RadioGroup rgSortOrder = (RadioGroup) findViewById(R.id.radioGroup2);
		rgSortOrder.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				RadioButton rbAscending = (RadioButton) findViewById(R.id.radioAscending);
//				RadioButton rbDescending = (RadioButton) findViewById(R.id.radioDescending);
				if (rbAscending.isChecked()) {
					getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit().putString(KEY_SORT_ORDER, SORT_ORDER_ASCENDING).commit();
				}
				else {
					getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit().putString(KEY_SORT_ORDER, SORT_ORDER_DESCENDING).commit();
				}			
			}		
		});
	}

	private void initBgClick() {
		RadioGroup rgBg = (RadioGroup) findViewById(R.id.radioGroup3);
		rgBg.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				RelativeLayout container = (RelativeLayout) findViewById(R.id.settingsContainer);
				RadioButton rbBlue = (RadioButton) findViewById(R.id.radioBlue);
				RadioButton rbGrey = (RadioButton) findViewById(R.id.radioGrey);
				if (rbBlue.isChecked()) {
					getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit().putString(KEY_BG_COLOR, BG_BLUE).commit();
					container.setBackgroundResource(R.color.background_blue);
				}
				else if (rbGrey.isChecked()) {
					getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit().putString(KEY_BG_COLOR, BG_GREY).commit();
					container.setBackgroundResource(R.color.background_grey);
				}
				else {
					getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit().putString(KEY_BG_COLOR, BG_YELLOW).commit();
					container.setBackgroundResource(R.color.background_yellow);
				}	
			}		
		});
	}
	
	private void initListButton() {
        ImageButton list = (ImageButton) findViewById(R.id.imageButtonList);
        list.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
    			Intent intent = new Intent(ContactSettingsActivity.this, ContactListActivity.class);
    			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
   			startActivity(intent);
            }
        });
	}

	private void initSettingsButton() {
        ImageButton list = (ImageButton) findViewById(R.id.imageButtonSettings);
        list.setEnabled(false);
	}

	private void initMapButton() {
        ImageButton list = (ImageButton) findViewById(R.id.imageButtonMap);
        list.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
        		Intent intent = new Intent(ContactSettingsActivity.this, ContactMapActivity.class);
    			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		   		startActivity(intent);
            }
        });
	}

	
}
