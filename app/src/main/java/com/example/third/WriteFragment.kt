package com.example.third

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import com.example.databasetask.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WriteFragment : Fragment(R.layout.fragment_write) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val titleText = view.findViewById<EditText>(R.id.titleText)
        val bodyText = view.findViewById<EditText>(R.id.bodyText)
        val addButton = view.findViewById<Button>(R.id.addButton)
        val viewButton = view.findViewById<Button>(R.id.viewButton)

        addButton.setOnClickListener{
            lifecycleScope.launch(Dispatchers.IO){
                (requireActivity() as MainActivity).database.getDao().insertPost(
                    Post(0,
                        titleText.text.toString(),
                        bodyText.text.toString())
                )
            }

        }

        viewButton.setOnClickListener {
            (requireActivity() as MainActivity).toView()
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() =
            WriteFragment()
    }
}