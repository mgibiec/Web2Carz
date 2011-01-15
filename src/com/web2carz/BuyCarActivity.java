package com.web2carz;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;

public class BuyCarActivity extends Activity {
	/**
	 * @see android.app.Activity#onCreate(Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.buy_car);
	}

	public void scanBarcode(View v) {
		ZxingIntentIntegrator.initiateScan(this);

	}

	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		ZxingIntentResult res = ZxingIntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
		if (res != null) {
			Toast.makeText(this, res.getContents(),	Toast.LENGTH_LONG).show();
			Intent webIntent = new Intent(Intent.ACTION_VIEW,
					Uri.parse(res.getContents()));
			startActivity(webIntent);
		}
		else {

		}
	}
}
