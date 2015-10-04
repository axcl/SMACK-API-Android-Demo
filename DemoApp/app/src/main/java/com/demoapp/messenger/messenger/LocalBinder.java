package com.demoapp.messenger.messenger;

/**
 * Created by home on 10/1/2015.
 */
import java.lang.ref.WeakReference;
import android.os.Binder;
public class LocalBinder <S> extends Binder {
    private final WeakReference<S> mService;

    public LocalBinder(final S service) {
        mService = new WeakReference<S>(service);
    }

    public S getService() {
        return mService.get();
    }

}