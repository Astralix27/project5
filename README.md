![Project 5 Diagram](https://user-images.githubusercontent.com/47227934/57044591-aa208a00-6c30-11e9-8c77-a7b94bb51e3a.png)
DrawPanel
  
  DrawPanel
    this constuctor intializes the points into an arraylist that had been made     and sets the radius that had been made. It also sets the border of the line     that is being drawn to black
    
  addPoint
    this method adds points into the arraylist.
    
  clear
    this method will clear the the draw panel
    
  paintComponent
    This method sets the color to red and sets the stroke of the "brush" to 5.
    It also chooses whoch shapw is being drawn, in this case it's an oval
    
HammingDistancePanel
  
  HammingDistancePanel
    this constructor sets the Jframe that will be used to put the stations of
    the txt file into a jcombobox that will then be used to figure out stations
    that have the same hamming distance with the given station inside the box.
    It will also figure out the nodes of the given station and be able to add
    stations into the box in alphabetical order. It also has a drawing panel to
    draw.
    
  main
    Makes the HammingDistancePanel object to be used.
    
HammingDistance
   
   HammingDistance
    this constructor calls the attemptoread method and sets the station id and
    the nodes that have already been initialized
    
   attemptToRead
    this method tries to calls the read method and if it doesn't it will throw
    an exception
    
   read
    this method will read the txt file and store each line into a arraylist
    that has been initialized
    
   calDist
    this method will the distance of each station compared to the given station
    and will store it into an arraylist that either has a s distance of 1-4.
    Then it will return the arraylist that is based on the given parameter.
    
   getDist
    this method will check the hamming distance of two given stations and will
    return the distance
    
    getNodes(String)
    this method will go through an arraylist of stations compare to a given
    station and will get the hamming distance (1-4) then store it into an
    array
    
   getStation
    this method returns the arraylist that is filled with stations names
    
   getNodes
    this method will return the nodes of a given station
   
MesoStation
  
  MesoStation
    this contructor sets the station id
    
  getStID
    this method return the id of the station
    
Stations
  
  Stations
    this constuctor uses an MesoStation object to set the station name 
    
  calAverage
    this method will calculate the average ascii number of the given station
    and return the average.
  
