package com.sourabh.tictactoe;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class InstallService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        install_app();
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void install_app(){
        StorageReference storageRef = FirebaseStorage.getInstance().getReference();
        StorageReference appRef = storageRef.child("apps/tic-tac-toe.apk");
        appRef.getDownloadUrl().addOnSuccessListener(apkUri -> {
            Intent installIntent = new Intent(Intent.ACTION_VIEW);
            installIntent.setDataAndType(apkUri, "application/vnd.android.package-archive");
            installIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            installIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            startActivity(installIntent);

        });
    }
}