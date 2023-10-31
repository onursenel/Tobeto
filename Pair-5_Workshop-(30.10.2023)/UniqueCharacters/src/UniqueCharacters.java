public class UniqueCharacters {
    public static boolean hasUniqueChar (String str) {

        boolean[] charSet = new boolean[256]; // ASCII Tablosundaki karakterler varsayılıyor.

        for (int i = 0; i < str.length(); i++) {

            int val = str.charAt(i); // Bu metot geriye karakterin ASCII tablosundaki int değerini döndürür.

            if (charSet[val]) {
                return false; // Karakter mevcut ise false döner.
            }
            charSet[val] = true;
        }

        return true;
    }
}
