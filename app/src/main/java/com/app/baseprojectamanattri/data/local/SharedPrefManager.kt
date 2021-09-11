package com.app.baseprojectamanattri.data.local

import android.content.SharedPreferences
import com.app.baseprojectamanattri.domain.post.models.PostModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class SharedPrefManager @Inject constructor(val sharedPreferences: SharedPreferences) {

    private val gson = Gson()

    companion object {
        const val SESSION_ID = "session_id"
        const val POSTS="posts"
    }

    fun saveSessionId(sessionId: String) {
        sharedPreferences.saveValue(SESSION_ID, sessionId)
    }

    fun getSessionId(): String? {
       return sharedPreferences.getValue(SESSION_ID)
    }

    fun savePosts(it: List<PostModel>?) {
        var posts=gson.toJson(it)
        sharedPreferences.saveValue(POSTS,posts)
    }
    fun getPosts(): List<PostModel>? {
        var posts=sharedPreferences.getValue<String>(POSTS)
        val empMapType = object : TypeToken<List<PostModel>>() {}.type
        return gson.fromJson<List<PostModel>>(posts, empMapType)
    }

}

private fun SharedPreferences.saveValue(key: String, value: Any?) {
    when (value) {
        is String? -> editNdCommit { it.putString(key, value) }
        is Int -> editNdCommit { it.putInt(key, value) }
        is Boolean -> editNdCommit { it.putBoolean(key, value) }
        is Float -> editNdCommit { it.putFloat(key, value) }
        is Long -> editNdCommit { it.putLong(key, value) }
        else -> throw UnsupportedOperationException("Not yet implemented")
    }
}

private fun <T> SharedPreferences.getValue(key: String, defaultValue: Any?=null):T? {
   return when (defaultValue) {
        is String? ->{getString(key,defaultValue as? String) as? T}
        is Int -> {getInt(key,defaultValue as? Int?:-1) as? T}
        is Boolean -> getBoolean(key, defaultValue as? Boolean ?: false) as? T
        is Float -> getFloat(key, defaultValue as? Float ?: -1f) as? T
        is Long -> getLong(key, defaultValue as? Long ?: -1) as? T
        else -> throw UnsupportedOperationException("Not yet implemented")
    }
}

inline fun SharedPreferences.editNdCommit(operation: (SharedPreferences.Editor) -> Unit) {
    val editor = this.edit()
    operation(editor)
    editor.apply()
}

