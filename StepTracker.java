public class StepTracker {

    MonthData[] monthToData;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    int goalDays = 10000;

    class MonthData {
        int[] dayStep = new int[30];
        Converter convert = new Converter();

        void insertDayStep(int day, int step) {
            dayStep[day - 1] = dayStep[day - 1] + step;
        }

        void allStatic() {
            staticMonth();
            totalStepForMonth();
            maxStepDay();
            averageStepForMonth();
            averageKilometers();
            calories();
            bestDaySeries();
        }

        void staticMonth() {
            for (int index = 0; index < dayStep.length; index++) {
                System.out.print((index + 1) + " день:" + dayStep[index] + " ");
            }
        }

        void totalStepForMonth() {
            int totalStep = 0;
            for (int i = 0; i < dayStep.length; i++) {
                totalStep = totalStep + dayStep[i];
            }
            System.out.println("\nОбщее количество шагов за месяц: " + totalStep);
        }

        void maxStepDay() {
            int maxStep = 0;
            int numberDay = 0;
            for (int i = 0; i < dayStep.length; i++) {
                if (dayStep[i] > maxStep) {
                    maxStep = dayStep[i];
                    numberDay = i;
                }
            }
            System.out.println("Максимальное количество шагов в день: " + maxStep + ", это было в " + (numberDay + 1) + " день!");
        }

        void averageStepForMonth() {
            double totalStep = 0;
            for (int i = 0; i < dayStep.length; i++) {
                totalStep = totalStep + dayStep[i];
            }
            System.out.println("Среднее количество шагов в день " + totalStep / dayStep.length + " шагов");
        }

        void averageKilometers() {
            double totalStep = 0;
            for (int i = 0; i < dayStep.length; i++) {
                totalStep = totalStep + dayStep[i];
            }
            String result = String.format("%.2f", convert.averageKm(totalStep));
            System.out.println("Пройденная дистанция в км: " + result);
        }

        void calories() {
            double totalStep = 0;
            for (int i = 0; i < dayStep.length; i++) {
                totalStep = totalStep + dayStep[i];
            }
            System.out.println("Количество сожженых килокалорий: " + convert.burnedСalories(totalStep));
        }

        void bestDaySeries() {
            int bestSeries = 0;
            int liderDays = 0;
            int indexDays = 0;
            for (int i = 0; i < dayStep.length; i++) {
                if (dayStep[i] >= goalDays) {
                    ;
                    bestSeries = bestSeries + 1;
                } else if (bestSeries>liderDays) {
                    liderDays = bestSeries;
                    bestSeries = 0;
                    indexDays = i+1;
                } else {
                    bestSeries = 0;
                }
            }
            System.out.println("Лучшая серия дней, с количеством шагов больше или равно цели ("+goalDays+"):");
            System.out.println(liderDays+" дней подряд, с "+(indexDays-liderDays)+ " по "+(indexDays-1)+" день");
        }
    }
}