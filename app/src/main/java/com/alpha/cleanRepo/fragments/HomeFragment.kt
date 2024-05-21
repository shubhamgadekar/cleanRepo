package com.alpha.cleanRepo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alpha.cleanRepo.R
import com.alpha.cleanRepo.activity.HomeScreenActivity
import com.alpha.cleanRepo.viewModel.HomeScreenViewModel
import javax.inject.Inject

class HomeFragment : Fragment() {

    lateinit var viewModel: HomeScreenViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        (requireActivity() as HomeScreenActivity).appComponent.inject(this)
        viewModel = (requireActivity() as HomeScreenActivity).viewModel

        return view
    }
}