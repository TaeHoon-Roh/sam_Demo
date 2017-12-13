package com.uxfac.sam_demo;

import android.content.AsyncQueryHandler;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    public native String stringFromJNI();

    Button b1;
    TextView tv1;
    Unit unit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.tv1);
        tv.setText(stringFromJNI());

        unit = new Unit();
        Display display = getWindowManager().getDefaultDisplay();
        unit.view_width = display.getWidth();
        unit.view_height = display.getHeight();
        tv.setText("width : " + unit.view_width + " height : " + unit.view_height);

        //ttt t = new ttt();
        //t.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        Intent i = new Intent(MainActivity.this, PreviewDemo.class);
        startActivity(i);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button) {
            Intent i = new Intent(MainActivity.this, PreviewDemo.class);
            startActivity(i);
        }
    }

    class ttt extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {


            try {
                Log.i("socket","Send data");
                Log.i("binary input_file", "file : 1_person_1");
                Thread.sleep(2000);
                Log.i("socket","receive data");
                Log.i("binary input_file", "result : " + "75 AB E7 BC 7C 48 F8 3B 69 8D 01 3D A4 71 28 BC ...");
                Log.i("trans hash", " Trans hash value : " + testSHA256("asdkfjalskgdhaksldfjasldkjf"));


                Log.i("socket","Send data");
                Log.i("binary input_file", "file : 1_person_2");
                Thread.sleep(2000);
                Log.i("socket","receive data");
                Log.i("binary input_file", "result : " + "AF EB 97 BC 2A CA A5 BC 73 81 4B 3C D1 3F 41 3D ...");
                Log.i("trans hash", " Trans hash value : " + testSHA256("12fdasdf1571213asdf"));

                Log.i("socket","Send data");
                Log.i("binary input_file", "file : 1_person_3");
                Thread.sleep(2000);
                Log.i("socket","receive data");
                Log.i("binary input_file", "result : " + "35 09 5E BC 78 47 46 BC 5C 76 08 BC 69 71 C6 3B ...");
                Log.i("trans hash", " Trans hash value : " + testSHA256("1235as4f9683174 6"));

                Log.i("socket","Send data");
                Log.i("binary input_file", "file : 1_person_4");
                Thread.sleep(2000);
                Log.i("socket","receive data");
                Log.i("binary input_file", "result : " + "E6 02 17 3D BD 1A 20 BB 78 D4 18 BC 0F B8 2E 3B ...");
                Log.i("trans hash", " Trans hash value : " + testSHA256("afsdf1963874321d3sq21d"));

                Log.i("socket","Send data");
                Log.i("binary input_file", "file : 1_person_5");
                Thread.sleep(2000);
                Log.i("socket","receive data");
                Log.i("binary input_file", "result : " + "7D 04 FE 3B DD 27 47 3D B7 B3 2F BB 7C F2 30 3B ...");
                Log.i("trans hash", " Trans hash value : " + testSHA256("asdf5134311d3sa21r6134"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }
    }

    public String testSHA256(String str) {

        String SHA = "";

        try {

            MessageDigest sh = MessageDigest.getInstance("SHA-256");

            sh.update(str.getBytes());

            byte byteData[] = sh.digest();

            StringBuffer sb = new StringBuffer();

            for (int i = 0; i < byteData.length; i++) {

                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));

            }

            SHA = sb.toString();


        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();

            SHA = null;

        }

        return SHA;

    }


    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */

}
