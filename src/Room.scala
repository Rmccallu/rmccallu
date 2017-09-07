package MUD

/**
 * Rooms contain the name of the room
 * Description of the room
 * List of items in the room
 * And exits
 */
class Room (name:String, desc:String, items:Array[Item], exits:Array[Int])

object room {
  val rooms = readRoomsFromFile()
  
  /**
   * Reads room in from a text file 
   * Then saves the data and closes the source
   */
  def readRoomsFromFile():Array[Room] = {
    val source = io.Source.fromFile("Rooms.txt")
    val lines = source.getLines()
    val r = Array.fill(lines.next.toInt)(readRoom(lines))
    source.close()
    r
  }
  /**
   * The command that reads the room  
   */
  def readRoom(lines:Iterator[String]):  Room = {
    val name = lines.next()
    val desc = lines.next()
    /**
     *  Item contains no description, so it just converts a single line into a list
     */
    val items = lines.next().split(";").map(name => new Item(name))
    /**
     * Exits is a sequence of numbers in the order 
  	 * North, then South, then East, then West, then Up, then Down
  	 * -1 means there's no room, rooms are sequenced starting from 0.
     */
    val exits = lines.next().split(" ").map(_.toInt)
    /**
     * Makes the room out of these parts
     */
    new Room(name, desc, items, exits)
  }
}

