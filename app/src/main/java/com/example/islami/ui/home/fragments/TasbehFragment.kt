package com.example.islami.ui.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.islami.R

class TasbehFragment : Fragment() {
    lateinit var tasbehNum: Button
    lateinit var zaker: Button
    var number = 1
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tasbeh, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        sebhaLogic()


    }

    private fun sebhaLogic() {
        tasbehNum.setOnClickListener(
            View.OnClickListener {

                tasbehNum.text = number.toString()
                number += 1

                if (number > 1 && number <= 33) {
                    zaker.text = "سبحان الله"
                } else if (number > 33 && number <= 66) {
                    zaker.text = "الحمد لله"

                } else if (number > 66 && number <= 99) {
                    zaker.text = "الله اكبر"
                } else if (number > 99) { //reset number of tasbeh and zeker-text
                    tasbehNum.setText("0").toString()
                    zaker.text = "سبحان الله"
                    number = 1

                }


            }
        )
    }

    private fun initView() {
        tasbehNum = requireView().findViewById(R.id.tasbeh_num_button)
        zaker = requireView().findViewById(R.id.tasbeh_text_button)
    }
}