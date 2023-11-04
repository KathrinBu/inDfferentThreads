import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class PetrolStation implements Runnable {
    private final int carNumber;
    private final PetrolStationAmount petrolStationAmount;
    private final int fuel;

    public PetrolStation(int carNumber, PetrolStationAmount petrolStationAmount, int fuel) {
       this.carNumber = carNumber;
        this.petrolStationAmount = petrolStationAmount;
        this.fuel = fuel;
    }

    @Override
    public void run() {

        System.out.println("Заправляется автомобиль " + carNumber + " (" + fuel + " литров )");

        try {
            Thread.sleep((long) ((Math.random()*8000)+3000));
            System.out.println("Остаток АЗС после заправки автомобиля " + carNumber + " - " + doRefuel() + " литров");
        } catch (InterruptedException e) {
            System.out.println("_:((");
        }
    }

    public int doRefuel(){
        petrolStationAmount.setAmount(petrolStationAmount.getAmount() - fuel);
        return petrolStationAmount.getAmount();
    }

}
