
case class Item(val text: String, val index: Int) extends Ordered[Item] {
    def compare(that: Item): Int = {
        if(that.index == index)
            0
        if(that.index > index)
            -1
        else
            1
    }
    override def toString(): String = { s"$text $index" }
}
