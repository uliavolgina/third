package com.example.third

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.databasetask.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ReadFragment : Fragment(R.layout.fragment_read) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.messages)
        val backButton = view.findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            (requireActivity() as MainActivity).toEdit()
        }
        lifecycleScope.launch(Dispatchers.IO) {
            val posts = (requireActivity() as MainActivity).database.getDao().getPosts()
            val adapter = Adapter(requireContext(), posts)
            withContext(Dispatchers.Main){
                recyclerView.adapter = adapter
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ReadFragment()
    }
}