package info.acidflow.waveplay.exceptions.file;

import android.util.Log;

import info.acidflow.waveplay.BuildConfig;
import io.fabric.sdk.android.Fabric;

/**
 * Created by paul on 16/10/14.
 */
public class AbstractWavePlayFileException extends Exception {

    final public static String LOG_TAG = AbstractWavePlayFileException.class.getSimpleName();

    public AbstractWavePlayFileException() {
        super();
    }

    public AbstractWavePlayFileException(String detailMessage) {
        super(detailMessage);
    }

    public AbstractWavePlayFileException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public AbstractWavePlayFileException(Throwable throwable) {
        super(throwable);
    }

    public void handleException(){
        if( BuildConfig.DEBUG ) {
            Log.e(LOG_TAG, "Exception raised by WavePlayServer", this);
        }else {
            Fabric.getLogger().e(LOG_TAG, getMessage(), this );
        }
    }
}
