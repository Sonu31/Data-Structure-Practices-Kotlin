package com.android.experiment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.android.experiment.aghora.AgoraCallActivity
import com.android.experiment.agroVidoeCAll.AgroVidoeCallActivity
import com.android.experiment.databinding.ActivityWelComeScreenBinding
import com.android.experiment.nativeLibImp.NativeLib
import com.android.experiment.paymentGetway.googlepayUpi.GooglePayUPIActivity

private const val TAG_FRAGMENT_NAME = " _SCREEN"
class WelComeScreen : AppCompatActivity(),OnClickListener {


     //    @AndroidEntryPoint
         //    @Inject
         //    lateinit var logger: Logger

         var _binding: ActivityWelComeScreenBinding? = null
         val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        _binding = ActivityWelComeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val lib = NativeLib()
        Log.i("Welcome Screen", "onCreate:- ${lib.getHello()}")
//        println(lib.getHello()) // output: Hello from Native!
        initView()


    }


    //--------------------------------------
    fun   initView(){
        binding.textviewScreenNameBtn1.setOnClickListener(this)
        binding.textviewScreenNameAgoraCall.setOnClickListener(this)
        binding.textviewScreenNameBtn3.setOnClickListener(this)
        binding.textviewScreenNameBtn4.setOnClickListener(this)
        binding.textviewScreenNameBtn5.setOnClickListener(this)
        binding.textviewScreenNameBtn6.setOnClickListener(this)
        binding.textviewScreenNameBtn7.setOnClickListener(this)
        binding.textviewRightBtn1.setOnClickListener(this)
        binding.textviewRightBtn2.setOnClickListener(this)
        binding.textviewRightBtn3.setOnClickListener(this)
        binding.textviewRightBtn4.setOnClickListener(this)
        binding.textviewRightBtn5.setOnClickListener(this)
        binding.textviewRightBtn6.setOnClickListener(this)
        binding.textviewRightBtn7.setOnClickListener(this)

    }
    override fun onClick(v: View?) {
        when(v?.id){

            R.id.textview_screenName_btn1 -> {

                startActivity(Intent(this,GooglePayUPIActivity::class.java))

                //               Toast.makeText(requireContext(), ":: ${bitmpa}", Toast.LENGTH_SHORT).show()
            }
//            R.id.textview_screenName_btn2 -> {
//                //               Toast.makeText(requireContext(), ":: ${bitmpa}", Toast.LENGTH_SHORT).show()
//            }
            R.id.textview_screenName_agora_call -> {
                startActivity(Intent(this, AgoraCallActivity::class.java))
                //               Toast.makeText(requireContext(), ":: ${bitmpa}", Toast.LENGTH_SHORT).show()
            }






            R.id.textview_screenName_btn4 -> {
                startActivity(Intent(this, AgroVidoeCallActivity::class.java))

                //               Toast.makeText(requireContext(), ":: ${bitmpa}", Toast.LENGTH_SHORT).show()
            }
            R.id.textview_screenName_btn5 -> {
                //               Toast.makeText(requireContext(), ":: ${bitmpa}", Toast.LENGTH_SHORT).show()
            }
            R.id.textview_screenName_btn6 -> {
                //               Toast.makeText(requireContext(), ":: ${bitmpa}", Toast.LENGTH_SHORT).show()
            } R.id.textview_screenName_btn7 -> {
            //               Toast.makeText(requireContext(), ":: ${bitmpa}", Toast.LENGTH_SHORT).show()
        }
            R.id.textview_right_btn1 -> {
                //               Toast.makeText(requireContext(), ":: ${bitmpa}", Toast.LENGTH_SHORT).show()
            }
            R.id.textview_right_btn2 -> {
                //               Toast.makeText(requireContext(), ":: ${bitmpa}", Toast.LENGTH_SHORT).show()
            }
            R.id.textview_right_btn3 -> {
                //               Toast.makeText(requireContext(), ":: ${bitmpa}", Toast.LENGTH_SHORT).show()
            }
            R.id.textview_right_btn4 -> {
                //               Toast.makeText(requireContext(), ":: ${bitmpa}", Toast.LENGTH_SHORT).show()
            }
            R.id.textview_right_btn5 -> {
                //               Toast.makeText(requireContext(), ":: ${bitmpa}", Toast.LENGTH_SHORT).show()
            }
            R.id.textview_right_btn6 -> {
                //               Toast.makeText(requireContext(), ":: ${bitmpa}", Toast.LENGTH_SHORT).show()
            }
            R.id.textview_right_btn7 -> {
                //               Toast.makeText(requireContext(), ":: ${bitmpa}", Toast.LENGTH_SHORT).show()
            }
        }   }
}