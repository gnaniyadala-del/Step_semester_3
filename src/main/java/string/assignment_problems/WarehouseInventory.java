package main.java.string.assignment_problems;


    public class WarehouseInventory {

        public static void main(String[] args) {

            int[] sectionA = {20, 15, 30};
            int[] sectionB = {25, 10, 30};

            System.out.println("Testing Sample Input...");
            analyzeInventory(sectionA, sectionB);
        }


        public static void analyzeInventory(int[] sectionA, int[] sectionB) {
            int totalA = 0;
            int totalB = 0;


            int maxQuantity = Integer.MIN_VALUE;
            String maxSection = "";
            int maxItemNumber = -1;


            for (int i = 0; i < sectionA.length; i++) {

                totalA += sectionA[i];
                totalB += sectionB[i];


                if (sectionA[i] > maxQuantity) {
                    maxQuantity = sectionA[i];
                    maxSection = "Section A";
                    maxItemNumber = i + 1;
                }


                if (sectionB[i] > maxQuantity) {
                    maxQuantity = sectionB[i];
                    maxSection = "Section B";
                    maxItemNumber = i + 1;
                }
            }


            String status = (totalA == totalB) ? "Balanced" : "Not Balanced";


            System.out.println("Section A Total: " + totalA + " | " +
                    "Section B Total: " + totalB + " | " +
                    "Status: " + status + " | " +
                    "Highest Quantity: " + maxQuantity + " (" + maxSection + ", Item " + maxItemNumber + ")");
        }
    }


