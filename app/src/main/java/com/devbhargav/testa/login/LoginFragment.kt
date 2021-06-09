package com.devbhargav.testa.login

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.devbhargav.testa.MainActivity
import com.devbhargav.testa.R
import com.devbhargav.testa.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private lateinit var _binding: FragmentLoginBinding
    private lateinit var loginViewModel: LoginViewModel
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loginViewModel =
            ViewModelProvider(this).get(LoginViewModel::class.java)

        _binding = FragmentLoginBinding.inflate(inflater, container, false)



        binding.btnLogin.setOnClickListener {
            if (TextUtils.isEmpty(binding.txtEmailAddress.text)) {
                binding.txtEmailAddress.setError("Enter an E-Mail Address")
                binding.txtEmailAddress.requestFocus()
            } else if (TextUtils.isEmpty(binding.txtPassword.text)) {
                binding.txtPassword.setError("Enter a Password")
                binding.txtPassword.requestFocus()
            } else {
                //Move to next screen
                (context as MainActivity).moveToNextFragment(R.id.nav_category)
            }
        }



        return binding.root
    }
}