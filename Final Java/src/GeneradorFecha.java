import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;


public class GeneradorFecha {

    public LocalDate GenerarFechaAleatoria() {
        Random random = new Random();
        long minDay = LocalDate.of(1724, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(2010, 12, 31).toEpochDay();
        long randomDay = minDay + random.nextInt((int) (maxDay - minDay));
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        return randomDate;
    }


}
