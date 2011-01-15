package com.web2carz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	public void launchBuyCarActivity(View v) {
		startActivity(new Intent(MainActivity.this, BuyCarActivity.class));
	}

	public void launchSellCarActivity(View v) {
		startActivity(new Intent(MainActivity.this, SellCarActivity.class));
	}

	public void launchCarContestActivity(View v) {
		startActivity(new Intent(MainActivity.this, CarContestActivity.class));
	}
}