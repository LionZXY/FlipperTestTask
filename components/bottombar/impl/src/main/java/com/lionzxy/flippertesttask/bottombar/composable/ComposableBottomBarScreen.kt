package com.lionzxy.flippertesttask.bottombar.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.router.stack.ChildStack
import com.flipperdevices.core.decompose.DecomposeComponent
import com.lionzxy.flippertesttask.bottombar.config.BottomBarConfig
import com.lionzxy.flippertesttask.bottombar.config.BottomBarEnum
import com.lionzxy.flippertesttask.bottombar.impl.R

@Composable
fun ComposableBottomBarScreen(
    childStack: ChildStack<BottomBarConfig, DecomposeComponent>,
    onSelect: (BottomBarEnum) -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        bottomBar = {
            ComposableBottomBar(
                selectedTab = childStack.active.configuration.enum,
                onSelect = onSelect
            )
        }
    ) { paddingValues ->
        Box(Modifier.padding(paddingValues)) {
            Children(
                stack = childStack,
            ) {
                it.instance.Render()
            }
        }
    }
}