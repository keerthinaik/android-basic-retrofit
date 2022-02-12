package com.example.btcareerdemo.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.btcareerdemo.R
import com.example.btcareerdemo.databinding.FragmentMainBinding
import com.example.btcareerdemo.databinding.FragmentUserListBinding
import com.example.btcareerdemo.model.util.LocalUserStore
import com.example.btcareerdemo.view.adapter.UserAdapter
import com.example.btcareerdemo.viewmodel.MainViewModel
import com.example.btcareerdemo.viewmodel.UserListViewModel


class UserListFragment : Fragment() {

    private lateinit var userListViewModel: UserListViewModel
    private var _binding: FragmentUserListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        userListViewModel =
            ViewModelProvider(this).get(UserListViewModel::class.java)
        userListViewModel.context = context
        _binding = FragmentUserListBinding.inflate(inflater, container, false)
        _binding!!.lifecycleOwner = viewLifecycleOwner
        _binding!!.viewmodel = userListViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userListViewModel.getUserData()?.observe(viewLifecycleOwner) {
            it?.let {
                val userAdapter = UserAdapter()
                userAdapter.setUsers(LocalUserStore.USER_LIST)
                _binding?.userList?.adapter = userAdapter
            }
        }


    }
}