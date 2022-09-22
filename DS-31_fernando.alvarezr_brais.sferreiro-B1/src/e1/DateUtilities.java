package e1;

public class DateUtilities {

    public static void main(String[] args) {

        System.out.printf(convertToISODate("July 28, 2006"));
    }

    public static boolean isLeap(int year) {

        if (year % 4 == 0 && year % 100 != 0) {

            return true;

        } else if (year % 400 == 0) {

            return true;

        } else {

            return false;
        }

        //return ((year % 4 == 0 ) || (year % 100 == 0 && year % 400 == 0) ? true : false);

    }

    public static int numberOfDays(int month, int year) {

        if(month > 12 || month < 0){
            throw  new IllegalArgumentException();
        }

        else if (month == 2) {

            if (isLeap(year)) return 29;
            else return 28;
        } else if ( month % 2 != 0 && month < 8 || month % 2 == 0&& month >= 8)  {

            return 31;

        } else {

            return 30;
        }

        //(return month == 2 ? isLeap(year) ? 29 : 28 : month % 2 == 0 ? 31 : 30);

    }

    public static String convertToISODate(String dateText) {

        String[] parts = dateText.split(" ", 3);

        String month = parts[0];   //Mes
        String day = parts[1];     //Dia,
        String year = parts[2];     //año

        day = day.substring(0, day.length() - 1);

        switch (month) {

            case "January":
                month = "01";
                break;

            case "February":
                month = "02";
                break;

            case "March":
                month = "03";
                break;
            case "April":
                month = "04";
                break;

            case "May":
                month = "05";
                break;

            case "June":
                month = "06";
                break;

            case "July":
                month = "07";
                break;

            case "August":
                month = "08";
                break;

            case "September":
                month = "09";
                break;

            case "October":
                month = "10";
                break;

            case "November":
                month = "11";
                break;

            case "December":
                month = "12";
                break;

            default:
                throw new IllegalArgumentException("Wrong Month");
        }
        return year + "-" + month + "-" + day;

        //Me da pereza hacer en una linea el switch
    }


    public static boolean checkISODate(String ISODate) {

        String[] parts = ISODate.split("-", 3);

        int year = Integer.parseInt(parts[0]);   //Año
        int month = Integer.parseInt(parts[1]);     //mes
        int day = Integer.parseInt(parts[2]);     //dia

        for (char ch : ISODate.toCharArray()) {

            if (!Character.isDigit(ch) && ch != '-') {

                return false;
            }
        }
        if (month < 0 || day < 0 || year < 0 || month > 12) {

            return false;
        }
        if (day > numberOfDays(month, year)) {

            return false;
        }

        return true;
    }
}


