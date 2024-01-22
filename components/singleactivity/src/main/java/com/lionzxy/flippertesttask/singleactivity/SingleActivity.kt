package com.lionzxy.flippertesttask.singleactivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lionzxy.flippertesttask.core.log.LogTagProvider
import com.lionzxy.flippertesttask.core.log.info

class SingleActivity : AppCompatActivity(), LogTagProvider {
    override val TAG = "SingleActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        info { "Create new activity with hashcode: ${this.hashCode()} " + "and intent $intent" }
    }
}