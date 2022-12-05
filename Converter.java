public class Converter {
    double km = 0.00;
    double Kkal = 0.00;
    public double averageKm(double totalStep) {
        km = (totalStep*0.75)/1000;
        return km;
    }
    public double burnedСalories(double totalStep) {
        Kkal = (totalStep * 50) / 1000;
        return Kkal;
    }
}
