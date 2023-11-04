/*
Заправка заправляет 3 автомобиля. У станции есть общее количество литров.
Заправка авто - это поток в котором указывается какая машина и на сколько литров заправляется,
время на заправку от 3 - 10 секунд и сообщение об остатке литров на станцию.
Нужно сделать так, чтобы после завершения каждого потока уменьшалось общее количество литров на станции.
 */


public class Main {
    public static void main(String[] args) {

        PetrolStationAmount petrolStationAmount = new PetrolStationAmount(500);

        Thread[] threads = {
                new Thread(new PetrolStation(1, petrolStationAmount, 68)),
                new Thread(new PetrolStation(2, petrolStationAmount, 20)),
                new Thread(new PetrolStation(3, petrolStationAmount, 35))};
        for (Thread t:threads) {
            t.start();
        }

        System.out.println("Остаток литров на станции: " + petrolStationAmount.getAmount());

        }

    }

