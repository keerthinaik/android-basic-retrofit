package com.example.btcareerdemo.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.btcareerdemo.view.activity.MainActivity
import com.example.btcareerdemo.R
import com.example.btcareerdemo.databinding.FragmentMainBinding
import com.example.btcareerdemo.viewmodel.MainViewModel


/**
 * A simple fragment to display start fetch and status texts
 */
class MainFragment : Fragment() {

    private lateinit var mainViewModel: MainViewModel
    private var _binding: FragmentMainBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mainViewModel =
            ViewModelProvider(this).get(MainViewModel::class.java)
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        _binding!!.lifecycleOwner = viewLifecycleOwner
        _binding!!.viewmodel = mainViewModel
        _binding!!.startButton.setOnClickListener {
            onStartButtonClicked(it)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onStartButtonClicked(view: View) {
        if (mainViewModel.buttonText.value.equals("start", ignoreCase = true)) {
            mainViewModel.statusText.value = "data started downloading"
            mainViewModel.startDownloading()
        } else {
            val myActivity : MainActivity = activity as MainActivity
            myActivity.storeUsersData()
            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_userListFragment)
        }
    }
}