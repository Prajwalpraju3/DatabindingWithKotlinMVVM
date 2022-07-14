package com.onnet.databinding.binding

import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.onnet.databinding.R
import android.text.TextUtils
import android.view.View
import android.widget.ImageView

object BindingUtils {
    @JvmStatic
    @BindingAdapter("image_url")
    fun loadImage(imageView: ImageView, url: String?) {
        Glide.with(imageView.context)
            .load(url) // image url
            .placeholder(R.drawable.ic_launcher_foreground) // any placeholder to load at start
            .error(R.drawable.ic_launcher_foreground) // any image in case of error
            .override(400, 400) // resizing
            .centerCrop()
            .into(imageView)
    }

    @BindingAdapter("visible")
    fun setVisible(view: View, visible: Boolean) {
        if (visible) {
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.GONE
        }
    }

    fun splitDateAndTime(dateAndTime: String): Array<String>? {
        return if (TextUtils.isEmpty(dateAndTime)) null else dateAndTime.split("T").toTypedArray()
    }

    fun formatAuthor(author: String?): String {
        /*If author is null or contains the text null(which seems to be the case here),
        return an empty string, otherwise add "By" to the author*/
        return if (author == null || author == "null") "" else "By $author"
    }

    fun hideCharCount(content: String): String {
        /*Contents of articles in NewsApi are limited and they finish by
        a word count like: "...[+1600 chars]". This method is for hiding
        those last brackets*/
        val lastIndex = content.lastIndexOf("[+")

        /*If lastIndex is positive, then create a substring up to that point.
        If lastName is not positive, that means those characters are not found,
        then return the whole content*/return if (lastIndex > 0) content.substring(
            0,
            lastIndex
        ) else content
    }
}