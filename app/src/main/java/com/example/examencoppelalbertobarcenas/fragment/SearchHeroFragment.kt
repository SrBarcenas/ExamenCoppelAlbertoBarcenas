package com.example.examencoppelalbertobarcenas.fragment

import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examencoppelalbertobarcenas.R
import com.example.examencoppelalbertobarcenas.adapter.HeroAdapter
import com.example.examencoppelalbertobarcenas.databinding.FragmentSearchHeroBinding
import com.example.examencoppelalbertobarcenas.fragment.ViewModel.SearchHeroViewModel
import com.example.examencoppelalbertobarcenas.model.response.HeroResponse
import java.lang.Exception

class SearchHeroFragment : Fragment(), SearchView.OnQueryTextListener,
    androidx.appcompat.widget.SearchView.OnQueryTextListener {

    private val TAG = "SearchHeroFragment: "
    private var _binding: FragmentSearchHeroBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SearchHeroViewModel by viewModels()
    private lateinit var adapter: HeroAdapter
    private var listHeros = ArrayList<HeroResponse>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchHeroBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.svHeros.setOnQueryTextListener(this)

        initRecyclerView()
        observable()
        viewModel.getHeros("a")
    }

    fun observable(){
        viewModel.heroModel.observe(this, Observer {
            val resultHeros = it?.results ?: emptyList()
            listHeros.clear()
            listHeros.addAll(resultHeros)
            adapter.notifyDataSetChanged()
            hideKeyboard()
        })
    }

    private fun initRecyclerView() {
        adapter = HeroAdapter(listHeros, context!!, ::itemListener)
        binding.rvHeros.layoutManager = LinearLayoutManager(context)
        binding.rvHeros.adapter = adapter
    }

    private fun showError() {
        Toast.makeText(context, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }

    override fun onQueryTextSubmit(name: String?): Boolean {
        if (!name.isNullOrEmpty()) {
            try {
                viewModel.getHeros(name.toLowerCase())
            } catch (e: Exception) {
                showError()
            }
        }
        return true
    }

    override fun onQueryTextChange(name: String?): Boolean {
        return true
    }

    private fun hideKeyboard() {
        val imm = getActivity()?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.clSearchHero.windowToken, 0)
    }

    private fun itemListener(id: String) {
        val bundle = Bundle()
        val view = binding.root

        bundle.putString("id", id)
        Navigation.findNavController(view)
            .navigate(R.id.action_searchHeroFragment_to_detailHeroFragment, bundle)
    }

}