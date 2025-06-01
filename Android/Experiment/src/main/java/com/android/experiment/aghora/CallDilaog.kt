package com.android.experiment.aghora

import com.android.experiment.R
import com.android.experiment.databinding.DilaogAgoraCallBinding


import android.app.Dialog
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity


//@AndroidEntryPoint
class CallDilaog: DialogFragment() ,  View.OnClickListener{
    private var _binding: DilaogAgoraCallBinding? = null
    private val binding get() = _binding!!
    private var listener: OnDataPassListener? = null
    interface OnDataPassListener {
        fun onDataPass(imageUri: Uri)
    }
    fun setListener(onDataPassListener: OnDataPassListener) {
        listener = onDataPassListener
    }
    companion object {
        fun show(
            appCompatActivity: FragmentActivity,
            onDataPassListener: OnDataPassListener?
        ): CallDilaog {
            val addImageDialog = CallDilaog().apply {
                if (onDataPassListener != null) {
                    setListener(onDataPassListener)
                }
            }
            addImageDialog.show(appCompatActivity.supportFragmentManager, "")
            return addImageDialog
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DilaogAgoraCallBinding.inflate(inflater, container, false)
        initView();
        onClickListener();
        setView();
        return binding.root
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return Dialog(requireContext(), R.style.FullScreenDialogTheme)
    }
          private fun initView() {
              binding.textviewCallDilaogActionCallCut.setOnClickListener(this)
              binding.textviewCallDilaogActionCallmut.setOnClickListener(this)
              binding.textviewCallDilaogActionSpeaker.setOnClickListener(this)
         }
        private fun setView() {

         }
         private fun onClickListener() {

         }





             override fun onClick(v: View?) {
                when(v?.id){

                   R.id.textview_callDilaog_action_callCut -> {
        //               Toast.makeText(requireContext(), ":: ${bitmpa}", Toast.LENGTH_SHORT).show()
                   }

                    R.id.textview_callDilaog_action_callmut  -> {
                    }
                    R.id.textview_callDilaog_action_speaker -> {

                    }

                }

            }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}





