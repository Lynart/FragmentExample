package com.dps924.lynart.fragmentexample;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        final FragmentOne fragOne = new FragmentOne();
        final FragmentTwo fragTwo = new FragmentTwo();

        transaction.add(R.id.fragView, fragOne, "Fragment1");
        transaction.add(R.id.fragView, fragTwo, "Fragment2");
        transaction.commit();

        Button clickButton = (Button) findViewById(R.id.button);
        clickButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //http://stackoverflow.com/questions/6495898/findviewbyid-in-fragment

                /* There are two ways to do this. One is to set the images on onCreate and track
                * which image is where. The other is to set a tag id in the xml
                * */
                ImageView imageViewOne = (ImageView)fragOne.getView().findViewById(R.id.imageView);
                String tagOne=(String)imageViewOne.getTag();

                ImageView imageViewTwo = (ImageView)fragTwo.getView().findViewById(R.id.imageView);

                if(tagOne.equals("gsxr")) {
                    imageViewOne.setTag("ride");
                    imageViewTwo.setTag("gsxr");

                    imageViewOne.setImageResource(R.drawable.ride);
                    imageViewTwo.setImageResource(R.drawable.gsxr);
                }
                else {
                    imageViewOne.setTag("gsxr");
                    imageViewTwo.setTag("ride");

                    imageViewOne.setImageResource(R.drawable.gsxr);
                    imageViewTwo.setImageResource(R.drawable.ride);
                }
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
}
