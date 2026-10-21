public class Driver extends Person implements IDriver {
    private String vehiclePlate;
    private VehicleType vehicleType;

    public Driver(int id, String name, String phoneNumber, String vehiclePlate, VehicleType vehicleType){
        super(id, name, phoneNumber);
        setVehiclePlate(vehiclePlate);
        this.vehicleType = vehicleType;
    }

    @Override
    public String getVehiclePlate(){
        return vehiclePlate;
    }

    @Override
    public void setVehiclePlate(String vehiclePlate) {
        if (vehiclePlate == null || vehiclePlate.length() != 7) {
            throw new IllegalArgumentException("vehicle plate must follow the format of exactly 3 uppercase letters followed by 4 digits");
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isUpperCase(vehiclePlate.charAt(i))) {
                throw new IllegalArgumentException("vehicle plate must start with 3 uppercase letters");
            }
        }

        for (int i = 3; i < 7; i++) {
            if (!Character.isDigit(vehiclePlate.charAt(i))) {
                throw new IllegalArgumentException("vehicle plate must end with 4 digits");
            }
        }

        this.vehiclePlate = vehiclePlate;
    }

    @Override
    public VehicleType getVehicleType(){
        return vehicleType;
    }

    @Override
    public void setVehicleType(VehicleType vehicleType){
        this.vehicleType = vehicleType;
    }

    @Override
    public int compareTo(IDriver other){
        return this.getId() - other.getId();
    }

    @Override
    public String toString(){
        return "Driver: " + super.toString() + " - Vehicle Plate: " + vehiclePlate + " - Vehicle Type: " + vehicleType;
    }
}
