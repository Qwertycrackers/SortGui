import scala.swing._

class SortGui extends MainFrame {
    title = "List some sortable things" 
    val list = new ListView(new Array[Item](0)) //list of all the items
    list.minimumSize= new Dimension(100,25)
    val input = new ItemInputBox(list.listData_= _, list.listData _) //the place to input the items
    contents = new BoxPanel(Orientation.Horizontal) { //the left/right split
        contents += new BoxPanel(Orientation.Vertical) {
            contents += list //put the list on the left
            contents += Swing.VStrut(10)
            contents += Swing.VGlue
            contents += Button("Close") {sys.exit(0)} //close button
            minimumSize = new Dimension(500,500)
        }
        contents += Swing.HStrut(10) //space them out 10p
        contents += Swing.HGlue //let them expand
        contents += new BoxPanel(Orientation.Vertical) {
            contents += input //put the input stuff on the top right
            contents += Swing.VStrut(10)
            contents += Swing.VGlue
            contents += Button("Sort!") { list listData_= (list.listData.sorted) } //sort button
        }
    border = Swing.EmptyBorder(10, 10, 10, 10) //10-pixel empty border
    }
}

