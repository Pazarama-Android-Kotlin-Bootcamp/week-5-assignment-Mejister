package com.merttoptas.retrofittutorial.ui.users
import UserAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

import com.google.android.material.snackbar.Snackbar
import com.merttoptas.retrofittutorial.ui.posts.viewmodel.UserViewEvent
import com.merttoptas.retrofittutorial.ui.posts.viewmodel.UsersViewModel
import com.merttoptas.retrofittutorial.data.model.DataState
import com.merttoptas.retrofittutorial.databinding.FragmentUserBinding
import com.merttoptas.retrofittutorial.ui.loadingprogress.LoadingProgressBar

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UsersFragment : Fragment() {
    lateinit var loadingProgressBar: LoadingProgressBar
    private lateinit var binding: FragmentUserBinding
    private val viewModel by viewModels<UsersViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentUserBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadingProgressBar = LoadingProgressBar(requireContext())

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.userLiveData.observe(viewLifecycleOwner){
            when(it){
                is DataState.Success -> {
                    loadingProgressBar.hide()
                    it.data?.let { safeData->
                        binding.rvUserList.adapter = UserAdapter().apply {
                            submitList(safeData)
                        }
                    } ?: run {
                        Toast.makeText(requireContext(),"No data", Toast.LENGTH_SHORT).show()
                    }
                }
                is DataState.Error -> {
                    loadingProgressBar.hide()
                    Snackbar.make(binding.root,it.message, Snackbar.LENGTH_LONG).show()

                }
                is DataState.Loading -> {
                    loadingProgressBar.show()
                }
            }
        }

        viewModel.eventStateLiveData.observe(viewLifecycleOwner){
            when (it) {
                is UserViewEvent.ShowMessage -> {}
                is UserViewEvent.NavigateToDetail -> {}
                else -> {null}
            }
        }
    }
}