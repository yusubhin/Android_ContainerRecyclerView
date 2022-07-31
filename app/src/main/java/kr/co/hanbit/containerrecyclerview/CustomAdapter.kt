package kr.co.hanbit.containerrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kr.co.hanbit.containerrecyclerview.databinding.ItemRecyclerBinding
import java.text.SimpleDateFormat

class CustomAdapter: RecyclerView.Adapter<Holder>() {
    var listData = mutableListOf<Memo>() //이 어댑터에서 사용할 데이터 목록 변수

    /* 스마트폰의 한 화면에 보이는 개수만큼 안드로이드가 호출하는 함수 */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        //TODO("Not yet implemented")
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            /*  파라미터1: inflater-바인딩을 생성할 때 사용하는 인플레이터(액티비티에서와는 다르게 LayoutInflater.from을 사용해야함)
                    from에는 파라미터로 context가 전달돼야 하는데, 안드로이드가 넘겨주는 parent에서 꺼낼 수 있음
                파라미터2: parent: 생성되는 바인딩이 속하는 부모 뷰(레이아웃)
                파라미터3: attachToRoot: ture-attach해야하는 대상으로 root를 지정하고 아래에 붙임
                                        false-뷰의 최상위 레이아웃의 속성을 기본으로 레이아웃이 적용됨
             */
        return Holder(binding) //생성된 바인딩을 Holder 클래스에 담아서 반환
    }

    /* 생성된 뷰홀더를 화면에 보여주는 함수 */
    override fun onBindViewHolder(holder: Holder, position: Int) {
        //TODO("Not yet implemented")
        val memo = listData.get(position)
        holder.setMemo(memo)
    }

    override fun getItemCount(): Int {
        //TODO("Not yet implemented")
        return listData.size
    }
}

//cladd Holder: RecyclerView.ViewHolder {} : Error-생성자에 1개의 값이 필수로 입력돼야 함
class Holder(val binding: ItemRecyclerBinding): RecyclerView.ViewHolder(binding.root) {
    /* 아이템 레이아웃은 어댑터가 만들어서 넘겨줌 (ViewHolder 자체에서 만들기 x)
        ViewHoldere의 생성자는 바인딩이 아닌 View를 필요로 하므로 binding.root 전달
        binding은 Holder 클래스 안에서 전역변수로 사용돼야 하므로 val
        이 어댑터에서 사용할 레이아웃의 이름이 item_recycle이므로 (안드로이드에서 생성해주는) 바인딩의 이름은 ItemRecyclerBinding
     */

    init {
        binding.root.setOnClickListener {
            Toast.makeText(binding.root.context, "클릭된 아이템 = ${binding.textTitle.text}", Toast.LENGTH_LONG).show()
        }
    }

    /* 화면에 데이터를 세팅하는 함수 */
    fun setMemo(memo: Memo) {
        binding.textTitle.text = memo.title

        var sdf = SimpleDateFormat("yyyy/MM/dd")//날짜 형식으로 변환
        var formattedDate = sdf.format(memo.timestamp)
        binding.textNo.text = "${memo.no}"
    }
}