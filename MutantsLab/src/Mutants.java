import java.util.Scanner;

public class Mutants {
    public static void main(String[] args) {
        String[] adnTest1 = {"TTTCGA",
                             "CTCTAC",
                             "ACTAAG",
                             "ATATAT",
                             "CACCTC",
                             "TATATG"};
        System.out.println("Primer test: " + isMutant(adnTest1));
        //Tiene una horizontal con la secuencia "TTTT" y una secuencia
        // "AAAA" en una
        // diagonal de derecha a izquierda, por lo tanto, retorna true

        String[] adnTest2 = {"TTTCGA",
                             "CCCTAC",
                             "ACTAAA",
                             "TTTTAT",
                             "CACATC",
                             "TAAATG"};
        System.out.println("Segundo test: " + isMutant(adnTest2)); //Tiene una horizontal con la secuencia "TTTT" y
        // una secuencia "AAAA" en una
        // diagonal de derecha a izquierda, por lo tanto, retorna true

        String[] adnTest3 = {"GTTCGA",
                             "GTCTAC",
                             "GCTAAG",
                             "GTTTAT",
                             "TTCCCC",
                             "TATATG"};
        System.out.println("Tercer test: " + isMutant(adnTest3)); //Tiene una secuencia "GGGG" en la primera
        // vertical, y una secuencia
        // "CCCC" en la penúltima horizontal, por lo tanto, retorna true
        String[] adnTest4 = {"TTTCGA",
                             "CTCTAC",
                             "ACTAAG",
                             "ATTTAT",
                             "CACCTC",
                             "TATATG"};
        System.out.println("Cuarto test: " + isMutant(adnTest4)); //Solamente tiene una secuencia "TTTT" en la
        // diagonal principal, por
        // lo tanto, retorna false

        String[] adn = new String[6];
        Scanner input = new Scanner(System.in);
        int j = 5;

        for (int i = 0; i < 6; i++) {
            while(true){
                System.out.println("Recordatorio: Los genes puede ser A,G,C o T");
                System.out.println("Ingrese los 6 genes en una linea: ");
                String stringAdn = input.nextLine();
                if (stringAdn.length() == 6 && containsAdn(stringAdn)){
                    System.out.println("Recibido.");
                    if (j != 0){
                        System.out.println(j + " linea/s restante/s...");
                    }
                    j -= 1;
                    adn[i] = stringAdn;
                    break;
                }
                else{
                    System.out.println("Ha ingresado los genes incorrectamente...");
                    System.out.println("Intente de nuevo.");
                    continue;
                }
            }
        }
        System.out.println(" ");
        System.out.println("Matriz ingresada: ");
        for (int i = 0; i < 6; i++) {
            System.out.println(adn[i]);
        }
        System.out.println(" ");
        if (isMutant(adn)){
            System.out.println("Es mutante.");
        }
        else{
            System.out.println("No es mutante.");
        }
    }
    public static int isDiagonal(String[] adnArray) {
        int count = 0;
        StringBuilder temporalString = new StringBuilder();
        //Verifico la diagonal principal
        for (int i = 0; i < 4; i++) {
            temporalString.append(adnArray[i].charAt(i));
            if(i == 3){
                if (isSequence(temporalString)){
                    count += 1;
                }
                else{
                    temporalString.setLength(0);
                    for (int j = 1; j < 5; j++) {
                        temporalString.append(adnArray[j].charAt(j));
                        if(j == 4){
                            if (isSequence(temporalString)) {
                                count += 1;
                            }
                            else{
                                temporalString.setLength(0);
                                for (int k = 2; k < 6; k++) {
                                    temporalString.append(adnArray[k].charAt(k));
                                    if(k == 5){
                                        if (isSequence(temporalString)) {
                                            count += 1;
                                        }
                                        else{
                                            continue;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        temporalString.setLength(0);
        //Verifico la primera diagonal bajo la principal
        for (int i = 0; i < 4; i++) {
            temporalString.append(adnArray[i+1].charAt(i));
            if(i == 3){
                if (isSequence(temporalString)){
                    count += 1;
                }
                else{
                    temporalString.setLength(0);
                    for (int j = 1; j < 5; j++) {
                        temporalString.append(adnArray[j+1].charAt(j));
                        if(j == 4){
                            if (isSequence(temporalString)) {
                                count += 1;
                            }
                            else{
                                continue;
                            }
                        }
                    }
                }
            }

        }
        temporalString.setLength(0);
        //Verifico la segunda diagonal bajo la principal
        for (int i = 0; i < 4; i++) {
            temporalString.append(adnArray[i+2].charAt(i));
            if (i == 3) {
                if (isSequence(temporalString)) {
                    count += 1;
                }
                else{
                    continue;
                }
            }
        }
        temporalString.setLength(0);
        //Verifico la primera diagonal arriba de la principal
        for (int i = 0; i < 4; i++) {
            temporalString.append(adnArray[i].charAt(i+1));
            if(i == 3){
                if (isSequence(temporalString)){
                    count += 1;
                }
                else{
                    temporalString.setLength(0);
                    for (int j = 1; j < 5; j++) {
                        temporalString.append(adnArray[j].charAt(j+1));
                        if(j == 4){
                            if (isSequence(temporalString)) {
                                count += 1;
                            }
                            else{
                                continue;
                            }
                        }
                    }
                }
            }

        }
        temporalString.setLength(0);
        //Verifico la segunda diagonal arriba de la principal
        for (int i = 0; i < 4; i++) {
            temporalString.append(adnArray[i].charAt(i+2));
            if (i == 3) {
                if (isSequence(temporalString)) {
                    count += 1;
                }
                else{
                    continue;
                }
            }
        }

        return count;

        }
        public static int isReverseDiagonal(String[] adnArray){
            int count = 0;
            StringBuilder temporalString = new StringBuilder();
            int col = 5;
        //Verifico la diagonal principal inversa
            for (int i = 0; i < 4; i++) {
                temporalString.append(adnArray[i].charAt(col));
                col -= 1;
                if(i == 3){
                    if(isSequence(temporalString)){
                        count += 1;
                    }
                    else{
                        temporalString.setLength(0);
                        col = 4;
                        for(int j = 1; j < 5; j++) {
                            temporalString.append(adnArray[j].charAt(col));
                            col -= 1;
                            if (j == 4){
                                if (isSequence(temporalString)){
                                    count += 1;
                                }
                                else{
                                    temporalString.setLength(0);
                                    col = 3;
                                    for (int k = 2; k < 6; k++) {
                                        temporalString.append(adnArray[k].charAt(col));
                                        col -= 1;
                                        if(k == 5){
                                            if (isSequence(temporalString)){
                                                count += 1;
                                            }
                                            else{
                                                continue;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            temporalString.setLength(0);
            col = 5;
            //Verifico la primera diagonal bajo la principal inversa
            for(int i = 1; i < 5; i++) {
                temporalString.append(adnArray[i].charAt(col));
                col -= 1;
                if (i == 4) {
                    if (isSequence(temporalString)) {
                        count += 1;
                    } else {
                        temporalString.setLength(0);
                        col = 4;
                        for (int j = 2; j < 6; j++) {
                            temporalString.append(adnArray[j].charAt(col));
                            col -= 1;
                            if (j == 5) {
                                if (isSequence(temporalString)) {
                                    count += 1;
                                } else {
                                    continue;
                                }
                            }
                        }
                    }
                }
            }
            temporalString.setLength(0);
            col = 5;
            //Verifico la segunda diagonal bajo la principal inversa
            for (int i = 2; i < 6; i++) {
                temporalString.append(adnArray[i].charAt(col));
                col -= 1;
                if (i == 5) {
                    if (isSequence(temporalString)) {
                        count += 1;
                    } else {
                        continue;
                    }
                }
            }
            temporalString.setLength(0);
            col = 4;
            //Verifico la primera diagonal arriba de la principal inversa
            for (int i = 0; i < 4; i++) {
                temporalString.append(adnArray[i].charAt(col));
                col -= 1;
                if (i == 3) {
                    if (isSequence(temporalString)) {
                        count += 1;
                    } else {
                        temporalString.setLength(0);
                        col = 3;
                        for (int j = 1; j < 5; j++) {
                            temporalString.append(adnArray[j].charAt(col));
                            col -= 1;
                            if (j == 4) {
                                if (isSequence(temporalString)) {
                                    count += 1;
                                }
                                else{
                                    continue;
                                }
                            }
                        }
                    }
                }
            }
            temporalString.setLength(0);
            col = 3;
            //Verifico la segunda diagonal arriba de la principal inversa
            for (int i = 0; i < 4; i++) {
                temporalString.append(adnArray[i].charAt(col));
                col -= 1;
                if (i == 3) {
                    if (isSequence(temporalString)) {
                        count += 1;
                    }
                }
            }
            return count;

        }
        public static int isHorizontal(String[] adnArray){
            int count = 0;
            StringBuilder temporalString = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                temporalString.setLength(0);
                for (int j = 0; j < 4; j++) {
                    temporalString.append(adnArray[i].charAt(j));
                    if (j == 3){
                        if(isSequence(temporalString)){
                          count += 1;
                        }
                        else{
                            temporalString.setLength(0);
                            for (int k = 1; k < 5; k++) {
                                temporalString.append(adnArray[i].charAt(k));
                                if (k == 4){
                                    if(isSequence(temporalString)){
                                        count += 1;
                                    }
                                    else{
                                        temporalString.setLength(0);
                                        for (int l = 2; l < 6; l++) {
                                            temporalString.append(adnArray[i].charAt(l));
                                            if (l == 5){
                                                if (isSequence(temporalString)){
                                                    count += 1;
                                                }
                                                else{
                                                    temporalString.setLength(0);
                                                    continue;
                                                }
                                            }
                                        }
                                    }
                                }

                            }
                        }
                    }
                }
            }

        return count;
        }
        public static int isVertical(String[] adnArray){
            int count = 0;
            StringBuilder temporalString = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                temporalString.setLength(0);
                for (int j = 0; j < 4; j++) {
                    temporalString.append(adnArray[j].charAt(i));
                    if (j == 3){
                        if(isSequence(temporalString)){
                            count += 1;
                        }
                        else{
                            temporalString.setLength(0);
                            for (int k = 1; k < 5; k++) {
                                temporalString.append(adnArray[k].charAt(i));
                                if (k == 4){
                                    if(isSequence(temporalString)){
                                        count += 1;
                                    }
                                    else{
                                        temporalString.setLength(0);
                                        for (int l = 2; l < 6; l++) {
                                            temporalString.append(adnArray[l].charAt(i));
                                            if (l == 5){
                                                if (isSequence(temporalString)){
                                                    count += 1;
                                                }
                                                else{
                                                    temporalString.setLength(0);
                                                    continue;
                                                }
                                            }
                                        }
                                    }
                                }

                            }
                        }
                    }
                }
            }

            return count;
        }
        public static boolean isSequence(StringBuilder adnString){
            String a_adn = "AAAA";
            String t_adn = "TTTT" ;
            String c_adn = "CCCC";
            String g_adn = "GGGG";
            return a_adn.contentEquals(adnString) || t_adn.contentEquals(adnString)
                    || c_adn.contentEquals(adnString) || g_adn.contentEquals(adnString);
        }
        public static boolean containsAdn(String adnString){
            int count = 0;
            char[] possibleAdn = {'A','G','T','C'};
            for (int i = 0; i < 6; i++) {
                for (char element : possibleAdn){
                    if (adnString.charAt(i) == element){
                        count += 1;
                        break;
                    }
                }
            }
            return count == 6;
        }
        public static boolean isMutant(String[] adnArray){
            int total = isDiagonal(adnArray) + isHorizontal(adnArray) + isVertical(adnArray) + isReverseDiagonal(adnArray);
            return total >= 2;
        }

    }

