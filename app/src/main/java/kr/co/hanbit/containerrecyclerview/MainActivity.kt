package kr.co.hanbit.containerrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kr.co.hanbit.containerrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val data: MutableList<Memo> = loadData() //사용할 데이터 추가
        var adapter = CustomAdapter() //어댑터 생성
        adapter.listData = data
        binding.recyclerView.adapter = adapter //recyclerView위젯의 adapter 속성에 생성할 어댑터를 연결

        binding.recyclerView.layoutManager = LinearLayoutManager(this) //리사이클러뷰를 화면에 보여주는 형태를 결정하는 레이아웃 매니저 연결
    }

    /* //100개의 가상 데이터를 만드는 함수 */
    fun loadData(): MutableList<Memo> {
        val data: MutableList<Memo> = mutableListOf() //리턴할 MutableList 선언
        for (no in 1..100) {
            val title = "이것이 안드로이드다 %{no}"
            val date = System.currentTimeMillis() //안드로이드 스마트폰의 현재 시간
            val memo = Memo(no, title, date) //Memo 클래스 생성
            data.add(memo)
        }
        return data;
    }
}