package com.lionzxy.flippertesttask.bottombar.config

import androidx.annotation.DrawableRes
import com.lionzxy.flippertesttask.bottombar.impl.R

enum class BottomBarEnum(
    val tabName: String,
    @DrawableRes val iconId: Int
) {
    DEVICE("Device", R.drawable.ic_connection_unselected_bg),
    ARCHIVE("Archive", R.drawable.ic_archive),
    HUB("Hub", R.drawable.ic_hub)
}