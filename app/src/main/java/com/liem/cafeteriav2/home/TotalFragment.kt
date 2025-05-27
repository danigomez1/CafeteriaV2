package com.liem.cafeteriav2.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.liem.cafeteriav2.R
import com.liem.cafeteriav2.databinding.FragmentTotalBinding

class TotalFragment : Fragment() {
    private var _binding: FragmentTotalBinding? = null
    private val binding get() = _binding!!
    private val sharedVM: SharedVM by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTotalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedVM.totalAmount.observe(viewLifecycleOwner) { total ->
            binding.tvTotal.text = String.format("Total: $%.2f", total)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}