package com.muleo.week4

import android.os.Bundle
import android.text.format.DateUtils
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.*
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.muleo.week4.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = FragmentNumberFactory()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.apply {
            button1.setOnClickListener {
                supportFragmentManager.commit {
                    replace<Fragment1>(R.id.fragment_container_view)
                    setReorderingAllowed(true)
                }
            }
            button2.setOnClickListener {
                supportFragmentManager.commit {
                    replace<Fragment2>(R.id.fragment_container_view)
                    setReorderingAllowed(true)
                }
            }
            button3.setOnClickListener {
                supportFragmentManager.commit {
                    replace<Fragment3>(R.id.fragment_container_view)
                    setReorderingAllowed(true)
                }
            }
            button4.setOnClickListener {
                supportFragmentManager.commit {
                    replace<Fragment4>(R.id.fragment_container_view)
                    setReorderingAllowed(true)
                }
            }
            button5.setOnClickListener {
                supportFragmentManager.commit {
                    replace<Fragment5>(R.id.fragment_container_view)
                    setReorderingAllowed(true)
                }
            }

            textInputLayout.apply {
                setEndIconOnClickListener {
                    textInputLayout.editText?.text = null
                }
                setStartIconOnClickListener {
                    val name = editQuery.text.toString()
                    requestS(name)
                }
            }
            editQuery.setOnEditorActionListener { v, actionId, _ ->
                when (actionId) {
                    EditorInfo.IME_ACTION_DONE -> {
                        val name = v.text.toString()
                        if (name.length in 3..16) {
                            textInputLayout.error = null
                            requestS(name)
                            return@setOnEditorActionListener false
                        } else {
                            textInputLayout.error = getString(R.string.limits_error)
                            return@setOnEditorActionListener true
                        }
                    }
                }
                true
            }

        }
        visible(false)
        viewModel.apply {
            summoner.observe(this@MainActivity, Observer { s ->
                if (s.isLoaded) {
                    binding.apply {
                        Glide.with(this@MainActivity)
                            .asBitmap()
                            .load("https://ddragon.leagueoflegends.com/cdn/11.9.1/img/profileicon/${s.profileIconId}.png")
                            .apply(
                                RequestOptions()
                                    .placeholder(R.drawable.loading_animation)
                                    .error(R.drawable.ic_baseline_broken_image)
                            )
                            .into(profileIcon)
                        summonerName.text = s.name
                        summonerLevel.text = "${s.summonerLevel}"
                        "Revision Date : ${convertLongToTime(s.revisionDate)}".also {
                            revisionDate.text = it
                        }
                    }
                    // T M J B S
                    requestL(s.puuid)
                } else {
                    binding.textInputLayout.error = s.error
                }
            })
            matchIdList.observe(this@MainActivity, Observer {
                when (it) {
                    is MatchIdResult.Success -> {
                        visible(false)
                        // Match 리스트가 도착 시,   를 위한 Match 들의 요청을 날리고 이를 저장
                        viewModel.match(it.matchList)
                    }
                    is MatchIdResult.Error -> {
                        visible(false)
                    }
                }
            })
            matchList.observe(this@MainActivity, Observer {
                visible(true)
            })
            progressInt.observe(this@MainActivity, Observer {
                Log.d("progress", "진행률...$it")
                binding.progress.setProgress(it, true)
            })
        }

    }

    private fun requestS(name: String) {
        visible(false)
        supportFragmentManager.apply {
            // back stack 에 안 쌓일 경우
            findFragmentById(R.id.fragment_container_view)?.let {
                commit {
                    remove(it)
                    setReorderingAllowed(true)
                }
            }
            // 쌓일 경우
            for (i in 0 until backStackEntryCount) {
                popBackStack()
            }
        }
        viewModel.getSummonerByName(name)
    }

    private fun requestL(puuid: String) {
        viewModel.getMatchList(puuid)
    }

    private fun convertLongToTime(t: Long): String =
        DateUtils.formatDateTime(this, t, DateUtils.FORMAT_NUMERIC_DATE)

    private fun visible(isVisible: Boolean) {
        if (!isVisible) {
            binding.button1.visibility = View.INVISIBLE
            binding.button2.visibility = View.INVISIBLE
            binding.button3.visibility = View.INVISIBLE
            binding.button4.visibility = View.INVISIBLE
            binding.button5.visibility = View.INVISIBLE
        } else {
            binding.button1.visibility = View.VISIBLE
            binding.button2.visibility = View.VISIBLE
            binding.button3.visibility = View.VISIBLE
            binding.button4.visibility = View.VISIBLE
            binding.button5.visibility = View.VISIBLE
        }
    }

}

class MainViewModel : ViewModel() {
    private val _summoner = MutableLiveData<Summoner>()
    val summoner: LiveData<Summoner> get() = _summoner

    fun getSummonerByName(name: String) {
        viewModelScope.launch {
            try {
                val r = Ktor.summonerByName(name)
                _summoner.value = r
            } catch (e: Exception) {
                _summoner.value = Summoner().apply {
                    isLoaded = false
                    error = e.message?.run {
                        this.substring(indexOf("message") + 9).substringBeforeLast(',')
                    } ?: "error"
                }
            }
        }
    }

    val matchIdList = MutableLiveData<MatchIdResult>()

    fun getMatchList(puuid: String) {
        viewModelScope.launch {
            try {
                val r = Ktor.matchList(puuid)
                matchIdList.value = MatchIdResult.Success(r)
            } catch (e: Exception) {
                matchIdList.value = MatchIdResult.Error(
                    e.message?.run {
                        this.substring(indexOf("message") + 9).substringBeforeLast(',')
                    } ?: "error")
            }
        }
    }

