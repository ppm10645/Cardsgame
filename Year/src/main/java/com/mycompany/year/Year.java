public class Year {
    private boolean leapYear;

    // Constructor que recibe si el año es bisiesto
    public Year(boolean leapYear) {
        this.leapYear = leapYear;
    }

    // Método para mostrar los días de un mes
    public void showDaysOfMonth(int month) {
        if (month < 1 || month > 12) {
            System.out.println("Mes incorrecto. Introduce un valor entre 1 y 12.");
            return;
        }

        int days;
        switch (month) {
            case 4: case 6: case 9: case 11:
                days = 30;
                break;
            case 2:
                days = (leapYear) ? 29 : 28;
                break;
            default:
                days = 31;
        }
        System.out.println("O mes " + month + " ten " + days + " días.");
    }

    // Método main para probar el funcionamiento
    public static void main(String[] args) {
        Year nonLeapYear = new Year(false); // Año no bisiesto
        Year leapYear = new Year(true);     // Año bisiesto

        nonLeapYear.showDaysOfMonth(2); // Debe imprimir: "O mes 2 ten 28 días."
        leapYear.showDaysOfMonth(2);    // Debe imprimir: "O mes 2 ten 29 días."
        leapYear.showDaysOfMonth(4);    // Debe imprimir: "O mes 4 ten 30 días."
        leapYear.showDaysOfMonth(13);   // Mes incorrecto, imprime mensaje de error.
    }
}
