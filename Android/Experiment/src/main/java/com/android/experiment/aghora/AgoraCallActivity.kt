package com.android.experiment.aghora

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.SurfaceView
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.experiment.R
import com.android.experiment.databinding.ActivityAghoraCallBinding
import io.agora.rtc2.Constants


import io.agora.rtc2.RtcEngineEx
import io.agora.rtc2.RtcEngineConfig
import io.agora.rtc2.IRtcEngineEventHandler
import io.agora.rtc2.RtcEngine
import io.agora.rtc2.video.VideoCanvas

private const val TAG_FRAGMENT_NAME = "AghoraCallActivity_SCREEN"

class AgoraCallActivity : AppCompatActivity(), View.OnClickListener {
    //    @AndroidEntryPoint

    //    @Inject
    //   lateinit var logger: Logs
//                      private val studentViewModel :StudentViewModel by viewModels()
//
    private val appId2 = "a18dda57d9404b1794aec98a74b84a8a"
   private val token = "007eJxTYPh0JnqXipj1FS2PSWrrGZmP73HaLhNu0JCfeL/3yp+pf64rMCQaWqSkJJqap1iaGJgkGZpbmiSmJltaJJqbJFmYJFokBnNbZzQEMjJ43GBhYWSAQBCfh6EoPyOzJN7S3NLC0oSBAQBDkyD2"
    private val channelName = "rohit_979894"

//        private val appId2 = "7c49d5d246fa42bca16876f2ee653d66"
//    private val token = "007eJxTYFilV9qb2B+xVXL/dLlvUfNLj17e6+LXmrvkP2eVwpI3UwoVGMyTTSxTTFOMTMzSEk2MkpITDc0szM3SjFJTzUyNU8zM8vlsMhoCGRlKtBJZGBkgEMQXYAhJLS7JzEuPNzQyjg/OzytlYAAABNsjPw=="
//    private val channelName = "Testing_123_Sonu"


    private var agoraEngine: RtcEngineEx? = null

    var _binding: ActivityAghoraCallBinding? = null
    val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityAghoraCallBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView();
        onClickListener();
        setView();

        checkPermissions()


//        checkPermissions()
//        initializeAgoraEngine()
    }

        private fun setView() {
        }
        private fun onClickListener() {
        }
        private fun initView() {
            binding.textviewAghoraCallActionStartCall.setOnClickListener(this)
            binding.textviewAghoraCallActionStartVodeoCAll.setOnClickListener(this)

        }

/*
    private fun checkPermissions() {
        val permissions = arrayOf(Manifest.permission.RECORD_AUDIO)
        if (permissions.any {
                ContextCompat.checkSelfPermission(this, it) != PackageManager.PERMISSION_GRANTED
            }) {
            ActivityCompat.requestPermissions(this, permissions, 1)
        }
    }
    private fun initializeAgoraEngine() {
        try {
            val config = RtcEngineConfig().apply {
                mContext = applicationContext
                mAppId = "a18dda57d9404b1794aec98a74b84a8a"
                mEventHandler = object : IRtcEngineEventHandler() {
                    override fun onUserJoined(uid: Int, elapsed: Int) {
                        Log.d("Agora", "Remote user joined: $uid")
                    }

                }
            }

            agoraEngine = RtcEngine.create(config) as RtcEngineEx?
            agoraEngine?.setChannelProfile(Constants.CHANNEL_PROFILE_COMMUNICATION)
            agoraEngine?.enableAudio()
            Log.d("AgoraInit", "RtcEngineEx initialized successfully")
        } catch (e: Exception) {
            Log.e("AgoraInit", "RtcEngineEx init failed: ${e.message}")
            agoraEngine = null // 🔴 Reset to null to prevent misuse
        }
    }
    private fun joinChannel() {
        agoraEngine?.joinChannel(token, channelName, "", 0)

        Toast.makeText(this, "Joined voice channel", Toast.LENGTH_SHORT).show()
    }
    private fun leaveChannel() {
        agoraEngine?.leaveChannel()
        Toast.makeText(this, "Left voice channel", Toast.LENGTH_SHORT).show()
    }*/


    override fun onClick(v: View?) {
        when(v?.id){
            R.id.textview_Aghora_call_action_startCall -> {
                CallDilaog.show(this,null)

                //               Toast.makeText(requireContext(), ":: ${bitmpa}", Toast.LENGTH_SHORT).show()
            }
            R.id.textview_Aghora_call_action_startVodeoCAll -> {
                setupAgoraEngine()
                joinChannel()

                Toast.makeText(this, "JOIN", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        agoraEngine?.leaveChannel()
        RtcEngine.destroy()
    }

        private fun checkPermissions() {
            val permissions = arrayOf(Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO)
            if (permissions.any {
                    ContextCompat.checkSelfPermission(this, it) != PackageManager.PERMISSION_GRANTED
                }) {
                ActivityCompat.requestPermissions(this, permissions, 1)
            }
        }

       private fun setupAgoraEngine() {

           println("Check Data  setupAgoraEngine :-   ")

           val config = RtcEngineConfig()
        config.mContext = this
        config.mAppId = appId2
        config.mEventHandler = object : IRtcEngineEventHandler() {

            override fun onUserJoined(uid: Int, elapsed: Int) {

                println("Check Data  setupAgoraEngine2 :-{${uid}}   ")


                runOnUiThread {
                    setupRemoteVideo(uid)
                }
            }
        }
        agoraEngine = RtcEngine.create(config) as RtcEngineEx?

//        agoraEngine = RtcEngineEx.create(config)

        // Enable video
        agoraEngine?.enableVideo()

        // Setup local video view
        val localContainer = findViewById<FrameLayout>(R.id.local_video_view_container)
        val localView = SurfaceView(this)
        localContainer.addView(localView)
        agoraEngine?.setupLocalVideo(VideoCanvas(localView, VideoCanvas.RENDER_MODE_HIDDEN, 0))
    }

        private fun joinChannel() {
        agoraEngine?.joinChannel(token, channelName, "", 0)
    }

       private fun setupRemoteVideo(uid: Int) {

//           val localView = RtcEngine.CreateRendererView(this)
//           localView.setZOrderMediaOverlay(true) // IMPORTANT
//           localContainer.addView(localView)
//           agoraEngine?.setupLocalVideo(VideoCanvas(localView, VideoCanvas.RENDER_MODE_HIDDEN, 0))
//
//
//           val remoteView = RtcEngine.CreateRendererView(this)
//           remoteContainer.addView(remoteView)
//           agoraEngine?.setupRemoteVideo(VideoCanvas(remoteView, VideoCanvas.RENDER_MODE_HIDDEN, uid))

        val remoteContainer = findViewById<FrameLayout>(R.id.remote_video_view_container)
        val remoteView = SurfaceView(this)
        remoteContainer.addView(remoteView)
        agoraEngine?.setupRemoteVideo(VideoCanvas(remoteView, VideoCanvas.RENDER_MODE_HIDDEN, uid))

//           val localContainer = findViewById<FrameLayout>(R.id.local_video_view_container)
//           val localView = RtcEngine.CreateRendererView(this)
//           localView.setZOrderMediaOverlay(true)
//           localContainer.addView(localView)
    }

}