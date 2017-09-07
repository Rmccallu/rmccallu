package MUD

/**
* The player runs the commands from the user and stores the inventory
*/
class Player(inventory:List[Item]) {
  /**
   * Detects commands from the command line, which is entered in a different location
   */
  def processCommand(command:String) = {
    val com = command.split(" ")
    if (com(0) == "drop") getFromInventory(com(1))
    else if (com(0) == "get") addToInventory(com(1))
    else if (com(0) == "inventory") inventoryListing() 
    else if (com(0) == "north||south||east||west||up||down") move(com(0)) 
    else if (com(0) == "help") help
    else "That is not a valid command. Type help to see all the commands"
  }
  /**
   * The "Drop" command 
   * Check if the item is in the inventory 
   * If it is, removes it and drops it into the room
   * Otherwise it tells processCommand that it wasn't there
   */
  def getFromInventory(itemName: String): Option[Item] = {
    if (inventory.contains(_.n == itemName)) {
      val location = inventory.indexWhere(_.n == itemName)
      /**
       * Saves the item before it is removed
       */
      val item = inventory(location)
      /**
       * Removes item from the inventory if it was found
       */
     inventory = inventory.filterNot.(item)
      Some(item)
    }
    else None
  }
  /**
   * If the item was already confirmed to be in the room, adds it to inventory
   */
  def addToInventory(item:String): Unit = {
    ???
  }
  /**
   * Prints all the item names of items in your inventory
   */
  def inventoryListing(): String = {
    mkString(inventory)
  }
  /**
   * Moves the player. 
   * It moves to another room inside the code 
   * and returns a boolean of if it worked
   */
  def move(dir:String): Boolean = {
    ???
  }
  /**
   * Lists all commands
   */
  def help = {
    println("drop. Drops an item from your inventory onto the ground")
    println("get. Adds an item from the room into your inventory")
    println("inventory. Lists all the items in your inventory")
    println("north, south, east, west, up, down. Moves you in that direction")
  }
}