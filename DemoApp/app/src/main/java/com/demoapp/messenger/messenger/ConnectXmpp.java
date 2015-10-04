package com.demoapp.messenger.messenger;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;


public class ConnectXmpp extends Service {

    private String userName;
    private String passWord;
    private MyXMPP xmpp = new MyXMPP();

    public ConnectXmpp() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return new LocalBinder<ConnectXmpp>(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
            if(intent != null){
            userName = intent.getStringExtra("user");
            passWord = intent.getStringExtra("pwd");
            xmpp.init(userName, passWord);
            xmpp.connectConnection();
        }

    return 0;
    }

    @Override
    public void onDestroy() {
        xmpp.disconnectConnection();
        super.onDestroy();
    }









}
