import java.util.*;

public class AcakKata {
	public static final String BENAR = "BENAR!";
	public static final String GARIS = "======================== ACAK KATA ===========================";
	public static final String SALAH = "SALAH! Silahkan coba lagi";

	public static ArrayList<String> kumpulan_kata;

	public static boolean play;
	public static boolean answer;
	
	public static void main (String[] args) {
		initialize();
		String input = "";

		Scanner scan = new Scanner(System.in);
		play = true;

		while (play) {
			answer = false;
			String kata = randomize();
			System.out.println("Tebak kata : " + acak(kata));


			while (!answer) {
				System.out.print("Jawab : ");
				String jawaban = scan.next();

				if (jawaban.equalsIgnoreCase(kata)) {
					answer = true;
					System.out.println(BENAR);
					System.out.println(GARIS);

				} else {
					System.out.println(SALAH);					
				}
			}
		}
		
	}

	public static void initialize() {
		kumpulan_kata = new ArrayList<String>();
		kumpulan_kata.add("buku");
		kumpulan_kata.add("meja");
		kumpulan_kata.add("lemari");
		kumpulan_kata.add("kulkas");
		kumpulan_kata.add("kucing");
		kumpulan_kata.add("ikan");

	}

	public static String randomize() {
		Random rn = new Random();
		int i = rn.nextInt(kumpulan_kata.size());

		return kumpulan_kata.get(i);

	}

	public static String acak (String kata) {
        Random rn = new Random();
        boolean[] flag = new boolean[kata.length()];

		StringBuffer randStr = new StringBuffer();

        for (int i = 0; i < kata.length(); i++) {
            int number = rn.nextInt(kata.length());

            while (flag[number]) {
	            number = rn.nextInt(kata.length());
            }
            flag[number] = true;

            char ch = kata.charAt(number);
            randStr.append(ch);
        }
		return randStr.toString();
	}
}