public class RiderList implements IRiderList{
private LinkedList<IRider> ir;

public RiderList(){
ir=new LinkedList<IRider>();
}

    // Inserts a rider into the list in sorted order by ID. If a rider with the same ID already exists, insertion fails.
public boolean add(IRider rider){
if(rider==null)
return false;

if(ir.empty()){
ir.insert(rider);
return true;
}

ir.findFirst();

while(true){
IRider r=ir.retrieve();

if(rider.compareTo(r)==0)
return false;

else

if(rider.compareTo(r)<0){
ir.insertBeforeCurrent(rider);
return true;
}
if(ir.last())
break;

ir.findNext();
}

ir.insert(rider);
return true;
}


    //Searches for a rider by ID.
public IRider findById(int riderId){
    if(ir.empty())
    return null;
    
    ir.findFirst();
    while(true){
    IRider tmp= ir.retrieve();
    
    if(tmp.getId()==riderId)
    return tmp;
    
    if(ir.last())
    break;
    
    ir.findNext();
    }
    return null;
    
    }

    // Searches for all riders with the given full name.
public LinkedList<IRider> findByName(String fullName){
    LinkedList<IRider> sameN=new LinkedList<IRider>();
    
    if(ir.empty())
    return sameN;   
   
    ir.findFirst();
    
    while(true){
    IRider tmp= ir.retrieve();
    
    if(tmp.getName().equals(fullName))
    sameN.insert(tmp);
    
    if(ir.last())
    break;
    
    ir.findNext();
    }
    return sameN;   
    
    
    }

    //Searches for a rider by email address.
public IRider findByEmail(String email){
    if(ir.empty())
    return null; 
    
    ir.findFirst();
    while(true){
    IRider tmp= ir.retrieve();
    
    if(tmp.getEmail().equals(email))
    return tmp;
    
    if(ir.last())
    break;
    
    ir.findNext();
    }
    return null;
    }

    //Returns all riders from the specified home city.
public LinkedList<IRider> findByHomeCity(String homeCity){
    
    LinkedList<IRider> sameC = new LinkedList<IRider>();
    
    if(ir.empty())
    return sameC;
    
    ir.findFirst();
    while(true){
    IRider tmp=ir.retrieve();
    
    if(tmp.getHomeCity().equals(homeCity))
    sameC.insert(tmp);
    
    if(ir.last())
    break;
    
    ir.findNext();   
    }
    return sameC;
    
    }

    //Returns all riders in the linked list.
public LinkedList<IRider> getAll(){
    return ir;
    
    }

    //Removes a rider by ID. Returns true if a rider with that ID was found and removed; false otherwise.
public boolean removeById(int riderId){
    if(ir.empty())
    return false;
    
    ir.findFirst();
    
    while(true){
    IRider tmp=ir.retrieve();
    
    if(tmp.getId()==riderId){
    ir.remove();
    return true;
    }
    
    if(ir.last())
    break;
    
    ir.findNext();
    }
    return false;
    }

    //Removes a rider by email address. Returns true if a rider with that email was found and removed; false otherwise.
public boolean removeByEmail(String email){
     if(ir.empty())
    return false;
    
    ir.findFirst();
    
    while(true){
    IRider tmp=ir.retrieve();
    
    if(tmp.getEmail().equals(email)){
    ir.remove();
    return true;
    }
    
    if(ir.last())
    break;
    
    ir.findNext();
    }
    return false;
    }

    /**
     * Name and home city are not unique, so more than one rider may match.
     * Removes every rider whose full name exactly matches the given name
     * (the same full-name equality used by findByName), not a first-name-only
     * or partial match.
     * Returns the number of riders removed (0 if none matched).
     */
public int removeByName(String fullName){
   
    if(ir.empty())
    return 0;
    
    int count=0;
    ir.findFirst();
    while(true){
    IRider tmp=ir.retrieve();
    
    if(tmp.getName().equals(fullName)){
    count++;
    ir.remove();   
    
    if(ir.empty())
    break;
    
    if(ir.last())
    break;
    }
    else
    
    if(ir.last())
    break;
    
    else
    ir.findNext();
    }
    
    return count;
    
    }

    /**
     * Removes every rider from the specified home city.
     * Returns the number of riders removed (0 if none matched).
     */
public int removeByHomeCity(String homeCity){
     
    if(ir.empty())
    return 0;
    
    int count=0;
    ir.findFirst();
    while(true){
    IRider tmp=ir.retrieve();
    
    if(tmp.getHomeCity().equals(homeCity)){
    count++;
    ir.remove();   
    
    if(ir.empty())
    break;
    }
    else
    
    if(ir.last())
    break;
    
    else
    ir.findNext();
    }
    
    return count;
    }

    //return the total number of riders stored.
public int size(){
    return ir.getSize();
    }
}
