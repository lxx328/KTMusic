package com.dexter.aktmusic.ui.main.base

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.dexter.aktmusic.domain.manager.ActivityCollector

class BaseActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityCollector.addActivity(this)
    }




    override fun onDestroy() {
        super.onDestroy()
        ActivityCollector.removeActivity(this)
    }
}