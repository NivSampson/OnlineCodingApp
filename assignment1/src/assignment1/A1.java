package assignment1;

public class A1 {
    public static double calculateSalary(int wage, int extraWage, int extraHours, int numOfDeals) {
        if (numOfDeals <= 4) {
            return wage + (extraWage * extraHours);
        }
        if (numOfDeals > 4 && numOfDeals <= 7) {
            if (extraHours < 10) {
                return wage + wage * 0.05 + (extraWage * extraHours);

            } else {
                return wage + wage * 0.1 + (extraWage * extraHours);
            }
        }
        if (numOfDeals > 7) {
            if (extraHours < 5) {
                return wage + numOfDeals * 0.02 * wage + (extraWage * extraHours);
            } else {
                return wage + numOfDeals * 0.03 * wage + (extraWage * extraHours);
            }
        }

        return -1;
    }

    public static int oddNumber(int num) {
        int res = 0;
        int dig;
        while (num > 0) {
            dig = num % 10;
            if (dig % 2 != 0) {
                res = res * 10 + dig;
            }
            num /= 10;
        }
        if (res == 0) {
            return 0;
        }
        int new_result = 0;
        while (res > 0) {
            new_result = new_result * 10 + res % 10;
            res /= 10;
        }
        return new_result;
    }

    public static int sumOfDigits(int num) {
        if (num < 0) {
            return -1;
        }
        if (num < 10) {
            return num;
        }
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sumOfDigits(sum);
    }


    public static int contains(int[] arr1, int[] arr2) {

        if (arr1 == null && arr2==null  ) {
            return 0;
        }
        if (arr1==null){
            return -1;
        }
        if (arr2==null){
            return 0;
        }



        for (int i = 0; i <= arr1.length - arr2.length; i++) {
            int flag = 0;
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i + j] != arr2[j]) {
                    flag = 1;

                }
            }
            if (flag == 0) {
                return i;
            }
        }
        return -1;
    }

    public static int[][] flipMatrix(int[][] arr, int option) {
        if (arr==null ){
            return null;
        }
        if (arr.length==0){
            return null;
        }

        int l_matrix=arr.length;
        int[][] help_matrix = new int[l_matrix][l_matrix];
        int your_option=option;
        if (your_option==1) {


            for (int i = 0; i < l_matrix; i++) {
                for (int j = 0; j < l_matrix; j++) {
                    help_matrix[j][l_matrix - 1 - i] = arr[i][j];
                }
            }

        }
        if (your_option==2) {


            for (int i = 0; i < l_matrix; i++) {
                for (int j = 0; j < l_matrix; j++) {
                    help_matrix[l_matrix - 1 - j][i] = arr[i][j];
                }
            }

        }
        if (your_option==3) {


            for (int i = 0; i < l_matrix; i++) {
                for (int j = 0; j < l_matrix; j++) {
                    help_matrix[l_matrix - 1 - i][j] = arr[i][j];
                }
            }

        }
        if (your_option==4) {


            for (int i = 0; i < l_matrix; i++) {
                for (int j = 0; j < l_matrix; j++) {
                    help_matrix[i][l_matrix - 1 - j] = arr[i][j];
                }
            }

        }

        return help_matrix;
    }

}
