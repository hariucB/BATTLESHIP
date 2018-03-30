public class RandomCoordinateFactory {

    private int Xr; // dimensiunile maxime ale frame-ului
    private int Yr;
    public RandomCoordinateFactory()
    {

    }
    public RandomCoordinateFactory(int Xr, int Yr)
    {
        this.Xr = Xr;
        this.Yr = Yr;
    }
    public int RandomX()
    {
        return (int)Math.floor(Math.random() * 200);
    }
    public int RandomY()
    {
        return (int)Math.floor(Math.random() * 465 );
    }
}
