package edu.temple.tue80717.checkerboardapp;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Spinner;

public class MainActivity extends Activity implements CheckerBoard.OnFragmentInteractionListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.numarray, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);

        spinner.setAdapter(adapter);

        Button button = (Button) findViewById(R.id.button);

        GridView gridView = (GridView) findViewById(R.id.gridView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string_num_rows = (spinner.getSelectedItem().toString());
                int num_rows = Integer.parseInt(string_num_rows);


                Bundle args = new Bundle();
                args.putInt("num_rows", num_rows);
                CheckerBoard checkerboard = new CheckerBoard();
                checkerboard.setArguments(args);

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment, checkerboard);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
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



    @Override
    public void onFragmentInteraction(Uri uri) {
        doTransition();
    }

    private void doTransition(){
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment, new Fragment())
                .addToBackStack(null)
                .commit();
    }

}
