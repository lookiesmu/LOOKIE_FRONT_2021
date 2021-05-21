package com.muleo.week5

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.snackbar.Snackbar
import com.muleo.week5.databinding.FragmentDialogBinding
import com.muleo.week5.db.Event
import java.text.SimpleDateFormat

class Fragment(private val viewModel: ViewModel) : DialogFragment() {

    private var from: Long = System.currentTimeMillis()
    private var to: Long = System.currentTimeMillis()

    private lateinit var binding: FragmentDialogBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {


        binding = FragmentDialogBinding.inflate(requireActivity().layoutInflater)
        val dialog = AlertDialog.Builder(requireContext())
            .setView(binding.root)
            .setMessage("New event")
            .setPositiveButton("Save") { _, _ ->
                if (binding.etName.text.isNullOrEmpty() ||
                    binding.etFrom.text.isNullOrEmpty() ||
                    binding.etTo.text.isNullOrEmpty()
                ) {
                    activity?.let {
                        Snackbar
                            .make(it.findViewById(R.id.layout), "Error", Snackbar.LENGTH_SHORT)
                            .setAction("Re") {
                                 viewModel.onDialog()
                            }
                            .show()
                    }
                } else {
                    val event = Event(
                        name = binding.etName.text.toString(),
                        from = from,
                        to = to
                    )
                    viewModel.onSave(event)
                }
            }
            .create()

        binding.apply {
            tiFrom.setEndIconOnClickListener {
                hideSoftKeyboard(etName)
                Log.d("Fragment", "tiFrom icon is clicked")
                datePicker(etFrom)
                    .show(childFragmentManager, TAG_DATE)
            }

            tiTo.setEndIconOnClickListener {
                hideSoftKeyboard(etName)
                Log.d("Fragment", "tiTo icon is clicked")
                datePicker(etTo)
                    .show(childFragmentManager, TAG_DATE)
            }
        }

        return dialog
    }

    override fun onResume() {
        super.onResume()
        showSoftKeyboard(binding.etName)
    }

    companion object {
        const val TAG = "Fragment"
        const val TAG_DATE = "DATE"
        const val DATE_FORMAT = "MMM dd, yyyy"
        const val DATE_FORMAT_DAY_OF_WEEK = "EEE"
        const val DATE_FORMAT_DAY = "d"
    }

    private fun showSoftKeyboard(view: EditText) {
        Log.d("Fragment", "showSoftKeyboard")
        if (view.requestFocus()) {
            Log.d("Fragment", "showSoftKeyboard")
            val imm =
                requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.toggleSoftInput(
                InputMethodManager.SHOW_FORCED,
                InputMethodManager.HIDE_NOT_ALWAYS
            )
//            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }
    }

    private fun hideSoftKeyboard(view: EditText) {
        val imm =
            requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    @SuppressLint("SimpleDateFormat")
    fun datePicker(on: EditText): MaterialDatePicker<Long> {
        return MaterialDatePicker.Builder.datePicker()
            .setTitleText("Select date")
            .build()
            .apply {
                addOnPositiveButtonClickListener {
                    when (on.id) {
                        R.id.etFrom -> from = it
                        R.id.etTo -> to = it
                    }
                    val date = SimpleDateFormat(DATE_FORMAT).format(it)
                    on.setText(date)
                }
                addOnNegativeButtonClickListener { }
                addOnCancelListener { }
                addOnDismissListener { }
            }
    }
}