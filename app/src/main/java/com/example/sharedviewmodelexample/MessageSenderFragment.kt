package com.example.sharedviewmodelexample

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_message_sender.*

class MessageSenderFragment : Fragment() {

    lateinit var model: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_message_sender, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        sendData.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                model.sendMessage(s.toString().trim())
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                model.sendMessage(s.toString().trim())
            }

            override fun afterTextChanged(s: Editable?) {
                model.sendMessage(s.toString().trim())
            }

        })

    }

}