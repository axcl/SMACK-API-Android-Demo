package com.demoapp.messenger.messenger;

        import android.content.ComponentName;
        import android.content.Intent;
        import android.content.ServiceConnection;
        import android.os.IBinder;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.EditText;
        import com.demoapp.messenger.R;


public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    private ConnectXmpp mService;
    private View view;
    private boolean mBounded;
    private final ServiceConnection mConnection = new ServiceConnection() {

        @SuppressWarnings("unchecked")
        @Override
        public void onServiceConnected(final ComponentName name,
                                       final IBinder service) {
            mService = ((LocalBinder<ConnectXmpp>) service).getService();
            mBounded = true;
            Log.d(TAG, "onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(final ComponentName name) {
            mService = null;
            mBounded = false;
            Log.d(TAG, "onServiceDisconnected");
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    //Click Handler for Login Button
    public void onClickLoginBtn(View view)
    {
       try {
           EditText userId = (EditText) findViewById(R.id.txtUser);
           EditText userPwd = (EditText) findViewById(R.id.txtPwd);
           String userName = userId.getText().toString();
           String passWord = userPwd.getText().toString();
           Intent intent = new Intent(getBaseContext(),ConnectXmpp.class );
           intent.putExtra("user",userName);
           intent.putExtra("pwd",passWord);
           startService(intent);



           //mService.connectConnection(intent);
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }
    }




}
