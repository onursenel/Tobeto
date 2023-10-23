package intro;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		
		
		//değişken isimlendirmeleri CamelCase olarak yazılır.
		String ortaMetin = "İlginizi Çekebilir.";
		String altMetin = "Vade Süresi";
		
		System.out.println(ortaMetin);
		
		//tamsayı - integer
		int vade = 36;
		
		double dolarDun=28.11;
		double dolarBugun = 28.11;
		
		boolean dolarDustuMu = true;
		
		String okYonu = "";
		
		if(dolarBugun < dolarDun) {//true durumu
			okYonu = "down.png";
			System.out.println(okYonu);
		}
		else if(dolarBugun > dolarDun ) {
			okYonu = "up.png";
			System.out.println(okYonu);
			
		}
		
		
		else {
			okYonu = "equal.png";
			System.out.println(okYonu);

		}
		
		//Array -Liste
		
		String [] krediler =  {"Hızlı kredi ", "Maaşını Halkbanktan alanlar","Mutlu Emekli"};
		
//		System.out.println(krediler[0]);
//		System.out.println(krediler[1]);
//		System.out.println(krediler[2]);
		
		
		
		//for döngüsü
		for (int i = 0; i < krediler.length; i++) {
			System.out.println(krediler[i]);
			
		}
		
		

	}

}
