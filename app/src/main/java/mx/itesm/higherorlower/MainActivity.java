package mx.itesm.higherorlower;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public int RANDOMNUMBER = 0;
    public int COUNTERTRIES = 0;
    public boolean WASGUESSED = false;
    public int randomNumbers()
    {
        int min = 0;
        int max = 20;
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt((max - min)+1) + min;
        return randomNumber;
    }

    public void showMe(View view)
    {
        int userNumber = 0;
        EditText field = (EditText)findViewById(R.id.numberInput);
        userNumber = Integer.parseInt(field.getText().toString());
        TextView textShown = (TextView)findViewById(R.id.Label3);
        Button guessButton = (Button)findViewById(R.id.button);
        Log.d("MainActivity" + RANDOMNUMBER , field.getText().toString());


        if (WASGUESSED)
        {
            field.setText("");
            textShown.setText("");
            guessButton.setText("GUESS IT!");
            COUNTERTRIES = 0;
            RANDOMNUMBER = randomNumbers();
            WASGUESSED = false;

        }
        else
        {
            if(userNumber == RANDOMNUMBER)
            {
                textShown.setText("It took you " + COUNTERTRIES + " tries, to guess the number ");
                guessButton.setText("Clear");
                WASGUESSED = true;
            }
            else if (userNumber < RANDOMNUMBER)
            {
                COUNTERTRIES++;
                textShown.setText("The number you gave is smaller than mine");
            }
            else if (userNumber > RANDOMNUMBER)
            {
                COUNTERTRIES++;
                textShown.setText("The number you gave is bigger than mine");
            }

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        RANDOMNUMBER = randomNumbers();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
