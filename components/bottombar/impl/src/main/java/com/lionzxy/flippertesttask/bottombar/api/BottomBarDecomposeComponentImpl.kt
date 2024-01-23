package com.lionzxy.flippertesttask.bottombar.api

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.flipperdevices.core.decompose.DecomposeComponent
import com.lionzxy.flippertesttask.bottombar.BottomBarDecomposeComponent
import com.lionzxy.flippertesttask.bottombar.composable.ComposableBottomBarScreen
import com.lionzxy.flippertesttask.bottombar.config.BottomBarConfig
import com.lionzxy.flippertesttask.bottombar.config.BottomBarEnum
import com.lionzxy.flippertesttask.core.di.AppGraph
import com.lionzxy.flippertesttask.lockerchoose.api.LockerChooseDecomposeComponent
import com.squareup.anvil.annotations.ContributesBinding
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class BottomBarDecomposeComponentImpl @AssistedInject constructor(
    @Assisted componentContext: ComponentContext,
    private val lockerChooseDecomposeComponentFactory: LockerChooseDecomposeComponent.Factory
) : BottomBarDecomposeComponent(), ComponentContext by componentContext {
    private val navigation = StackNavigation<BottomBarConfig>()

    private val stack: Value<ChildStack<BottomBarConfig, DecomposeComponent>> =
        childStack(
            source = navigation,
            serializer = BottomBarConfig.serializer(),
            initialConfiguration = BottomBarConfig.Device,
            childFactory = ::child,
        )

    @Composable
    @Suppress("NonSkippableComposable")
    override fun Render(modifier: Modifier) {
        val childStack by stack.subscribeAsState()

        ComposableBottomBarScreen(
            childStack = childStack,
            modifier = Modifier.fillMaxSize(),
            onSelect = {
                when (it) {
                    BottomBarEnum.DEVICE -> navigation.bringToFront(BottomBarConfig.Device)
                    BottomBarEnum.ARCHIVE -> navigation.bringToFront(BottomBarConfig.Archive)
                    BottomBarEnum.HUB -> navigation.bringToFront(BottomBarConfig.Hub)
                }
            }
        )
    }


    private fun child(
        config: BottomBarConfig,
        componentContext: ComponentContext
    ): DecomposeComponent = when (config) {
        BottomBarConfig.Archive -> lockerChooseDecomposeComponentFactory(
            componentContext = componentContext,
            tabName = config.enum.tabName
        )

        BottomBarConfig.Device -> lockerChooseDecomposeComponentFactory(
            componentContext = componentContext,
            tabName = config.enum.tabName
        )

        is BottomBarConfig.Hub -> lockerChooseDecomposeComponentFactory(
            componentContext = componentContext,
            tabName = config.enum.tabName
        )
    }

    @AssistedFactory
    @ContributesBinding(AppGraph::class, BottomBarDecomposeComponent.Factory::class)
    fun interface Factory : BottomBarDecomposeComponent.Factory {
        override fun invoke(
            componentContext: ComponentContext
        ): BottomBarDecomposeComponentImpl
    }
}