    private val _matchList = MutableLiveData<List<Match>>()
    val matchList: LiveData<List<Match>> get() = _matchList

    private val _progressInt = MutableLiveData(0)
    val progressInt: LiveData<Int> get() = _progressInt
    fun match(matchId: List<String>) {
        viewModelScope.launch {
            val r = mutableListOf<Match>()
            try {
                for ((i, j) in matchId.withIndex()) {
                    Log.d("match()", "얻어오는 각 match: $j")
                    r.add(Ktor.match(j))
                    _progressInt.value = (i + 1) * 5
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _matchList.value = r
                _progressInt.value = 0
            }
        }
    }

    private val lazy1 = MutableLazy {
        Log.d("cardResult", "얻어온 match 를 바탕으로 쓸모있는 정보 요약.")
        matchList.value?.map {
            // 한 게임 정보
            val cn: String
            val assists: Int
            val deaths: Int
            val kills: Int
            val win: Boolean
            val lane: String
            it.info.participants
                .find { p -> p.summonerName == summoner.value!!.name }
                ?.run {
                    cn = championName
                    assists = this@run.assists
                    deaths = this@run.deaths
                    kills = this@run.kills
                    win = this@run.win
                    lane = if (this@run.individualPosition != "Invalid") {
                        this@run.individualPosition
                    } else {
                        this@run.role
                    }
                    MatchResult.Summary(cn, assists, deaths, kills, win, lane)
                } ?: MatchResult.Error(true)
        } ?: emptyList()
    }

    private val cardResult: List<MatchResult> by lazy1

    private val lazyM = MutableLazy {
        filter("MIDDLE")
    }
    private val lazyT = MutableLazy {
        filter("TOP")
    }
    private val lazyJ = MutableLazy {
        filter("JUNGLE")
    }
    private val lazyB = MutableLazy {
        filter("BOTTOM")
    }
    private val lazyS = MutableLazy {
        filter("UTILITY")
    }

    private fun reset() {
        lazy1.reset()
        lazyB.reset()
        lazyJ.reset()
        lazyM.reset()
        lazyS.reset()
        lazyT.reset()
    }

    private val mResult: List<MatchResult.Summary> by lazyM
    private val tResult: List<MatchResult.Summary> by lazyT
    private val jResult: List<MatchResult.Summary> by lazyJ
    private val bResult: List<MatchResult.Summary> by lazyB
    private val sResult: List<MatchResult.Summary> by lazyS

    private fun filter(lane: String) = cardResult.filter {
        Log.d("filter()", "cardResult 에서 $lane 필터링중...")
        when (it) {
            is MatchResult.Error -> false
            is MatchResult.Summary -> {
                it.lane == lane
            }
        }
    }.map { it as MatchResult.Summary }.apply {
        Log.d("filter()", "필터링끝, 크기: $size")
    }

    private fun aggregate(list: List<MatchResult.Summary>) {
        Log.d("aggregate()", "filter()된 해당 라인의 집약 size: ${list.size}")
        // 해당하는 라인의 정보 4개를 모아서 LiveData 에 저장.
        _m4CardList.value = list.groupBy { it.cn }
            .map {
                val size = it.value.size
                var w = 0
                var l = 0
                var k = 0
                var d = 0
                var a = 0
                it.value.forEach { s ->
                    if (s.win) w++ else l++
                    k += s.kills
                    d += s.deaths
                    a += s.assists
                }
                Card(
                    it.key,
                    "https://ddragon.leagueoflegends.com/cdn/11.9.1/img/champion/${it.key}.png",
                    grade = (k + a - d) / size.toDouble(),
                    wl = "${w}승/${l}패"
                )
            }.apply { Log.d("aggregate()", "집약된 사이즈 : $size") }

    }

    private val _m4CardList = MutableLiveData<List<Card>>()
    val m4CardList: LiveData<List<Card>> get() = _m4CardList

    fun start(lane: Lane) {
        reset()
        viewModelScope.launch {
            when (lane) {
                Lane.MIDDLE -> aggregate(mResult)
                Lane.TOP -> aggregate(tResult)
                Lane.JUNGLE -> aggregate(jResult)
                Lane.BOTTOM -> aggregate(bResult)
                Lane.SUPPORT -> aggregate(sResult)
            }
        }
    }


}

sealed class MatchIdResult {
    data class Success(val matchList: List<String>) : MatchIdResult()
    data class Error(val message: String) : MatchIdResult()
}

sealed class MatchResult {
    data class Error(val empty: Boolean) : MatchResult()
    data class Summary(
        val cn: String,
        val assists: Int,
        val deaths: Int,
        val kills: Int,
        val win: Boolean,
        val lane: String,
    ) : MatchResult()
}

data class Card(
    // 각 카드
    val cn: String, // 챔피언 이름
    val iconUrl: String, // 챔피언 아이콘 url
    val grade: Double, // 3.75 평점
    val wl: String, // Win and Lost
)

enum class Lane {
    MIDDLE, TOP, JUNGLE, BOTTOM, SUPPORT
}


class MutableLazy<T>(private val initializer: () -> T) : Lazy<T> {
    private var cached: T? = null

    override val value: T
        get() {
            if (!isInitialized()) {
                cached = initializer()
            }
            @Suppress("UNCHECKED_CAST")
            return cached as T
        }

    override fun isInitialized(): Boolean = cached != null

    fun reset() {
        cached = null
    }
}
