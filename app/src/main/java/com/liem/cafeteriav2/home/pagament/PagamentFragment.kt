package com.liem.cafeteriav2.home.pagament

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.liem.cafeteriav2.R
import com.liem.cafeteriav2.databinding.FragmentPagamentBinding
import com.liem.cafeteriav2.home.PaymentAdapter
import com.liem.cafeteriav2.home.SharedVM

class PagamentFragment : Fragment() {
    private var _binding: FragmentPagamentBinding? = null
    private val binding get() = _binding!!
    private val sharedVM: SharedVM by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPagamentBinding.inflate(inflater, container, false)

        binding.rvPayment.apply {
            layoutManager = LinearLayoutManager(requireContext())
        }

        sharedVM.selectedItems.observe(viewLifecycleOwner) { lista ->
            binding.rvPayment.adapter = PaymentAdapter(lista)
        }

        sharedVM.totalAmount.observe(viewLifecycleOwner) { total ->
            binding.tvTotal.text = String.format("Total: $%.2f", total)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}