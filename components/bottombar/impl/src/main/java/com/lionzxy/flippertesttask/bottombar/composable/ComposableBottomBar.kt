package com.lionzxy.flippertesttask.bottombar.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import com.lionzxy.flippertesttask.bottombar.config.BottomBarEnum
import com.lionzxy.flippertesttask.bottombar.impl.R

@Composable
fun ComposableBottomBar(
    selectedTab: BottomBarEnum,
    onSelect: (BottomBarEnum) -> Unit
) = TabRow(
    modifier = Modifier.fillMaxWidth(),
    selectedTabIndex = BottomBarEnum.entries.indexOf(selectedTab),
    backgroundColor = colorResource(R.color.bottombar_background_color),
    contentColor = Color.White
) {
    BottomBarEnum.entries.forEach { bottomBarTab ->
        Tab(
            onClick = { onSelect(bottomBarTab) },
            selected = selectedTab == bottomBarTab,
            text = { Text(bottomBarTab.tabName) },
            icon = {
                Icon(
                    painter = painterResource(bottomBarTab.iconId),
                    contentDescription = null
                )
            }
        )
    }
}