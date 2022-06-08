package sk.sandeep.runningappmvvm.ui.view_model

import androidx.lifecycle.ViewModel
import sk.sandeep.runningappmvvm.repository.RunnerRepository
import javax.inject.Inject

class RunnerViewModel @Inject constructor(
    val runnerRepository: RunnerRepository
) : ViewModel() {
}