package com.web2carz;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
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

	public void enterVin(View v) {
		//startActivity(new Intent(BuyCarActivity.this, InputVinActivity.class));
		//final AlertDialog dialog = new AlertDialog;

		final AlertDialog.Builder vinInputDialog = new AlertDialog.Builder(this);
		final EditText input = new EditText(this);

		/*input.setOnFocusChangeListener(new View.OnFocusChangeListener() {
		    @Override
		    public void onFocusChange(View v, boolean hasFocus) {
		        if (hasFocus)
		        	vinInputDialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
		        }
		    }
		});
		*/

		vinInputDialog.setView(input);
		vinInputDialog.setTitle("Enter Vin");
		vinInputDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				String value = input.getText().toString().trim();
				Toast.makeText(getApplicationContext(), "Searching for " + value,
						Toast.LENGTH_SHORT).show();
				value = "http://www.web2carz.com/32363933/2009/infiniti/fx50/used-cars/for-sale";
				Intent webIntent = new Intent(Intent.ACTION_VIEW,
						Uri.parse(value));
				startActivity(webIntent);
			}
		});

		vinInputDialog.setNegativeButton("Cancel",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						dialog.cancel();
					}
				});
		vinInputDialog.show();
	}
	public void scanVIN(View v) {
		ZxingIntentIntegrator.initiateScan(this);
	}

	public void scanBarcode(View v) {
		ZxingIntentIntegrator.initiateScan(this);
	}

	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		ZxingIntentResult res = ZxingIntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
		if (res != null && res.getContents() != null) {
			Toast.makeText(this, res.getContents(),	Toast.LENGTH_LONG).show();
			Intent webIntent = new Intent(Intent.ACTION_VIEW,
					Uri.parse(res.getContents()));
			startActivity(webIntent);
		}
		else {

		}
	}
}
