package com.lionzxy.flippertesttask.singleactivity.di

import com.lionzxy.flippertesttask.core.di.AppGraph
import com.lionzxy.flippertesttask.singleactivity.SingleActivity
import com.squareup.anvil.annotations.ContributesTo

@ContributesTo(AppGraph::class)
interface SingleActivityComponent {
    fun inject(activity: SingleActivity)
}
