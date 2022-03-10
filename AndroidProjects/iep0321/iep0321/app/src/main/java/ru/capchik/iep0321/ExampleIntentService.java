package ru.capchik.iep0321;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
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

public class ExampleIntentService extends IntentService {
    private static final String TAG = "ExampleIntentService";

    public ExampleIntentService() {
        this("ExampleIntentService");
    }

    public ExampleIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        int id = intent.getIntExtra("id", 1);
        Log.i(TAG, "on start command, id = " + id);
        Bundle bundle = intent.getExtras();
        Messenger messenger = (Messenger) bundle.get("messenger");
        String address = "https://jsonplaceholder.typicode.com/comments/" + id;
        try {
            URL url = new URL(address);
            InputStream inputStream = url.openStream();
            Scanner scanner = new Scanner(inputStream);
            StringBuilder output = new StringBuilder();
            while (scanner.hasNextLine()) {
                output.append(scanner.nextLine());
            }
            Message message = new Message();
            message.arg1 = id * 5;
            Bundle bundle1 = new Bundle();
            bundle1.putString("output", output.toString());
            message.setData(bundle1);
            messenger.send(message);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}