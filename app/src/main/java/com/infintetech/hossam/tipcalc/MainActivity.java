package com.infintetech.hossam.tipcalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar tipPrecent = (SeekBar) findViewById(R.id.seekBar) ;
        final TextView resultView = (TextView) findViewById(R.id.result);
        final EditText bill = (EditText) findViewById(R.id.the_bill_edit);

        tipPrecent.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            double percent;
            double billTotal;
            double result;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                percent = progress;
                billTotal = Double.parseDouble(bill.getText().toString());

                result = new Operations(billTotal , progress).calculateBill();
                resultView.setText(String.valueOf(result));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
               // Toast.makeText(MainActivity.this, result + "", Toast.LENGTH_SHORT).show();

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
