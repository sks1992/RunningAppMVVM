package sk.sandeep.runningappmvvm.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import sk.sandeep.runningappmvvm.R
import sk.sandeep.runningappmvvm.databinding.FragmentSetupBinding


class SetupFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentSetupBinding.inflate(inflater, container, false)

        binding.tvContinue.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_setupFragment_to_runFragment)
        }
        return binding.root
    }
}