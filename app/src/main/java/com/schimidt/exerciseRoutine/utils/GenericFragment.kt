package com.schimidt.exerciseRoutine.utils

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.schimidt.exerciseRoutine.navigation.NavigationController
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

abstract class GenericFragment(@LayoutRes resId: Int) : Fragment(resId) {
    val navigation by inject<NavigationController> { parametersOf(findNavController()) }
}