package info.acidflow.waveplay.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import de.greenrobot.event.EventBus;
import info.acidflow.waveplay.WavePlayApp;
import info.acidflow.waveplay.bus.events.server.ServerStatusEvent;
import info.acidflow.waveplay.server.WavePlayServer;

/**
 * Created by paul on 13/10/14.
 */
public class WavePlayServerService extends Service {

    private WavePlayServer mServer;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if( mServer == null || !mServer.isAlive() ){
            mServer = new WavePlayServer();
            mServer.startServer();
        }
        WavePlayApp.getServerServiceBus().postSticky( new ServerStatusEvent( true ) );
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if( mServer != null && mServer.isAlive() ) {
            mServer.stopServer();
        }
        WavePlayApp.getServerServiceBus().postSticky( new ServerStatusEvent( false ) );
    }
}
