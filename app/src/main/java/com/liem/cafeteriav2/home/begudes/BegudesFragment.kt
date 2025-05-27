package com.liem.cafeteriav2.home.begudes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.liem.cafeteriav2.R
import com.liem.cafeteriav2.databinding.FragmentBegudesBinding
import com.liem.cafeteriav2.home.CustomAdapter
import com.liem.cafeteriav2.home.ProductProvider
import com.liem.cafeteriav2.home.SharedVM

class BegudesFragment : Fragment() {
    private lateinit var binding: FragmentBegudesBinding
    private val sharedVM: SharedVM by activityViewModels()
    private val begudesVM: BegudesVM by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBegudesBinding.inflate(inflater, container, false)

        begudesVM.begudes.observe(viewLifecycleOwner) { listaBegudes ->
            val adapter = CustomAdapter(listaBegudes, sharedVM)
            binding.recyclerView.apply {
                layoutManager = LinearLayoutManager(requireContext())
                this.adapter = adapter
            }
        }

        return binding.root
    }
}