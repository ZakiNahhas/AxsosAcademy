import java.util.*;

class Meth {
    Random rando = new Random();

    public ArrayList<Integer> getTenRolls() {
        ArrayList<Integer> randArray = new ArrayList<Integer>();
        Random rando = new Random();
        for (int i = 0; i < 10; i += 1) {
            randArray.add(rando.nextInt(21));
        }
        return randArray;
    }

    public String getRandomLetter() {
        String[] arr = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
                "t", "u", "v", "w", "x", "y", "z", "%", "S", ")", "!", "#" };

        int randLetter = rando.nextInt(arr.length);
        String randomLetter = arr[randLetter];
        return randomLetter;
    }

    public String generatePassword() {
        String password = "";
        for (int i = 0; i < 8; i++) {
            password += this.getRandomLetter();
        }
        return password;
    }

    public String generatePassword(int lengthOfPassword) {
        String password = "";
        for (int i = 0; i < lengthOfPassword; i++) {
            password += this.getRandomLetter();
        }
        return password;
    }

    // Sensei Bonus || Failure
    public void shuffeledArray() {
        String[] shuffeledArray= { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
        "t", "u", "v", "w", "x", "y", "z", "%", "S", ")", "!", "#" };
        int index = rando.nextInt(shuffeledArray.length);
        int index2 = rando.nextInt(shuffeledArray.length);
        String swap;
        for (int i = 0; i < shuffeledArray.length; i++) {
            swap = shuffeledArray[i];
            shuffeledArray[i] = shuffeledArray[index];
            shuffeledArray[index] = shuffeledArray[i];
            shuffeledArray[i] = shuffeledArray[index2];
            System.out.println("Your new shuffeled-by-index array: ");
            for (int j = 0; j < shuffeledArray.length; j+=2) {
                System.out.print(shuffeledArray[j]);
            }
        }
    }
}