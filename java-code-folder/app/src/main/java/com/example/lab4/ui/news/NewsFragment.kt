package com.example.lab4.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.lab4.R
import com.example.lab4.databinding.FragmentHomeBinding

import com.example.lab4.ui.home.HomeViewModel

class NewsFragment : Fragment() {

    private lateinit var newsViewModel: NewsViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        newsViewModel =
            ViewModelProvider(this).get(NewsViewModel::class.java)

        //_binding = FragmentHomeBinding.inflate(inflater, container, false)
        //val root: View = binding.root

        //val textView: TextView = binding.textHome
        val root = inflater.inflate(R.layout.fragment_news,container,false)
        val textView : TextView = root.findViewById(R.id.txtNews)
        newsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    //override fun onDestroyView() {
     //   super.onDestroyView()
     //   _binding = null
   // }
}