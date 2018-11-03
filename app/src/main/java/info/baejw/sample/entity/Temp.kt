package info.baejw.sample.entity

data  class Temp (
        val titleid: Int,
        val weekday: String,
        val title: String,
        val thumbnail: String,
        val no: String
//        val updt: Boolean,
//        val updt_updated_on: String
)

data class Result (val items: List<Temp>)