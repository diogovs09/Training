package com.example.powerreceiver

import android.content.ComponentName
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {

    private lateinit var mPackageManager: PackageManager
    private lateinit var mReceiverComponentName: ComponentName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize the PackageManager and ComponentName
        mPackageManager = packageManager
        mReceiverComponentName = ComponentName(this, CustomReceiver::class.java)

    }

    override fun onStart() {
        super.onStart()
        mPackageManager.setComponentEnabledSetting(
            mReceiverComponentName, PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP
        )
    }

    override fun onStop() {
        super.onStop()
        mPackageManager.setComponentEnabledSetting(
            mReceiverComponentName, PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP
        )
    }

}