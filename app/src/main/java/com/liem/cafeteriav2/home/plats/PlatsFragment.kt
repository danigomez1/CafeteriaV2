package com.liem.cafeteriav2.home.plats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.liem.cafeteriav2.R
import com.liem.cafeteriav2.databinding.FragmentBegudesBinding
import com.liem.cafeteriav2.databinding.FragmentPlatsBinding
import com.liem.cafeteriav2.home.CustomAdapter
import com.liem.cafeteriav2.home.SharedVM

class PlatsFragment : Fragment() {
    private lateinit var binding: FragmentPlatsBinding
    private val sharedVM: SharedVM by activityViewModels()
    private val platsVM: PlatsVM by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlatsBinding.inflate(inflater, container, false)

        platsVM.plats.observe(viewLifecycleOwner) { listaBegudes ->
            val adapter = CustomAdapter(listaBegudes, sharedVM)
            binding.recyclerView.apply {
                layoutManager = LinearLayoutManager(requireContext())
                this.adapter = adapter
            }
        }

        return binding.root
    }
}