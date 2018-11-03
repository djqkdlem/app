package info.baejw.sample.entity

data class Board(
        val BoardID: String?,
        val title: String,
        val Url: String,
        val desc: String,
        val IsDeleted: Boolean?
//        val createdDT: String,
//        val updatedDT: String
)

data class BoardList (val items: List<Board>)