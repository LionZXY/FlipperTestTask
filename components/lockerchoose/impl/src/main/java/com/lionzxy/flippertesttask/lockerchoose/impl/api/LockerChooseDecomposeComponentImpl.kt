package com.lionzxy.flippertesttask.lockerchoose.impl.api

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.lionzxy.flippertesttask.core.di.AppGraph
import com.lionzxy.flippertesttask.lockerchoose.api.LockerChooseDecomposeComponent
import com.lionzxy.flippertesttask.lockerchoose.impl.composable.LockerComposableScreen
import com.lionzxy.flippertesttask.lockerchoose.impl.viewmodel.LockerViewModel
import com.squareup.anvil.annotations.ContributesBinding
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import javax.inject.Provider

class LockerChooseDecomposeComponentImpl @AssistedInject constructor(
    @Assisted componentContext: ComponentContext,
    @Assisted private val tabName: String,
    private val lockerViewModelProvider: Provider<LockerViewModel>
) : LockerChooseDecomposeComponent(componentContext) {
    private val lockerViewModel = instanceKeeper.getOrCreate { lockerViewModelProvider.get() }

    @Composable
    override fun Render() {
        val lockerSet by lockerViewModel.getLockers().collectAsState()
        Column(
            Modifier.fillMaxSize()
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "$tabName tab",
                fontSize = 32.sp,
                textAlign = TextAlign.Start
            )
            LockerComposableScreen(lockerSet)
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