package com.example.EasyCar.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.EasyCar.BaseApplication
import com.example.EasyCar.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private val homeViewModel =
        ViewModelProvider(this).get(HomeViewModel::class.java)
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*
        val adapter = HomeListAdapter { car ->
            val action = CarListFragmentDirections
                .actionCarListFragmentToCarDetailsFragment(car.id)
            findNavController().navigate(action)
        }
        homeViewModel.allCars.observe(this.viewLifecycleOwner) { carSelected ->
            carSelected.let {
                adapter.submitList(it)
            }
        }
        binding.apply {
            carRecyclerView.adapter = adapter
        }


         */
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}