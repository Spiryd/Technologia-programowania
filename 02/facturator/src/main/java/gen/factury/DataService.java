package gen.factury;
//odpowiada za komunikacje z urzytkownikiem
public class DataService {
    private DataBaseInterface dataBaseInterface;

    public DataService(DataBaseInterface dataBaseInterface){
        this.dataBaseInterface = dataBaseInterface;
    }
    public void  dodajDoBazy(Faktura faktura){
        dataBaseInterface.dodajDoBazy(faktura);
    }
}
