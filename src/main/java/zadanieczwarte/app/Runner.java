package zadanieczwarte.app;

import zadanieczwarte.model.Figura;
import zadanieczwarte.model.Kwadrat;
import zadanieczwarte.service.Calculate;
import zadanieczwarte.service.FileOperations;
import java.util.Arrays;
import java.util.List;

//uwaga Polskie nazwy klas zostawilem poniewaz w poleceniu byl przyklad z polskimi
public class Runner {
    public static void main(String[] args) {
        //List<Figura> figury = Arrays.asList(Figura.stworzKwadrat(10), Figura.stworzKolo(20), Figura.stworzProstokat(10,20));
        List<Figura> figury = Arrays.asList(Figura.stworzKwadrat(10), Figura.stworzKolo(20), Figura.stworzProstokat(10,20));
        for(Figura f : figury) {
            System.out.println(f);
        }
        //System.out powinien wypisac:
        //Figura nr 1: Kwadrat o boku 10.
        //Figura nr 2: Ko�o o promienu 10.
        //Figura nr 3: Prostokat o bokach 10x20.
        System.out.println("---------");

        //b) Nast�pnie:
        //- znajd� figur� z najwi�kszym obwodem
        //- znajd� figur� z najwi�kszym polem
        Calculate calculate = new Calculate(figury);
        System.out.println("calculate.getFiguraWithMaxArea() = " + calculate.getFiguraWithMaxArea());
        System.out.println("calculate.getFiguraWithMaxPerimeter() = " + calculate.getFiguraWithMaxPerimeter());

        System.out.println("---------");
        System.out.println(figury.contains(new Kwadrat(10))); //powinno wypisc true
        System.out.println("---------");

        //d
        //- stworz metode pozwalaj�c� zapisa� liste figur do pliku w taki spos�b aby...
        //- ... aby mo�na by�o stworzy� metod� wczytuj�c� liste figur  z pliku.
        FileOperations fileOperations = new FileOperations();
        fileOperations.save("figury.txt", figury);
        List<Figura> figuraList = fileOperations.readFigury("figury.txt");
        for (Figura figura : figuraList) {
            System.out.println(figura);
        }
        System.out.println("---------");
        //numer figury 0
        System.out.println(new Kwadrat(5));

    }

}
