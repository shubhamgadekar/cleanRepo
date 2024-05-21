package com.alpha.cleanRepo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alpha.cleanRepo.R
import com.alpha.cleanRepo.activity.HomeScreenActivity
import com.alpha.cleanRepo.viewModel.HomeScreenViewModel

class SecondFragment : Fragment() {

    lateinit var detailsViewModel: HomeScreenViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        (requireActivity() as HomeScreenActivity).appComponent.inject(this)
        detailsViewModel = (requireActivity() as HomeScreenActivity).viewModel


        return view
    }
}