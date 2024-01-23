package com.lionzxy.flippertesttask.lockerchoose.impl.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.lionzxy.flippertesttask.lockerchoose.impl.config.LockerModel
import kotlinx.collections.immutable.PersistentSet

@Composable
fun LockerComposableScreen(
    lockerSet: PersistentSet<LockerModel>
) {
    val lockerList = remember(lockerSet) { lockerSet.toList() }
    LazyColumn {
        items(
            items = lockerList,
            key = { it.lockerNumber }
        ) { lockerItem ->
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color.Gray)
            )
            Row(Modifier.padding(16.dp)) {
                Text(
                    modifier = Modifier
                        .padding()
                        .weight(1f),
                    text = "Locker #${lockerItem.lockerNumber}"
                )
                Text(
                    text = if (lockerItem.keyNumber != null) {
                        "Key #${lockerItem.keyNumber}"
                    } else {
                        "Key not found"
                    }
                )
            }
        }
    }

}