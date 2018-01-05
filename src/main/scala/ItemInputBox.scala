import scala.swing._
/** A box self-containing an input gui for `Item`s. 
 *  If I were interested in making this project really good, the two member functions would be replaced with
 *  a single apply() returning the `Item`, and the rest of the functionality would be moved out of the class.
 *  
 *  @param input Function acception a `Seq[Item]`, where the box will place new `Item`s generated
 *  @param source Function giving a `Seq[Item]` on which to append new items
 */
class ItemInputBox(input: (Seq[Item]) => Unit, source: () => Seq[Item]) extends BoxPanel(Orientation.Horizontal) {
    val itemName = new TextField
    itemName.editable = true
    val index = new TextField
    index.editable = true
    val textBoxSize = new Dimension(200,20)
    itemName.maximumSize = textBoxSize
    index.maximumSize = textBoxSize
    val send = new Action("send an item") {
        def apply(): Unit = { sendItem() }
    }
    index.action = send
    itemName.action = send
    contents += new BoxPanel(Orientation.Vertical) {
        contents += new Label("Name:")
        contents += itemName
        contents += Swing.VStrut(10)
        contents += new Label("Index:")
        contents += index
    }
    contents += Swing.HStrut(10)
    val addItem = Button("Add Item!") {sendItem}
    contents += addItem

    private def sendItem() = {
        try {
            input( source() :+ new Item(itemName.text, index.text.toInt))
            itemName.text = ""
            index.text = ""
        } catch {
            case e: NumberFormatException =>
                index.text = ""
        }
    }
}
    
