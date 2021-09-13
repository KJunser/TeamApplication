package com.example.myapplication.Main.Activity


//import com.example.myapplication.Main.Fragment.ChatFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.Main.Fragment.*
import com.example.myapplication.Main.Fragment.BoardFrgment.BoardFragment
import com.example.myapplication.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity(){
    // MainActivity가 가지고 있는 멤버 변수 선언
    private lateinit var homeFragment: HomeFragment
    private lateinit var currentplacefragmet: CurrentPlaceFragment
    //private lateinit var mapFragment: CurrentPlaceFragment
    private lateinit var boardFragment : BoardFragment
    //private lateinit var chatFragment: ChatFragment
    private lateinit var settingFragment: SettingFragment
//    private lateinit var boardFragment: BoardFragment
//    private var datalist = mutableListOf<BoardDTO>()
//    var bundle = Bundle()

    //private lateinit var photoAdapter: PhotoAdapter //1
    //private var dataList = mutableListOf<DataModel>()   //2

    companion object {
        const val TAG: String = "로그"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavi.setOnNavigationItemSelectedListener(onBottomNavItemSelectedListener)
//        ActivityCompat.requestPermissions(
//            this,
//            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
//            1
//        )
        homeFragment = HomeFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.frame_container, homeFragment).commit()


    }

    override fun onResume() {
        super.onResume()

    }
    //바텀 네비게이션 아이템 클릭 리스너

    private val onBottomNavItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.action_home -> {
                    homeFragment = HomeFragment.newInstance()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_container, homeFragment).commit()
                }
                R.id.action_Map -> {
                    currentplacefragmet = CurrentPlaceFragment.newInstance()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_container, currentplacefragmet).commit()
                }
                /*
                R.id.action_Map -> {
                    mapFragment = CurrentPlaceFragment.newInstance()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_container, mapFragment).commit()
                }*/
                R.id.action_board -> {
                    // 사진을 가져올 수 있는지 확인 하는 작업
                    boardFragment = BoardFragment.newInstance()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_container, boardFragment).commit()
                }
               /* R.id.action_chat -> {
//                    chatFragment = ChatFragment.newInstance()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_container, chatFragment).commit()
                }*/
                R.id.action_setting -> {
                    settingFragment = SettingFragment.newInstance()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_container, settingFragment).commit()
                }
            }
            true
        }


}