package ru.appzmm.webapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.appzmm.webapp.databinding.FragmentPlusBottomSheetBinding

class PlusBottomSheetFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentPlusBottomSheetBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlusBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNewTask.setOnClickListener {
            Toast.makeText(context, "Создание новой задачи (будет реализовано позже)", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        binding.btnNewProject.setOnClickListener {
            Toast.makeText(context, "Создание нового проекта (будет реализовано позже)", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        binding.btnNewPage.setOnClickListener {
            Toast.makeText(context, "Создание новой страницы (будет реализовано позже)", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        binding.btnCancel.setOnClickListener {
            dismiss()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
