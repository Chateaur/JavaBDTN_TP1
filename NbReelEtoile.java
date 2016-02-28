import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NbReelEtoile {
	
	private File file;
	private Scanner scanner;
	private String line;
	private int countColon;
	private int rates[];
	private long start;
    private long timeExec;
    private int i;
	
	public NbReelEtoile(){

		start = System.currentTimeMillis();

		rates = new int[5];
		for(int j = 0; j < 5; j++){
			rates[j] = 0;
		}

		file = new File("C:\\Users\\Florent\\Documents\\cours\\JavaBigData\\Movielens\\ml-10M100K\\ratings.dat");

		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while(scanner.hasNext()){

			countColon = 0;
			i = 0;

			line = scanner.nextLine();
			while(i < line.length() && countColon < 4){
				if(line.charAt(i) == ':'){
					countColon++;
				}
				i++;
			}
			
			switch(line.charAt(i)){
			case '1' : 
				rates[0]++;
				break;
			case '2' : 
				rates[1]++;
				break;
			case '3' : 
				rates[2]++;
				break;
			case '4' : 
				rates[3]++;
				break;
			case '5' : 
				rates[4]++;
				break;
			}
		}

		scanner.close();
		printRates();
		timeExec = System.currentTimeMillis()-start;
        System.out.println("Temps d'execution : " + timeExec + "ms");
	}

	public void printRates(){
		System.out.println("***** Nombre REEL !!! *****");
        System.out.println("Nombre de films a 1 " + rates[0]);
        System.out.println("Nombre de films a 2 " + rates[1]);
        System.out.println("Nombre de films a 3 " + rates[2]);
        System.out.println("Nombre de films a 4 " + rates[3]);
        System.out.println("Nombre de films a 5 " + rates[4]);
        System.out.println("");
        System.out.println("");
    }
}