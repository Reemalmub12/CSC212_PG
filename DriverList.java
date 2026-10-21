public class DriverList implements IDriverList {
private LinkedList<IDriver> idr;

public DriverList(){
idr=new LinkedList<IDriver>();
}

    // Inserts a driver into the list in sorted order by ID. If a driver with the same ID already exists, insertion fails.
    public boolean add(IDriver driver){
    if(driver==null)
    return false;
    
    if(idr.empty()){
idr.insert(driver);
return true;
}

idr.findFirst();

while(true){
IDriver d=idr.retrieve();

if(driver.compareTo(d)==0)
return false;

if(d.getVehiclePlate().equals(driver.getVehiclePlate()))
return false;

if(driver.compareTo(d)<0){
idr.insertBeforeCurrent(driver);
return true;
}

if(idr.last())
break;

idr.findNext();
}

idr.insert(driver);
return true;
}

    //Searches for a driver by ID.
    public IDriver findById(int driverId){
    if(idr.empty())
    return null;
    
    idr.findFirst();
    while(true){
    IDriver dr=idr.retrieve();
    if(dr.getId()==driverId)
    return dr;
    
    if(idr.last())
    break;
    
    idr.findNext();
    }
    return null;
    
    }

    // Searches for all drivers with the given full name.
   public LinkedList<IDriver> findByName(String fullName){
    LinkedList<IDriver> sameN=new LinkedList<IDriver>();
    
    if(idr.empty())
    return sameN;
    
    idr.findFirst();
    
    while(true){
    IDriver dr=idr.retrieve();
    
    if(dr.getName().equals(fullName))
    sameN.insert(dr);
    
    if(idr.last())
    break;
    
    idr.findNext();
    }
    return sameN;
    }

    //Searches for a driver by vehicle plate number.
   public IDriver findByVehiclePlate(String vehiclePlate){
    if(idr.empty())
    return null;
    
    idr.findFirst();
    
    while(true){
    IDriver dr=idr.retrieve();
    
    if(dr.getVehiclePlate().equals(vehiclePlate))
    return dr;
    
    if(idr.last())
    break;
    
    idr.findNext();
    }
    return null;
    }

    //Returns all drivers with the specified vehicle type.
    public LinkedList<IDriver> findByVehicleType(VehicleType vehicleType){
    LinkedList<IDriver> sameV =new LinkedList<IDriver>();
    
    if(idr.empty())
    return sameV;
    
    idr.findFirst();
    while(true){
    IDriver dr=idr.retrieve();
    
    if(dr.getVehicleType()==vehicleType)
    sameV.insert(dr);
    
    if(idr.last())
    break;
    
    idr.findNext();
    }
    return sameV;
    }

    //Returns all drivers in the linked list.
    public LinkedList<IDriver> getAll(){
    return idr;
    
    }

    //Removes a driver by ID. Returns true if a driver with that ID was found and removed; false otherwise.
   public  boolean removeById(int driverId){
   if(idr.empty())
   return false;
   
   idr.findFirst();
   while(true){
   IDriver dr= idr.retrieve();
   
   if(dr.getId()==driverId){
   idr.remove();
   return true;
   }
   
   if(idr.last())
   break;
   
   idr.findNext();
   }
   return false;
    }

    //Removes a driver by vehicle plate number. Returns true if a driver with that plate was found and removed; false otherwise.
    public boolean removeByVehiclePlate(String vehiclePlate){
    if(idr.empty())
    return false;
    
    idr.findFirst();
    while(true){
    IDriver dr=idr.retrieve();
    
    if(dr.getVehiclePlate().equals(vehiclePlate)){
    idr.remove();
    return true;
    }
    
    if(idr.last())
    break;
    
    idr.findNext();
    }
    return false;
    
    }

    /**
     * Name and vehicle type are not unique, so more than one driver may match.
     * Removes every driver whose full name exactly matches the given name
     * (the same full-name equality used by findByName), not a first-name-only
     * or partial match.
     * Returns the number of drivers removed (0 if none matched).
     */
    public int removeByName(String fullName){
    if(idr.empty())
    return 0;
    
    int count=0;
    idr.findFirst();
    while(true){
    IDriver dr=idr.retrieve();
    
    if(dr.getName().equals(fullName)){
    count++;
    idr.remove();
    
    if(idr.empty())
    break;
    
    if(idr.last())
    break;
    }
    
    else
    if(idr.last())
    break;
    
    else
    idr.findNext();
    }
    return count;
    }

    /**
     * Removes every driver with the specified vehicle type.
     * Returns the number of drivers removed (0 if none matched).
     */
    public int removeByVehicleType(VehicleType vehicleType){
    if(idr.empty())
    return 0;
    
    int count=0;
    idr.findFirst();
    while(true){
    IDriver dr=idr.retrieve();
    
    if(dr.getVehicleType()==vehicleType){
    count++;
    idr.remove();
    
    if(idr.empty())
    break;
    
    if(idr.last())
    break;
   }
   
   else
   if(idr.last())
   break;
   
   else
   idr.findNext();
   }
   return count;
    }

    //return the total number of drivers stored.
    public int size(){
    return idr.getSize();
    }
}
