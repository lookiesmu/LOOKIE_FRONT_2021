package com.muleo.week4

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.muleo.week4.databinding.FragmentNumberBinding


class FragmentNumberFactory : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (loadFragmentClass(classLoader, className)) {
            Fragment1::class.java -> Fragment1("TOP")
            Fragment2::class.java -> Fragment2("MIDDLE")
            Fragment3::class.java -> Fragment3("JUNGLE")
            Fragment4::class.java -> Fragment4("BOTTOM")
            Fragment5::class.java -> Fragment5("SUPPORT")
            else -> super.instantiate(classLoader, className)
        }
    }
}

class Fragment1(private val pos: String) : Fragment(R.layout.fragment_number) {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }

    private var _binding: FragmentNumberBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNumberBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.apply {
            number.text = pos
        }
        viewModel.start(Lane.valueOf(pos))
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.m4CardList.observe(viewLifecycleOwner, { c ->
            binding.apply {
                when (c.size) {
                    0 -> {
                        Log.d("12123", "없음")
                        visible(false)
                    }
                    1 -> {
                        visible(true)
                        Log.d("12123", "Fragment 에 card 가 ${c.size} 만큼 전달됨")
                        set0(c, this@Fragment1)
                    }
                    2 -> {
                        visible(true)
                        Log.d("12123", "Fragment 에 card 가 ${c.size} 만큼 전달됨")
                        set1(c, this@Fragment1)
                    }
                    3 -> {
                        visible(true)
                        Log.d("12123", "Fragment 에 card 가 ${c.size} 만큼 전달됨")
                        set2(c, this@Fragment1)
                    }
                    in 4..Int.MAX_VALUE -> {
                        visible(true)
                        Log.d("12123", "Fragment 에 card 가 ${c.size} 만큼 전달됨")
                        set3(c, this@Fragment1)
                    }
                }
            }
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

class Fragment2(private val pos: String) : Fragment(R.layout.fragment_number) {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }

    private var _binding: FragmentNumberBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNumberBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.apply {
            number.text = pos
        }
        viewModel.start(Lane.valueOf(pos))
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.m4CardList.observe(viewLifecycleOwner, { c ->
            binding.apply {
                when (c.size) {
                    0 -> {
                        Log.d("12123", "없음")
                        visible(false)
                    }
                    1 -> {
                        visible(true)
                        Log.d("12123", "Fragment 에 card 가 ${c.size} 만큼 전달됨")
                        set0(c, this@Fragment2)
                    }
                    2 -> {
                        visible(true)
                        Log.d("12123", "Fragment 에 card 가 ${c.size} 만큼 전달됨")
                        set1(c, this@Fragment2)
                    }
                    3 -> {
                        visible(true)
                        Log.d("12123", "Fragment 에 card 가 ${c.size} 만큼 전달됨")
                        set2(c, this@Fragment2)
                    }
                    in 4..Int.MAX_VALUE -> {
                        visible(true)
                        Log.d("12123", "Fragment 에 card 가 ${c.size} 만큼 전달됨")
                        set3(c, this@Fragment2)
                    }
                }
            }
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

class Fragment3(private val pos: String) : Fragment(R.layout.fragment_number) {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }

    private var _binding: FragmentNumberBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNumberBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.apply {
            number.text = pos
        }
        viewModel.start(Lane.valueOf(pos))
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.m4CardList.observe(viewLifecycleOwner, { c ->
            binding.apply {
                when (c.size) {
                    0 -> {
                        Log.d("12123", "없음")
                        visible(false)
                    }
                    1 -> {
                        visible(true)
                        Log.d("12123", "Fragment 에 card 가 ${c.size} 만큼 전달됨")
                        set0(c, this@Fragment3)
                    }
                    2 -> {
                        visible(true)
                        Log.d("12123", "Fragment 에 card 가 ${c.size} 만큼 전달됨")
                        set1(c, this@Fragment3)
                    }
                    3 -> {
                        visible(true)
                        Log.d("12123", "Fragment 에 card 가 ${c.size} 만큼 전달됨")
                        set2(c, this@Fragment3)
                    }
                    in 4..Int.MAX_VALUE -> {
                        visible(true)
                        Log.d("12123", "Fragment 에 card 가 ${c.size} 만큼 전달됨")
                        set3(c, this@Fragment3)
                    }
                }
            }
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

class Fragment4(private val pos: String) : Fragment(R.layout.fragment_number) {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }


    private var _binding: FragmentNumberBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNumberBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.apply {
            number.text = pos
        }
        viewModel.start(Lane.valueOf(pos))
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.m4CardList.observe(viewLifecycleOwner, { c ->
            binding.apply {
                when (c.size) {
                    0 -> {
                        Log.d("12123", "없음")
                        visible(false)
                    }
                    1 -> {
                        visible(true)
                        Log.d("12123", "Fragment 에 card 가 ${c.size} 만큼 전달됨")
                        set0(c, this@Fragment4)
                    }
                    2 -> {
                        visible(true)
                        Log.d("12123", "Fragment 에 card 가 ${c.size} 만큼 전달됨")
                        set1(c, this@Fragment4)
                    }
                    3 -> {
                        visible(true)
                        Log.d("12123", "Fragment 에 card 가 ${c.size} 만큼 전달됨")
                        set2(c, this@Fragment4)
                    }
                    in 4..Int.MAX_VALUE -> {
                        visible(true)
                        Log.d("12123", "Fragment 에 card 가 ${c.size} 만큼 전달됨")
                        set3(c, this@Fragment4)
                    }
                }
            }
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

class Fragment5(private val pos: String) : Fragment(R.layout.fragment_number) {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }

    private var _binding: FragmentNumberBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNumberBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.apply {
            number.text = pos
        }
        viewModel.start(Lane.valueOf(pos))
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.m4CardList.observe(viewLifecycleOwner, { c ->
            binding.apply {
                when (c.size) {
                    0 -> {
                        Log.d("12123", "없음")
                        visible(false)
                    }
                    1 -> {
                        visible(true)
                        Log.d("12123", "Fragment 에 card 가 ${c.size} 만큼 전달됨")
                        set0(c, this@Fragment5)
                    }
                    2 -> {
                        visible(true)
                        Log.d("12123", "Fragment 에 card 가 ${c.size} 만큼 전달됨")
                        set1(c, this@Fragment5)
                    }
                    3 -> {
                        visible(true)
                        Log.d("12123", "Fragment 에 card 가 ${c.size} 만큼 전달됨")
                        set2(c, this@Fragment5)
                    }
                    in 4..Int.MAX_VALUE -> {
                        visible(true)
                        Log.d("12123", "Fragment 에 card 가 ${c.size} 만큼 전달됨")
                        set3(c, this@Fragment5)
                    }
                }
            }
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

private fun FragmentNumberBinding.visible(isVisible: Boolean) {
    if (!isVisible) {
        card1.visibility = View.INVISIBLE
        card2.visibility = View.INVISIBLE
        card3.visibility = View.INVISIBLE
        card4.visibility = View.INVISIBLE
    } else {
        card1.visibility = View.VISIBLE
        card2.visibility = View.VISIBLE
        card3.visibility = View.VISIBLE
        card4.visibility = View.VISIBLE
    }
}

private fun FragmentNumberBinding.set0(c: List<Card>, fragment: Fragment) {
    Glide.with(fragment)
        .load(c[0].iconUrl)
        .apply(
            RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_baseline_broken_image)
        ).into(iv1)
    cn1.text = c[0].cn
    "${String.format("%.1f", c[0].grade)} 평점  ".also { grade1.text = it }
    wl1.text = c[0].wl
}

private fun FragmentNumberBinding.set1(c: List<Card>, fragment: Fragment) {
    Glide.with(fragment)
        .load(c[1].iconUrl)
        .apply(
            RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_baseline_broken_image)
        ).into(iv2)
    cn2.text = c[1].cn
    "${String.format("%.1f", c[1].grade)} 평점  ".also { grade2.text = it }
    wl2.text = c[1].wl
    set0(c, fragment)
}

private fun FragmentNumberBinding.set2(c: List<Card>, fragment: Fragment) {
    Glide.with(fragment)
        .load(c[2].iconUrl)
        .apply(
            RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_baseline_broken_image)
        ).into(iv3)
    cn3.text = c[2].cn
    "${String.format("%.1f", c[2].grade)} 평점  ".also { grade3.text = it }
    wl3.text = c[2].wl
    set1(c, fragment)
}

private fun FragmentNumberBinding.set3(c: List<Card>, fragment: Fragment) {
    Glide.with(fragment)
        .load(c[3].iconUrl)
        .apply(
            RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_baseline_broken_image)
        ).into(iv4)
    cn4.text = c[3].cn
    "${String.format("%.1f", c[3].grade)} 평점  ".also { grade4.text = it }
    wl4.text = c[3].wl
    set2(c, fragment)
}
