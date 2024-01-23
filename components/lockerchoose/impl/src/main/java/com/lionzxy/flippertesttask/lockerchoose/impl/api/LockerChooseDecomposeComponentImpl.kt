package com.lionzxy.flippertesttask.lockerchoose.impl.api

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.ComponentContext
import com.lionzxy.flippertesttask.core.di.AppGraph
import com.lionzxy.flippertesttask.lockerchoose.api.LockerChooseDecomposeComponent
import com.squareup.anvil.annotations.ContributesBinding
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class LockerChooseDecomposeComponentImpl @AssistedInject constructor(
    @Assisted componentContext: ComponentContext,
    @Assisted private val tabName: String
) : LockerChooseDecomposeComponent(componentContext) {

    @Composable
    override fun Render() {
        Box(
            Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "$tabName tab",
                fontSize = 32.sp,
                textAlign = TextAlign.Center
            )
        }
    }

    @AssistedFactory
    @ContributesBinding(AppGraph::class, LockerChooseDecomposeComponent.Factory::class)
    interface Factory : LockerChooseDecomposeComponent.Factory {
        override fun invoke(
            componentContext: ComponentContext,
            tabName: String
        ): LockerChooseDecomposeComponentImpl
    }
}