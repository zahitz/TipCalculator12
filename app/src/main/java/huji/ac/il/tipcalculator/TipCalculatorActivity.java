package huji.ac.il.tipcalculator;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class TipCalculatorActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tip_calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Called when the user clicks the Calculate button.
     * @param view
     */
    public void calculateTip(View view){
        EditText billIn = (EditText) findViewById(R.id.edtBillAmount);
        CheckBox round = (CheckBox) findViewById(R.id.chkRound);
        TextView tipPrnt = (TextView) findViewById(R.id.txtTipResult);
        double ret =  Double.parseDouble(billIn.getText().toString()) * 0.12;
        if(round.isChecked()) {
            ret = Math.round(ret);

        }
        if (ret == (long) ret) {
            tipPrnt.setText(String.valueOf((long) ret) + "$");
        } else {
            tipPrnt.setText(String.valueOf(ret) + "$");
        }
    }
}
