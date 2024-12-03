import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String []args){


        Scanner scanner = new Scanner(System.in);

        // Запитуємо користувача ввести номер завдання
        System.out.println("Введіть завдання 1-4");
        int task = scanner.nextInt();  // Отримуємо номер завдання

        // Завдання 1: обчислення математичного виразу з варіантами вхідних даних
        if(task == 1){
            System.out.println("Завдання №1");

            System.out.println("Enter m");
            double m = scanner.nextDouble();  // Вводимо m

            System.out.println("Enter n");
            double n = scanner.nextDouble();  // Вводимо n

            // Обчислюємо вираз із дійсними числами (реальні вхідні дані, реальний вихід)
            double term = (n+1)/(m+2)+(5)/(n-m);
            double result = Math.pow(term,2) * n*m;
            System.out.println("Result (real input, real output):  " + result);

            // Обчислюємо вираз для цілих чисел (цілі вхідні дані, реальний вихід)
            int mInt = (int) m;  // Перетворюємо m на ціле число
            int nInt = (int) n;  // Перетворюємо n на ціле число
            double term2 = (nInt+1)/(mInt+2)+(5)/(nInt-mInt);

            // Пояснюємо, чому результат відрізняється
            System.out.println("У другому виразі буде відрізнятись відповідь через те, що, коли у виразі нашого прикладу, де значення n = 2.0 та m = 3.0");
            System.out.println("Виходить (2+1) / (3+2) = 3/5= 0, якби відповідь була не цілим числом, то мало б бути 0.6");

            double result2 = Math.pow(term2,2) * nInt*mInt;
            System.out.println("Result (integer input, real output):  " + result2);

            // Обчислюємо результат для цілих вихідних даних (реальні вхідні дані, цілий вихід)
            int result3 = (int) result;
            System.out.println("Result (real input, integer output):  " + result3);
        }

        // Завдання 2: обчислення суми чисел масиву A, які перевищують середнє арифметичне
        if(task == 2){
            System.out.println("Завдання №2");

            System.out.println("Enter n");
            int n = scanner.nextInt();  // Вводимо n

            // Перевірка, чи входить n у потрібний діапазон
            if(n < 1 || n > 200){
                System.out.println("n must be between 1 and 200");
                return;
            }

            double[] A = new double[2*n];  // Створюємо масив розміру 2*n
            System.out.println("Enter values for matrix A[2*n]");
            for(int i = 0; i < 2 * n; i++){
                System.out.println("Enter number :");
                A[i] = scanner.nextDouble();  // Вводимо значення в масив
            }

            // Обчислюємо суму перших n елементів для обчислення середнього
            double sumFirstHalf = 0;
            for(int i = 0; i < n ; i++){
                sumFirstHalf += A[i];
            }
            double avgFirstHalf = sumFirstHalf/n;  // Середнє арифметичне

            // Обчислюємо суму тих елементів другої половини масиву, які більше за середнє арифметичне
            double sumSecondHalf = 0;
            for(int i = n; i < 2*n; i++ ){
                if(A[i] > avgFirstHalf){
                    sumSecondHalf += A[i];
                }
            }

            // Виведення результатів
            System.out.println("Result :\n Average of the first half : " + avgFirstHalf);
            System.out.println("Sum of elements in the second half that exceed the average: " + sumSecondHalf);
        }

        // Завдання 3: знайти рядки з однаковими елементами та стовпчики з парними елементами
        if(task == 3){
            System.out.println("Завдання №3");

            System.out.println("Enter size of matrix");
            int size = scanner.nextInt();  // Вводимо розмір матриці
            if(size <1 || size >15){
                System.out.println("Wrong size.");  // Перевірка на діапазон
                return;
            }

            int [][]A = new int[size][size];  // Створюємо матрицю

            // Вводимо значення для матриці
            System.out.println("Enter values for Matrix");
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    System.out.println("Enter value: ");
                    A[i][j] = scanner.nextInt();
                }
            }

            // Перевіряємо рядки на однакові елементи
            System.out.println("Rows with identical elements: ");
            boolean foundidenticalRows = false;

            for(int i = 0; i < size; i++){
                boolean identical = true;
                for(int j = 0; j < size; j++){
                    if(A[i][j] != A[i][0]){  // Перевіряємо, чи всі елементи рядка однакові
                        identical = false;
                        break;
                    }
                }
                if(identical){
                    System.out.println("Row "+(i+1));
                    foundidenticalRows = true;
                }
            }
            if(!foundidenticalRows){
                System.out.println("No rows with identical elements found.");
            }

            // Перевіряємо стовпчики на парні елементи
            System.out.println("Columns with all even elements:");
            boolean foundEvenColumns = false;
            for(int i = 0; i < size; i++){
                boolean allEven = true;
                for(int j = 0; j < size; j++){
                    if(A[j][i] % 2 != 0){  // Перевіряємо, чи всі елементи стовпчика парні
                        allEven = false;
                        break;
                    }
                }
                if(allEven){
                    System.out.println("Column "+(i+1));
                    foundEvenColumns = true;
                }
            }
            if(!foundEvenColumns){
                System.out.println("No columns with all even elements found.");
            }
        }

        // Завдання 4: вилучення слів з подвоєними літерами та виведення результату
        if(task == 4){
            // Введення тексту
            System.out.println("Enter the text:");
            scanner.nextLine();  // Очистка сканера після введення числа
            String text = scanner.nextLine();  // Отримуємо текст від користувача

            // Розбиваємо текст на слова, враховуючи пробіли та розділові знаки
            String[] words = text.split("\\s+|(?=\\p{Punct})|(?<=\\p{Punct})");

            ArrayList<String> removedWords = new ArrayList<>();  // Список слів, які будуть видалені
            ArrayList<String> remainingWords = new ArrayList<>();  // Список слів, що залишаться

            // Перевіряємо кожне слово на наявність подвоєних літер
            for (String word : words) {
                boolean hasDoubleLetters = false;

                // Перевіряємо кожну пару сусідніх літер
                for (int i = 1; i < word.length(); i++) {
                    if (word.charAt(i) == word.charAt(i - 1)) {  // Перевіряємо подвоєння літер
                        hasDoubleLetters = true;
                        break;
                    }
                }

                // Якщо є подвоєння літер, додаємо слово до списку видалених
                if (hasDoubleLetters) {
                    removedWords.add(word);
                } else {
                    remainingWords.add(word);  // Якщо подвоєння немає, слово залишається
                }
            }

            // Формуємо результат у вигляді рядків
            String removedWordsStr = String.join(" ", removedWords);
            String remainingText = String.join(" ", remainingWords);

            // Виводимо вилучені слова та текст, що залишився
            System.out.println("Removed words: " + removedWordsStr);
            System.out.println("Remaining text: " + remainingText);
        }
    }
}
