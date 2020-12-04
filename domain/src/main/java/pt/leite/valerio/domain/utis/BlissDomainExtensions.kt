package pt.leite.valerio.domain.utis

import java.util.*

fun <T> List<T>.random(): T? = if (size > 0) get(Random().nextInt(size)) else null
