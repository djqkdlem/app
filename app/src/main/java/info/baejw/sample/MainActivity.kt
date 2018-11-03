package info.baejw.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import info.baejw.sample.adapter.RecyclerAdapter
import info.baejw.sample.common.Tag_BJW
import info.baejw.sample.entity.Board
import info.baejw.sample.retrofit.RetrofitApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val animals: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addAnimals()

        list.layoutManager = LinearLayoutManager(this)
        list.adapter = RecyclerAdapter(animals, this)


        val apiService = RetrofitApiService.create()
        var webttonlist = apiService.get("2")
        webttonlist.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ result ->

                    Log.i(Tag_BJW, "${result.size}개")

                    for (i in result) {
                        Log.i(Tag_BJW, "제목 : ${i.title}, 요일:${i.desc}")
                    }
                }, { error ->
                    error.printStackTrace()
                })
        Log.i(Tag_BJW, "REST API 종료 후 ")

        var board = Board("", "ss", "sdf", "z", false)

        // okhttp log 적용하기
        // RxJava
        apiService.set(board).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result ->
                            Log.i(Tag_BJW, "POST 성공!!")
                            Log.i(Tag_BJW, result.toString())
                        },
                        { error ->
                            Log.i(Tag_BJW, "에러에러에러")
                            Log.i(Tag_BJW, error.toString())
                            error.printStackTrace()
                        })

    }

    fun addAnimals() {
        animals.add("dog")
        animals.add("cat")
        animals.add("owl")
        animals.add("cheetah")
    }
}
