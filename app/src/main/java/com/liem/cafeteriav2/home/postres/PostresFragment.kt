package com.liem.cafeteriav2.home.postres

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.liem.cafeteriav2.databinding.FragmentPostresBinding
import com.liem.cafeteriav2.home.CustomAdapter
import com.liem.cafeteriav2.home.SharedVM

class PostresFragment : Fragment() {
    private lateinit var binding: FragmentPostresBinding
    private val sharedVM: SharedVM by activityViewModels()
    private val postresVM: PostresVM by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPostresBinding.inflate(inflater, container, false)

        postresVM.postres.observe(viewLifecycleOwner) { listaBegudes ->
            val adapter = CustomAdapter(listaBegudes, sharedVM)
            binding.recyclerView.apply {
                layoutManager = LinearLayoutManager(requireContext())
                this.adapter = adapter
            }
        }

        return binding.root
    }
}