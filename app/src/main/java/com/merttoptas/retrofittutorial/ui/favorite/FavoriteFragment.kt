package com.merttoptas.retrofittutorial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.merttoptas.retrofittutorial.data.model.PostDTO
import com.merttoptas.retrofittutorial.databinding.FragmentFavoriteBinding
import com.merttoptas.retrofittutorial.ui.favorite.FavoritesViewModel
import com.merttoptas.retrofittutorial.ui.loadingprogress.LoadingProgressBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment : Fragment(), OnFavoriteClickListener {
    lateinit var loadingProgressBar: LoadingProgressBar
    private val viewModel by viewModels<FavoritesViewModel>()
    private lateinit var binding: FragmentFavoriteBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadingProgressBar = LoadingProgressBar(requireContext())

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.postLiveData.observe(viewLifecycleOwner) {

            binding.rvFavoritesList.adapter = FavoritesAdapter(this).apply {
                submitList(it)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.getPosts()
    }

    override fun onFavoriteClick(post: PostDTO) {
        viewModel.onFavoritePost(post)
    }


}
