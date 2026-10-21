public class Rider extends Person implements IRider{
private String email;
private String homeCity;

public Rider(int id, String name, String phoneNumber, String email, String homecity){
super(id, name, phoneNumber);
this.email=email;
homeCity=homecity;
}


    //return the rider's email address.
public String getEmail(){
    return email;
    }

    //Sets the rider's email address.
public void setEmail(String email){
    this.email=email;
    } 

    //return the rider's home city.
public String getHomeCity(){
    return homeCity;
    }

    //Sets the rider's home city.
public void setHomeCity(String homecity){
homeCity=homecity;
    }

    /**
     * Compares this rider with another rider based on rider ID.
     * Returns a negative integer, zero, or a positive integer as this
     * rider's ID is less than, equal to, or greater than the other
     * rider's ID. This ordering must be consistent with equality by ID.
     */
    @Override
public int compareTo(IRider other){
    return this.getId() - other.getId();
    }
    
public String toString(){
    return "Rider: "+super.toString()+" - "+"Email: "+email+" - "+"Home City: "+homeCity;
    }
}
