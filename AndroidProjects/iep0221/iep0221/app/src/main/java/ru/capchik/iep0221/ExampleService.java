package ru.capchik.iep0221;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ExampleService extends IntentService {
    private static final String TAG = "EXAMPLE_SERVICE";

    public ExampleService() {
        super("ExampleService");
    }
    public ExampleService(String name) {
        super(name);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "STARTED");
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "DESTROY");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        int id = intent.getIntExtra("id", 1);
        Messenger handler = (Messenger) intent.getExtras().get("handler");
        Log.i(TAG, "START COMMAND handler is null? " + (handler == null) + " id is " + (id));
        String address = "https://jsonplaceholder.typicode.com/comments/" + id;
        try {
            URL url = new URL(address);
            InputStream inputStream = url.openStream();
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()) {
                Log.i(TAG, scanner.nextLine());
            }
            Log.i(TAG, "DONE!!!! ❤❤❤");
            Message message = new Message();
            message.arg1 = id * 4;
            handler.send(message);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}