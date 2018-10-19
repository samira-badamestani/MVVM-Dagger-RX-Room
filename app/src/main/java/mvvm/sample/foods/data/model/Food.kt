package mvvm.sample.foods.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Food(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id") var id: Int,
    @SerializedName("title") var title: String,
    @SerializedName("href") var href: String,
    @SerializedName("ingredients") var ingredients: String,
    @SerializedName("thumbnail") var thumbnail: String
)