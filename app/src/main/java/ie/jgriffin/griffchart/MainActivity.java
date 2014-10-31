package ie.jgriffin.griffchart;

import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

import java.util.ArrayList;
import java.util.Random;

import ie.jgriffin.griffchart.lib.BarChart;
import ie.jgriffin.griffchart.lib.ChartPoint;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

        @Override
        public void onResume() {
            super.onResume();
            BarChart chart = (BarChart) getView().findViewById(R.id.barChart);

            Random random = new Random();
            ArrayList<ChartPoint> points = new ArrayList<ChartPoint>();

            for(int i = 0; i <= 20; i++){
                addRandomPoint(points, random);
            }

            chart.setChartPoints(points);
        }

        private void addRandomPoint(ArrayList<ChartPoint> points, Random random){
            points.add(new ChartPoint(getRandomIntToOneHundred(random), getRandomPaint(random)));
        }

        private int getRandomIntToOneHundred(Random random){
            return random.nextInt(101);
        }

        private Paint getRandomPaint(Random random){

            Paint p = new Paint();
            p.setAntiAlias(true);
            p.setARGB(random.nextInt(256), random.nextInt(256), random.nextInt(256), random.nextInt(256));
            p.setStyle(Paint.Style.FILL);
            return p;
        }
    }
}
