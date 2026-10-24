
public class RideList implements IRideList {

    private LinkedList<IRide> rides;

    public RideList() {
        rides = new LinkedList<IRide>();
    }

    @Override
    public int size() {
        int count = 0;

        if (rides.empty()) {
            return 0;
        }

        rides.findFirst();

        while (true) {
            count++;

            if (rides.last()) {
                break;
            }

            rides.findNext();
        }

        return count;
    }

    @Override
    public boolean addRide(IRide ride) {
        if (ride == null) {
            return false;
        }

        // Reject duplicate ride IDs
        if (!rides.empty()) {
            rides.findFirst();

            while (true) {
                if (rides.retrieve().getRideId() == ride.getRideId()) {
                    return false;
                }

                if (rides.last()) {
                    break;
                }

                rides.findNext();
            }
        }

        // Empty list
        if (rides.empty()) {
            rides.insert(ride);
            return true;
        }

        rides.findFirst();

        while (true) {

            // Insert alphabetically before current ride
            if (ride.compareTo(rides.retrieve()) < 0) {
                IRide oldRide = rides.retrieve();

                rides.update(ride);
                rides.insert(oldRide);

                return true;
            }

            // Insert at the end
            if (rides.last()) {
                rides.insert(ride);
                return true;
            }

            rides.findNext();
        }
    }

    @Override
    public boolean removeRideById(int rideId) {
        if (rides.empty()) {
            return false;
        }

        rides.findFirst();

        while (true) {
            IRide currentRide = rides.retrieve();

            if (currentRide.getRideId() == rideId) {
                rides.remove();
                return true;
            }

            if (rides.last()) {
                break;
            }

            rides.findNext();
        }

        return false;
    }

    @Override
    public LinkedList<IRide> getAllAlphabetically() {
        return rides;
    }

    @Override
    public LinkedList<IRide> findByPickupLocation(String pickupLocation) {
        LinkedList<IRide> results = new LinkedList<IRide>();

        if (rides.empty() || pickupLocation == null) {
            return results;
        }

        rides.findFirst();

        while (true) {
            IRide ride = rides.retrieve();

            if (pickupLocation.equals(ride.getPickupLocation())) {
                if (results.empty()) {
                    results.insert(ride);
                } else {
                    results.findFirst();

                    while (!results.last()) {
                        results.findNext();
                    }

                    results.insert(ride);
                }
            }

            if (rides.last()) {
                break;
            }

            rides.findNext();
        }

        return results;
    }

    @Override
    public LinkedList<IRide> findByRiderName(String riderFullName) {
        LinkedList<IRide> results = new LinkedList<IRide>();

        if (rides.empty() || riderFullName == null) {
            return results;
        }

        rides.findFirst();

        while (true) {
            IRide ride = rides.retrieve();
            boolean found = false;

            // Check private ride
            if (ride instanceof IPrivateRide) {
                IRider rider = ((IPrivateRide) ride).getRider();

                if (rider != null &&
                    riderFullName.equals(rider.getName())) {
                    found = true;
                }
            }

            // Check shared ride
            else if (ride instanceof ISharedRide) {
                LinkedList<IRider> participants =
                    ((ISharedRide) ride).getParticipants();

                if (!participants.empty()) {
                    participants.findFirst();

                    while (true) {
                        IRider rider = participants.retrieve();

                        if (rider != null &&
                            riderFullName.equals(rider.getName())) {
                            found = true;
                            break;
                        }

                        if (participants.last()) {
                            break;
                        }

                        participants.findNext();
                    }
                }
            }

            // Add matching ride to results
            if (found) {
                if (results.empty()) {
                    results.insert(ride);
                } else {
                    results.findFirst();

                    while (!results.last()) {
                        results.findNext();
                    }

                    results.insert(ride);
                }
            }

            if (rides.last()) {
                break;
            }

            rides.findNext();
        }

        return results;
    }
}
