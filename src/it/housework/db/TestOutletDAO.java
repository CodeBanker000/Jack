package it.housework.db;

public class TestOutletDAO
{

    public static void main(String[] args)
    {
        OutletDAO dao = new OutletDAO();
        
        long start, end;
        

        
        start = System.nanoTime();
//        dao.update(13, "ciao", false);
        end = System.nanoTime();
        System.out.format("Metodo update: %d ms/n", (end-start) / 1000000);
        
        
    }

}
